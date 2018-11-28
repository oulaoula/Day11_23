package com.oracleoaec.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracleoaec.serviceImpl.UserServiceImpl;

/**
 * Servlet implementation class retrievePassWordServlet
 */
//@WebServlet("/retrievePassWordServlet")
public class retrievePassWordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public retrievePassWordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("userName");
		String email = request.getParameter("email");
		String pwd = new UserServiceImpl().findPwd(name, email);
		request.getSession().setAttribute("pwd", pwd);
		System.out.println(pwd);
		response.sendRedirect("back.jsp");
	}

}
