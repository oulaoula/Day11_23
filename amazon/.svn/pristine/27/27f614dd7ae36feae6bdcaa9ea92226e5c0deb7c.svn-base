package com.oracleoaec.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.oracleoaec.dao.OrderDetailDao;
import com.oracleoaec.daoImpl.OrderDetailDaoImpl;
import com.oracleoaec.daoImpl.ProductDaoImpl;
import com.oracleoaec.entity.OrderDetail;
import com.oracleoaec.entity.Product;
import com.oracleoaec.service.OrderDetailService;

public class OrderDetailServiceImpl implements OrderDetailService{

	OrderDetailDao iodd=new OrderDetailDaoImpl();
	@Override
	public int addOrderDetail(OrderDetail orderDetail) {
		
		return iodd.addOrderDetail(orderDetail);
	}

	@Override
	public List<Product> hotProducts(int rownum) {
		List<Long> hotPids= iodd.hotProducts(rownum);//获得热门商品id
		List<Product> list=new ArrayList<>();
		for (Long pid : hotPids) {
			Product product = new ProductDaoImpl().findProductById(pid);//查询热门商品
			list.add(product);
		}
		return list;
	}

	@Override
	public Long getOrderId() {
		return iodd.getOrderId();
	}
	
}
