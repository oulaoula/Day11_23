package com.shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class Test01 {
	@Test
	public void testCustomRealm() {
		// 创建securityManager工厂，通过ini配置文件创建securityManager工厂
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:config/shiro-realm.ini");

		// 创建SecurityManager
		SecurityManager securityManager = factory.getInstance();

		// 将securityManager设置当前的运行环境中
		SecurityUtils.setSecurityManager(securityManager);

		// 从SecurityUtils里边创建一个subject
		Subject subject = SecurityUtils.getSubject();

		// 在认证提交前准备token（令牌）
		// 这里的账号和密码 将来是由用户输入进去
		UsernamePasswordToken token = new UsernamePasswordToken("jack", "111111");
		try {
			// 执行认证提交
			subject.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		
		// 是否认证通过
		boolean isAuthenticated = subject.isAuthenticated();
		
		System.out.println("是否认证通过：" +  isAuthenticated);

	}
	
}
