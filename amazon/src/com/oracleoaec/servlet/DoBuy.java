package com.oracleoaec.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracleoaec.entity.HwuaUser;
import com.oracleoaec.entity.Order;
import com.oracleoaec.entity.OrderDetail;
import com.oracleoaec.entity.OrderView;
import com.oracleoaec.entity.Shopping;
import com.oracleoaec.service.OrderDetailService;
import com.oracleoaec.service.ProductService;
import com.oracleoaec.serviceImpl.CartServiceImpl;
import com.oracleoaec.serviceImpl.OrderServiceImpl;
import com.oracleoaec.serviceImpl.OrderDetailServiceImpl;
import com.oracleoaec.serviceImpl.ProductServiceImpl;


public class DoBuy extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		HwuaUser user=(HwuaUser)req.getSession().getAttribute("user");
		Order order = new Order();
		order.setHoUserId(user.getUserId());
		order.setHoUserName(user.getUserName());
		order.setHoUserAddress(user.getAddress());
		order.setHoCreateTime(new java.sql.Date(new Date().getTime()));
		order.setHoStatus(1l);
		order.setHoType(1l);
		
		List<Shopping> shopingList = ShoppingView.getShopingList(req, resp);
		
		
		Double hoCost=0.0;
		Double allCost=0.0;
		OrderDetailService iodb=new OrderDetailServiceImpl();
		ProductService pts = new ProductServiceImpl();
		for (Shopping s : shopingList) {
//			System.out.println(s);
			if(pts.findProductById(s.getHpId()).getHpStock()<=0){
				allCost=0d;
				break;
			}
			hoCost=s.getHpPrice()*s.getQuantity();
			allCost=allCost+hoCost;
		}
		
//		System.out.println("订单总额:"+allCost);
		order.setHoCost(allCost);
		
		
		OrderView orderView = new OrderView();
		if(order.getHoCost()>0){//下单成功  添加订单明细  修改商品库存
			Long orderId = iodb.getOrderId();//获得订单的Id
			order.setHoId(orderId);
			orderView.setOder(order);//设置订单值
			new OrderServiceImpl().addOrder(order);//添加订单表数据
			orderView.setShoppinglist(shopingList );//设置购买时的shoppinglist
			for (Shopping s : shopingList) {
				iodb.addOrderDetail(new OrderDetail(orderId,s.getHpId(),s.getQuantity(),s.getHpPrice()*s.getQuantity()));
				new ProductServiceImpl().changeStock(s.getHpStock()-s.getQuantity(),s.getHpId());
			}
			int emptyCarts = new CartServiceImpl().emptyCarts(user.getUserId());
			if(emptyCarts>0)req.getSession().setAttribute("cartCount", "");
			resp.sendRedirect("shopping-result.jsp");
		}else{
			resp.getWriter().write("alert('下单失败！即将跳转到首页！')");
			resp.sendRedirect("index.jsp");
		}
		req.getSession().setAttribute("orderView", orderView);
		
	}
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	
	}
	
	
	
	
	
	
	
	

}
