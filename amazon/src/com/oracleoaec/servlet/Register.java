package com.oracleoaec.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracleoaec.entity.HwuaUser;
import com.oracleoaec.serviceImpl.UserServiceImpl;

public class Register extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String userName = req.getParameter("userName");
		String password = req.getParameter("passWord");
		String sex = req.getParameter("sex");
		//转换成Date类型
		java.sql.Date birthday=null;
		try {
			birthday = java.sql.Date.valueOf(req.getParameter("birthday"));
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		
		String identityCode = req.getParameter("identity");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String address = req.getParameter("address");
		HwuaUser user = new HwuaUser(userName, password, sex, birthday, identityCode, email, mobile, address);
		System.out.println(address);
		System.out.println("birthday："+birthday);
		int saveUser = new UserServiceImpl().saveUser(user);
		if(saveUser==1){
			resp.sendRedirect("reg-result.jsp");
		}else{
			resp.sendRedirect("register.jsp");
		}
	}
}
