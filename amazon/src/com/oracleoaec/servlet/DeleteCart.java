package com.oracleoaec.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracleoaec.entity.HwuaUser;
import com.oracleoaec.serviceImpl.CartServiceImpl;

public class DeleteCart extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cartId = req.getQueryString();
		System.out.println("要删除的购物车id："+cartId);
		int deleteCartById = new CartServiceImpl().deleteCartById(cartId);
		if(deleteCartById>0){
			int checkCartCount = new CartServiceImpl().checkCartCount(((HwuaUser)req.getSession().getAttribute("user")).getUserId());
			req.getSession().setAttribute("cartCount", checkCartCount);
			req.getRequestDispatcher("/shopping").forward(req, resp);
		}
			
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
