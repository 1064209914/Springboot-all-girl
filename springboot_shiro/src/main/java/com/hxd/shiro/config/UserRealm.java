package com.hxd.shiro.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.hxd.shiro.entry.User;
import com.hxd.shiro.serviceipl.UserServiceipl;

public class UserRealm extends AuthorizingRealm {

	@Autowired
	private UserServiceipl userServiceipl;
	
	  /**
     * 执行授权逻辑
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection paramPrincipalCollection) {
		System.out.println("执行授权逻辑");
		return null;
	}

	/**
     * 执行认证逻辑 (模拟)
     */
	/*@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken paramAuthenticationToken)
			throws AuthenticationException {
		System.out.println("执行认证逻辑");
		//先写模拟数据进行验证，下一步再连接数据库，假设数据库的用户名和密码如下
        String dbusername="hxd";
        String dbpassword="123456";

        //编写shiro判断逻辑，判断用户名和密码

        //1. 判断用户名
        UsernamePasswordToken token=(UsernamePasswordToken) paramAuthenticationToken;
        if (!token.getUsername().equals(dbusername)) {
            //用户名不存在
            return null;//shiro底层会抛出UnknownAccountException
        }
        //2. 判断密码
        return new SimpleAuthenticationInfo("",dbpassword,"");//参数1：需要返回给login方法的数据；参数2：数据库密码，shiro会自动判断 

    }*/
	
	/**
     * 执行认证逻辑 (mybaties)
     */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken paramAuthenticationToken)
			throws AuthenticationException {
		System.out.println("执行认证逻辑");
		
		//编写shiro判断逻辑，判断用户名和密码
		
		//1. 判断用户名
		UsernamePasswordToken token=(UsernamePasswordToken) paramAuthenticationToken;
		 User user=userServiceipl.findByUsername(token.getUsername());
		if (user==null) {
			//用户名不存在
			return null;//shiro底层会抛出UnknownAccountException
		}
		//2. 判断密码
		return new SimpleAuthenticationInfo("",user.getPassword(),"");//参数1：需要返回给login方法的数据；参数2：数据库密码，shiro会自动判断 
		
	}

}
