package com.oracleoaec.entity;


import java.util.List;

public class OrderView {
	private Order oder;//订单对象
	private List<Shopping> shoppinglist;//购物车对象
	
	
	public OrderView() {

	}


	public OrderView(Order oder, List<Shopping> shoppinglist) {
		
		this.oder = oder;
		this.shoppinglist = shoppinglist;
	}


	public Order getOder() {
		return oder;
	}


	public void setOder(Order oder) {
		this.oder = oder;
	}


	public List<Shopping> getShoppinglist() {
		return shoppinglist;
	}


	public void setShoppinglist(List<Shopping> shoppinglist) {
		this.shoppinglist = shoppinglist;
	}
	
	
	
	
	
}
