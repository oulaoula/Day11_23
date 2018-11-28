package com.order.test;


import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.order.dao.OrdersMapper;
import com.order.entity.Orders;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class test2 {
	@Resource
	private OrdersMapper om;
	@Test
	public void testFindOrdersWithUserResultMap() {
		List<Orders> list = om.findOrdersWithUserResultMap();
		for (Orders ordersCustom : list) {
			System.out.println(ordersCustom);
		}
	}

}
