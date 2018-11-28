package com.oracleoaec.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracleoaec.entity.HwuaUser;
import com.oracleoaec.serviceImpl.CartServiceImpl;
/**
 * 更改购物车产品数量的servlet
 * @author Administrator
 *
 */
public class AlterCartQuantity extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String[] split =  req.getQueryString().split("_");
		int alertCartQuantity = new CartServiceImpl().alertCartQuantity(split[0], split[1]);
		if(alertCartQuantity>0){
			int checkCartCount = new CartServiceImpl().checkCartCount(((HwuaUser)req.getSession().getAttribute("user")).getUserId());
			if(checkCartCount>Integer.parseInt(split[2])){
				resp.getWriter().print(Integer.parseInt(split[2]));
			}else{
				resp.getWriter().print(checkCartCount);
			}
			
		}
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
	
	
	
	

}
