package com.oracleoaec.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracleoaec.service.ProductService;
import com.oracleoaec.serviceImpl.CategoryServiceImpl;
import com.oracleoaec.serviceImpl.ProductServiceImpl;

public class ProductByCategory extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String category = req.getParameter("cate");
		String hpcId = req.getParameter("hpcId");
		req.setAttribute("hpcId", hpcId);
		ProductService ipb=new ProductServiceImpl();
		Object[][] allCategory = new CategoryServiceImpl().getAllCategory();
		req.setAttribute("categoryInfo", allCategory);
		if("parent".equals(category)){
			req.setAttribute("pageModel", 
					ipb.pageByParentCategory(Integer.valueOf(hpcId), 1, 12));
		}else{
			req.setAttribute("pageModel",ipb.pageByChildCategory(Integer.valueOf(hpcId), 1, 12));
		}
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
	
	
	
	
	
	
	

}
