package com.oracleoaec.entity;

import java.sql.Date;

public class Order {
	private Long hoId;//订单id，序列产生
	private Long hoUserId; //用户id
	private String hoUserName; //用户名
	private String hoUserAddress; // 用户地址
	private Date hoCreateTime;  //创建时间
	private Double hoCost;  //所花金额
	private Long hoStatus;  //状态（未判断）
	private Long hoType;//状态（未判断）
	
	
	
	public Order() {
		
	}



	public Order(Long hoUserId, String hoUserName, String hoUserAddress, Date hoCreateTime, Double hoCost,
			Long hoStatus, Long hoType) {
		this.hoUserId = hoUserId;
		this.hoUserName = hoUserName;
		this.hoUserAddress = hoUserAddress;
		this.hoCreateTime = hoCreateTime;
		this.hoCost = hoCost;
		this.hoStatus = hoStatus;
		this.hoType = hoType;
	}



	public Long getHoId() {
		return hoId;
	}



	public void setHoId(Long hoId) {
		this.hoId = hoId;
	}



	public Long getHoUserId() {
		return hoUserId;
	}



	public void setHoUserId(Long hoUserId) {
		this.hoUserId = hoUserId;
	}



	public String getHoUserName() {
		return hoUserName;
	}



	public void setHoUserName(String hoUserName) {
		this.hoUserName = hoUserName;
	}



	public String getHoUserAddress() {
		return hoUserAddress;
	}



	public void setHoUserAddress(String hoUserAddress) {
		this.hoUserAddress = hoUserAddress;
	}



	public Date getHoCreateTime() {
		return hoCreateTime;
	}



	public void setHoCreateTime(Date hoCreateTime) {
		this.hoCreateTime = hoCreateTime;
	}



	public Double getHoCost() {
		return hoCost;
	}



	public void setHoCost(Double hoCost) {
		this.hoCost = hoCost;
	}



	public Long getHoStatus() {
		return hoStatus;
	}



	public void setHoStatus(Long hoStatus) {
		this.hoStatus = hoStatus;
	}



	public Long getHoType() {
		return hoType;
	}



	public void setHoType(Long hoType) {
		this.hoType = hoType;
	}



	@Override
	public String toString() {
		return "Order [hoId=" + hoId + ", hoUserId=" + hoUserId + ", hoUserName=" + hoUserName + ", hoUserAddress="
				+ hoUserAddress + ", hoCreateTime=" + hoCreateTime + ", hoCost=" + hoCost + ", hoStatus=" + hoStatus
				+ ", hoType=" + hoType + "]";
	}  
	
	
}
