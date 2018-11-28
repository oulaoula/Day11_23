package com.oracleoaec.serviceImpl;

import com.oracleoaec.dao.UserDao;
import com.oracleoaec.daoImpl.UserDaoImpl;
import com.oracleoaec.entity.HwuaUser;
import com.oracleoaec.service.UserService;

public class UserServiceImpl implements UserService{
	UserDao iud=new UserDaoImpl();
	@Override
	public int saveUser(HwuaUser user) {
		return iud.saveUser(user);
	}
	@Override
	public HwuaUser Login(String username, String password) {
		
		return iud.checkUser(username, password);
	}
	@Override
	public Long checkName(String username) {
		return iud.checkName(username);
	}
	@Override
	public Long checkEmail(String email) {
		
		return iud.checkEmail(email);
	}
	@Override
	public String findPwd(String name, String email) {
		// TODO Auto-generated method stub
		return iud.findPwd(name, email);
	}

}
