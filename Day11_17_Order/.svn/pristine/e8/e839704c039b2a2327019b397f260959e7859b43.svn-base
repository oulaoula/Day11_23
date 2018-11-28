package com.order.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.order.biz.OrdersMapperBiz;
import com.order.entity.Orders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test01 {
	@Resource(name="ordersMapperBizImpl")
	private OrdersMapperBiz omz;
	@Test
	public void test() {
		List<Orders> list = omz.findOrdersWithUserResultMap();
		for (Orders ordersCustom : list) {
			System.out.println(ordersCustom);
		}
	}
}
