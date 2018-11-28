package com.order.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.order.biz.OrdersMapperBiz;
import com.order.entity.Orders;
@Controller
@RequestMapping("orders")
public class OrdersMapperController {
	@Resource(name="ordersMapperBizImpl")
	private OrdersMapperBiz omz;
	@RequestMapping("findOrders")
	public ModelAndView findOrders(HttpServletRequest req,HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView("order");
		List<Orders> list = omz.findOrdersWithUserResultMap();
		mv.addObject("orders", list);
		return mv;
	}
}
