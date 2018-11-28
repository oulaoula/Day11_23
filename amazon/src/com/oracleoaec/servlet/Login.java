package com.oracleoaec.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracleoaec.entity.HwuaUser;
import com.oracleoaec.entity.Product;
import com.oracleoaec.serviceImpl.CartServiceImpl;
import com.oracleoaec.serviceImpl.ProductServiceImpl;
import com.oracleoaec.serviceImpl.UserServiceImpl;

public class Login extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("userName");
		String password = req.getParameter("passWord");
		HwuaUser user = new UserServiceImpl().Login(username, password);
		PrintWriter out = resp.getWriter();
		if(user==null){
			out.println("<script>alert('登录失败，请重新输入');location.href='login.jsp';</script>");
		}else{
			int cartCount = new CartServiceImpl().checkCartCount(user.getUserId());
			List<Product> viewedProduct = null;
			if (user.getUserId() == 0) {
				resp.sendRedirect("login.jsp");//
			} else {
				// 遍历cookie 找出最近浏览商品的pID记录
				HttpSession session = req.getSession();
				Cookie[] cookies = req.getCookies();
				List<Cookie> cookieList = null;
				if (cookies != null && cookies.length > 0) {// 取出用户的cookie
					cookieList = new ArrayList<>();
					for (Cookie cookie : cookies) {
						if (cookie.getName().startsWith("" + user.getUserId())) {
							cookieList.add(cookie);
							if(cookieList.size()>5){
								cookieList.remove(0);
							}
						}
					}
					if (cookieList.size() > 0) {// 存在当前用户的cookie
						viewedProduct = new ArrayList<>();

						for (Cookie cookie : cookieList) {
							Product product = new ProductServiceImpl().findProductById(Long.valueOf(cookie.getValue()));
							viewedProduct.add(product);
						}
						session.setAttribute("viewedProduct", viewedProduct);

					}
				}
				session.setAttribute("user", user);
				session.setAttribute("cartCount", cartCount);
				resp.sendRedirect("index.jsp");// 登录成功后回话跟踪
			}
		}
		
	}
}
