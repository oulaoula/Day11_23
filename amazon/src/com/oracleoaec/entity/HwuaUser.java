package com.oracleoaec.entity;

import java.io.Serializable;
import java.sql.Date;


public class HwuaUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long userId;//用户id，序列产生
	private String userName;//用户名
	private String password;//密码
	private String sex;//性别
	private Date birthday;//生日
	private String identityCode;//身份证
	private String email;//邮箱
	private String mobile;//手机号
	private String address;//地址
	private Integer status;//是否是管理员，没有写后台，要不要无所谓
	
	
	public HwuaUser() {
		
	}


	public HwuaUser( String userName, String password, String sex, Date birthday, String identityCode,
			String email, String mobile, String address) {
		this.userName = userName;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
		this.identityCode = identityCode;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public String getIdentityCode() {
		return identityCode;
	}


	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "HwuaUser [userId=" + userId + ", userName=" + userName + ", password=" + password + ", sex=" + sex
				+ ", birthday=" + birthday + ", identityCode=" + identityCode + ", email=" + email + ", mobile="
				+ mobile + ", address=" + address + ", status=" + status + "]";
	}

	
	
	
}
