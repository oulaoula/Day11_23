package com.order.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.order.biz.OrdersMapperBiz;
import com.order.dao.OrdersMapper;
import com.order.entity.Orders;
@Service("ordersMapperBizImpl")
public class OrdersMapperBizImpl implements OrdersMapperBiz {
	@Resource(name="ordersMapper")
	private OrdersMapper om;
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(Orders record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertSelective(Orders record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Orders selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateByPrimaryKeySelective(Orders record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKey(Orders record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Orders> findOrdersWithUserResultMap() {
		List<Orders> list = om.findOrdersWithUserResultMap();
		return list;
	}

}
