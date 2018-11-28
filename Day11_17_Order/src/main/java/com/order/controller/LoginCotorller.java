package com.order.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginCotorller {
	// 登录功能
		@RequestMapping(value = "doLogin", method = RequestMethod.POST)
		public String doLogin(String uname, String upwd, HttpSession session,Model model) {
			if (uname.equals("admin") && upwd.equals("admin")) {
				// 如果登录成功 将用户信息保存到 usersInfo
				session.setAttribute("usersInfo", uname);
				return "redirect:/items/selectAll.action";
			} else {
				model.addAttribute("msg", "用户名或密码错误!");
				return "login";
			}
		}
		//登出功能
		@RequestMapping("logout")
		public String logout(HttpSession session) {
			//将Session强制过期
			session.invalidate();
			return "redirect:/index.jsp";
		}
}
