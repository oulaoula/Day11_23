package com.order.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 如果是登录页面则放行
				if (request.getRequestURI().indexOf("login/doLogin.action") > 0) {
					return true;
				}
				HttpSession session = request.getSession();
				// 如果用户已登录也放行
				if (session.getAttribute("usersInfo") != null) {
					return true;
				}
				// 用户没有到登录页面
				String path=request.getContextPath();
				response.sendRedirect(path + "/login.jsp");
				return false;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
