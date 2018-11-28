package com.oracleoaec.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracleoaec.entity.Cart;
import com.oracleoaec.entity.HwuaUser;
import com.oracleoaec.entity.Product;
import com.oracleoaec.entity.Shopping;
import com.oracleoaec.serviceImpl.CartServiceImpl;
import com.oracleoaec.serviceImpl.ProductServiceImpl;

public class ShoppingView extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//根据用户ID便利购物车获得所有的购物车对象
		req.setAttribute("shoppingList",ShoppingView.getShopingList(req, resp) );
		req.getRequestDispatcher("shopping.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
	/**
	 * 获得shoppinglist的静态封装方法
	 * @param req
	 * @param resp
	 * @return
	 */
	public static List<Shopping> getShopingList(HttpServletRequest req, HttpServletResponse resp){
		HwuaUser user=(HwuaUser)req.getSession().getAttribute("user");
		List<Cart> carts = new CartServiceImpl().usersCarts(user.getUserId());
		List<Shopping> shoppingList=new ArrayList<>();
		if(carts!=null){
			//根据购物车对象的pid查询相关商品的信息
			for (Cart c : carts) {
				Product product = new ProductServiceImpl().findProductById(c.getPid());
				Shopping shoping=new Shopping(c.getId(),product.getHpId(),product.getHpFileName(), product.getHpName(), 
						product.getHpPrice(), c.getQuantity(),product.getHpStock());
				shoppingList.add(shoping);
			}
		}
		
		return shoppingList;
		
	}
	
	
	

}
