package com.oracleoaec.serviceImpl;

import java.util.List;

import com.oracleoaec.dao.OrderDao;
import com.oracleoaec.daoImpl.OrderDaoImpl;
import com.oracleoaec.entity.Order;
import com.oracleoaec.service.OrderService;

public class OrderServiceImpl implements OrderService{
	private OrderDao iod=new OrderDaoImpl();
	@Override
	public int addOrder(Order order) {
		
		return iod.addOrder(order);
	}

	@Override
	public List<Order> searchAllOrder(Long hoUserId) {
		
		return iod.searchAllOrder(hoUserId);
	}

	@Override
	public Order searchOrderById(Long hoId) {
	
		return iod.searchOrderById(hoId);
	}

	@Override
	public int updateOrder(Long hoId, Long hoStatus) {
		
		return iod.updateOrder(hoId, hoStatus);
	}

	@Override
	public int deleteOrder(Long hoId) {
		
		return iod.deleteOrder(hoId);
	}

}
