package com.oracleoaec.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracleoaec.entity.News;
import com.oracleoaec.serviceImpl.NewsServiceImpl;

public class ReadNews extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nid = req.getParameter("nid");
		Long hnId = Long.valueOf(nid);
		News news = new NewsServiceImpl().getNewsById(hnId);
		List<News> newsList = new NewsServiceImpl().getNews(7);
		req.setAttribute("news", newsList);
		req.setAttribute("newsInfo", news);
		req.getRequestDispatcher("news_view.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
	
	
	
	
	
	
	
}
