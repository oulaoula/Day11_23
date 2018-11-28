package com.oracleoaec.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracleoaec.entity.HwuaUser;
import com.oracleoaec.entity.Product;
import com.oracleoaec.serviceImpl.CategoryServiceImpl;
import com.oracleoaec.serviceImpl.ProductServiceImpl;

public class ProductView extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pId = req.getParameter("pId");
		Long hpId = Long.valueOf(pId);
		Product product = new ProductServiceImpl().findProductById(hpId);
		Object[][] allCategory = new CategoryServiceImpl().getAllCategory();
		req.setAttribute("categoryInfo", allCategory);
		String[]  categoryInfo= new CategoryServiceImpl().categoryForProduct(product.getHpcId(), product.getHpcChildId());
		String[] categoryForProduct=new String[4];
		categoryForProduct[0]=product.getHpcId().toString();
		categoryForProduct[1]=categoryInfo[0];
		categoryForProduct[2]=product.getHpcChildId().toString();
		categoryForProduct[3]=categoryInfo[1];
		
		
		/*for (String string : categoryForProduct) {
			System.out.println(string);
		}*/
		HwuaUser user=(HwuaUser)req.getSession().getAttribute("user");
		
		if(user!=null){//用户已登录
			//cookie保存用户浏览产品情况 key:userid+pId value:pId
			Cookie cookieViewed = new Cookie(""+user.getUserId()+"--"+pId, pId);
			cookieViewed.setMaxAge(60*60*24*7);
			resp.addCookie(cookieViewed);
			List<Cookie> cookieList=new ArrayList<>();
			Cookie[] cookies = req.getCookies();
			if(cookies!=null&&cookies.length>0){//获取浏览器所有的cookie
				for (Cookie cookie : cookies) {
					if(cookie.getName().startsWith(""+user.getUserId())){
						cookieList.add(cookie);//遍历cookie 把当前用户的cookie取出 用List<Cookie>保存
						if(cookieList.size()>5){
							cookie.setMaxAge(0);;//当前用户的cookie超过了5个，删除最早的那个
						}
					}
				}
			}
			
		}
		
		req.setAttribute("productInfo", product);
		req.setAttribute("categoryForProduct", categoryForProduct);
		req.getRequestDispatcher("product_view.jsp").forward(req, resp);
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	
	
	
	
	
}
