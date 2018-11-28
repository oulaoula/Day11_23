package com.oracleoaec.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracleoaec.entity.Cart;
import com.oracleoaec.entity.HwuaUser;
import com.oracleoaec.service.CartService;
import com.oracleoaec.serviceImpl.CartServiceImpl;

public class GoingToBuy extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getQueryString();
		String[] params = param.split("_");
		Long pid = Long.valueOf(params[0]);
		Long quantity=Long.valueOf(params[1]);
		HwuaUser u=(HwuaUser)req.getSession().getAttribute("user");
		CartService icb = new CartServiceImpl();
		int addToCart = icb.addToCart(new Cart(pid, quantity,u.getUserId()));
		req.getSession().setAttribute("cartCount", addToCart);
		req.getRequestDispatcher("/shopping").forward(req, resp);;
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
	
	
	
	
	
	

}
