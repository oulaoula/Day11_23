package com.oracleoaec.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracleoaec.serviceImpl.UserServiceImpl;

public class CheckUserName extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("userName");
		Long userId = new UserServiceImpl().checkName(username);
		if(userId==0){
			resp.getWriter().println(0);
		}
		else{
			resp.getWriter().println(1);
		}
	}
	
	
	
	
	
	
	
	
	
	
}
