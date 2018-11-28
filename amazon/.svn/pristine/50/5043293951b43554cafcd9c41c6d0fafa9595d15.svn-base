package com.oracleoaec.entity;

import java.io.Serializable;

public class Cart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;//序列id，cart表主键
	private Long pid;//商品id
	private Long quantity;//数量
	private Long userId;//用户id
	
	public Cart() {
		
	}

	public Cart( Long pid, Long userId) {
		this.pid = pid;
		this.userId = userId;
	}
	
	public Cart( Long pid,Long quantity, Long userId) {
		this.pid = pid;
		this.quantity=quantity;
		this.userId = userId;
	}
	
	
	public Cart(Long id, Long pid, Long quantity, Long userId) {
		this.pid = pid;
		this.quantity = quantity;
		this.userId = userId;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	

}
