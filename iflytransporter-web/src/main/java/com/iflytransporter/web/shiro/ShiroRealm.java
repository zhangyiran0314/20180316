package com.iflytransporter.web.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

import com.iflytransporter.web.sys.bean.UUser;


public abstract class ShiroRealm extends AuthorizingRealm{
	
	public ShiroRealm(){
		initCredentialsMatcher();
	}

	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher("SHA-1");
		matcher.setHashIterations(1024);
		setCredentialsMatcher(matcher); 
	}
	public void clearCachedAuthorizationInfo(UUser principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());     
	    clearCachedAuthorizationInfo(principals);                   
	}

	public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
		super.clearCachedAuthorizationInfo(principalCollection);
	}

	public void exit(UUser user) {
	}

	public void onLogout(PrincipalCollection principalCollection) {
		super.onLogout(principalCollection);
	}     
}
