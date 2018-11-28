package com.oracleoaec.dao;

import java.util.List;

import com.oracleoaec.entity.Cart;

public interface CartDao {
	/**
	 * 添加购物车
	 * @param cart
	 * @return
	 */
	int addCart(Cart cart);
	
	/**
	 * 更新购物车 
	 * @param cart
	 * @return
	 */
	int updateCart(Cart cart);
	
	/**
	 * 是否已经添加到购物车
	 * @param cart pid userid
	 * @return
	 */
	Cart checkCart(Cart cart);
	
	/**
	 * 更新用户购物车数量
	 * @param userid
	 * @return
	 */
	List<Integer> updateCartCount(Long userId);
	
	/**
	 * 查询某个用户的所有购物车对象
	 * @param userId
	 * @return
	 */
	List<Cart> usersCarts(Long userId);
	
	/**
	 * 删除指定用户的购物车对象
	 * @param userId
	 * @return
	 */
	int deleteCarts(Long userId);
	
	/**
	 * 根据购物车ID删除购物车
	 * @param ID
	 * @return
	 */
	int deleteCartById(String ID);
	
	/**
	 * 修改指定产品的数量
	 * @param id
	 * @param quantity
	 * @return
	 */
	int alertCartQuantity(String id,String quantity);
	
}
