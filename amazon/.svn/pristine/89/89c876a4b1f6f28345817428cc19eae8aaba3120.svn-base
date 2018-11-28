package com.oracleoaec.dao;

import com.oracleoaec.entity.HwuaUser;

public interface UserDao {
	
	/**
	 * 注册用户
	 * @param user
	 * @return 插入的行数 1 表示注册成功 0表示注册失败
	 */
	
	int saveUser(HwuaUser user);
	/**
	 * 查询用户名是否已存在
	 * @param username
	 * @return 返回用户id id>0表示用户名已存在
	 */
	Long checkName(String username);
	
	
	/**
	 * 查询邮箱是否已注册
	 * @param email
	 * @return
	 */
	Long checkEmail(String email);
	
	
	/**
	 * 登录验证
	 * @param username
	 * @param password
	 * @return 返回user用户对象
	 */
	HwuaUser checkUser(String username,String password);
	
	/**
	 * 根据用户名和email找回用户密码
	 * @param
	 * @return 密码
	 */
	String findPwd(final String name,final String email);
	
	
}
