package com.sun.realm;


import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.sun.entity.Admin;
import com.sun.service.BackAdminservice;

public class Myrealm extends AuthorizingRealm{
	
	@Resource
	private BackAdminservice backAdminservice;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName = (String) token.getPrincipal();
		Admin administrator= backAdminservice.login(userName);
		if(administrator!=null) {
			SecurityUtils.getSubject().getSession().setAttribute("administrator", administrator);
			AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(administrator.getUserName(), administrator.getPassword(), "xx");
			return authcInfo;
		}else {
			return null;
		}
	}

	


}
