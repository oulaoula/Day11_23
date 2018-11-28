package com.oracleoaec.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracleoaec.service.ProductService;
import com.oracleoaec.serviceImpl.ProductServiceImpl;

public class PageRefresh extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		 
		
		
		 String source = req.getParameter("src");
		 String page = req.getParameter("page");
		 String cid = req.getParameter("hpcId");
		 String qname = req.getParameter("qname");
//		 System.out.println("再次搜索的商品名："+qname);
		 int pageNo= Integer.valueOf(page);
		 int hpcId=Integer.valueOf(cid);
		 ProductService ipb=new ProductServiceImpl();
//		 System.out.println("hpcId="+hpcId+"--"+"source="+source+"--"+"pageNo="+pageNo);
		 if("0".equals(source)){
			 req.setAttribute("pageModel", ipb.allProductModel(pageNo, 12));
			 
		 }else if("1".equals(source)){
			 req.setAttribute("pageModel",ipb.pageByParentCategory(hpcId, pageNo, 12));
		 }else if("2".equals(source)){
			 req.setAttribute("pageModel",ipb.pageByChildCategory(hpcId, pageNo, 12));
		 }else{
			 req.setAttribute("pageModel",ipb.queryProducts(qname, pageNo, 12));
		 }
		 
		 
		 req.getRequestDispatcher("index.jsp").forward(req, resp);
		 
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
}
