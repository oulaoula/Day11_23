package com.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 
 * @ClassName:  CustomRealm   
 * @Description:TODO(自定义realm)   
 * @author: kick
 * @date:   2018年11月27日 下午4:22:01   
 *     
 * @Copyright: 2018 www.hwua.com Inc. All rights reserved.
 */
public class CustomRealm extends AuthorizingRealm {

	@Override
	public void setName(String name) {
		super.setName("customRealm");
	}

	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	// 模拟从数据库中获取 数据
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 1通过令牌token获取用户身份
		String usercode = (String) token.getPrincipal();// 用户身份
		// 2 第二步：根据用户输入的usercode[账户]从数据库查询
		// 获取账号信息

		// 如果查询不到返回null
		// 数据库中用户账号是zhangsansan

		if (!usercode.equals("jack")) {
			return null;
		}

		// 已经 找到了该用户 并发现该用户密码是111111
		// 模拟从数据库查询到密码
		usercode = "jack";
		String password = "111111";
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(usercode, password, this.getName());
		return authenticationInfo;
	}

}
