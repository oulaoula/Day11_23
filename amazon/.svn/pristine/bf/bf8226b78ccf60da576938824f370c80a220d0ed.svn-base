package com.oracleoaec.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracleoaec.entity.Comment;
import com.oracleoaec.serviceImpl.CommentServiceImpl;

public class AddComment extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("text/html;charset:UTF-8");*/
		String hcNickName = req.getParameter("guestName");
		String hcContent = req.getParameter("guestContent");
		System.out.println("guestName="+hcNickName+"guestContent"+hcContent);
		Comment comment = new Comment(hcContent, new Date(new java.util.Date().getTime()), hcNickName);
		int addComment = new CommentServiceImpl().addComment(comment);
		
		if(addComment>0){
			resp.sendRedirect("guestbook.jsp");
		}
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doGet(req, resp);
	}
	
	
	
	
	
	
	
	
	
}
