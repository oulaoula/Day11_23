package com.oracleoaec.dao;

import java.util.List;

import com.oracleoaec.entity.Order;

public interface OrderDao {

	/**
	 * 添加订单
	 * @param order对象
	 * @return 是否添加成功参数
	 */
	public int addOrder(Order order);
	
	/**
	 * 查询指定用户所有订单
	 * @param hoUserId
	 * @return List<Order>
	 */
	public List<Order> searchAllOrder(Long hoUserId);
	
	/**
	 * 查询指定Id的订单
	 * @param hoId
	 * @return Order对象
	 */
	public Order searchOrderById(Long hoId);
	
	/**
	 * 修改指定的订单状态
	 * @param eoId
	 * @param eoStatus
	 * @return 是否修改成功参数
	 */
	public int updateOrder(Long hoId, Long hoStatus);
	
	/**
	 * 删除指定Id的订单
	 * @param eoId
	 * @return 是否删除成功参数
	 */
	public int deleteOrder(Long hoId);
	
	
	
	
	
	
	
	
	
}
