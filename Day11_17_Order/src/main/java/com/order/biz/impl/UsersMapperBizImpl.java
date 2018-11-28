package com.order.biz.impl;

import javax.annotation.Resource;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.order.biz.UsersMapperBiz;
import com.order.dao.UsersMapper;
import com.order.entity.Users;
@Service("usersMapperBizImpl")
public class UsersMapperBizImpl implements UsersMapperBiz {
	@Resource(name="usersMapper")
	private UsersMapper um;
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(Users record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertSelective(Users record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Users selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateByPrimaryKeySelective(Users record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKey(Users record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
