package com.oracleoaec.service;

import com.oracleoaec.entity.HwuaUser;

public interface UserService {
	/**
	 * 注册，保存用户
	 * @param user
	 * @return
	 */
	int saveUser(HwuaUser user);
	/**
	 * 登录验证
	 * @param username
	 * @param password
	 * @return
	 */
	HwuaUser Login(String username,String password);
	/**
	 * 重名验证
	 * @param username
	 * @return UserId >0用户名已存在
	 */
	Long checkName(String username);
	
	/**
	 * 查询邮箱是否已注册
	 * @param email
	 * @return
	 */
	Long checkEmail(String email);
	/**
	 * 根据用户名和email找回用户密码
	 */
	String findPwd(final String name,final String email);
	
}
