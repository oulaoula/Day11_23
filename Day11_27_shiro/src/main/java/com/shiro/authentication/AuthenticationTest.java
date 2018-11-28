package com.shiro.authentication;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class AuthenticationTest {
	@Test
	public void testAuthenticationDemo01() {
		// 1 使用IniSecurityManagerFactory构造器 加载配置配置 获取 工厂对象Factory<SecurityManager>
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:config/first-shiro.ini");
		// 2 从工厂对象获取 securityManager对象
		SecurityManager securityManager = factory.getInstance();
		// 3 securityManager放入容器SecurityUtils
		SecurityUtils.setSecurityManager(securityManager);

		// 4 获取当前 主体Subjetct 当前用户 是静态资源first-shiro.ini中获取
		Subject subject = SecurityUtils.getSubject();

		// 5在认证提交前准备token（令牌）
		UsernamePasswordToken token = new UsernamePasswordToken("lisi", "123");

		// 6 执行认证
		try {
			subject.login(token);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 7 是否认证通过
			boolean isAuthenticated = subject.isAuthenticated();
			System.out.println("是否认证通过：" + isAuthenticated);
		}
		// 退出操作
		subject.logout();
		// 是否认证通过
		boolean isAuthenticated = subject.isAuthenticated();

		System.out.println("是否认证通过：" + isAuthenticated);

	}

	// 自定义Relam 认证功能
	@Test
	public void testCustomRealm() {
		// 1 使用IniSecurityManagerFactory构造器 加载配置配置 获取 工厂对象Factory<SecurityManager>
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:config/shiro-realm.ini");
		// 2 从工厂对象获取 securityManager对象
		SecurityManager securityManager = factory.getInstance();
		// 3 securityManager放入容器SecurityUtils
		SecurityUtils.setSecurityManager(securityManager);

		// 4 获取当前 主体Subjetct 当前用户 是静态资源first-shiro.ini中获取
		Subject subject = SecurityUtils.getSubject();

		// 5在认证提交前准备token（令牌）
		// 数据库中存在用户lisi 但是密码是111111
		UsernamePasswordToken token = new UsernamePasswordToken("jack", "111111");

		// 6 执行认证
		try {
			subject.login(token);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 7 是否认证通过
			boolean isAuthenticated = subject.isAuthenticated();
			System.out.println("是否认证通过：" + isAuthenticated);
		}
	}

}
