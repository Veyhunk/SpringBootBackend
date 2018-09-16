package com.yj.server.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.yj.server.constants.SystemConstans;
import com.yj.server.model.SystemUser;
import com.yj.server.service.SystemUserService;
import com.yj.server.util.UserUtil;

public class MyShiroRealm extends AuthorizingRealm {

	@Autowired
	private SystemUserService systemuserService;

	/**
	 * shiro校验逻辑
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		String username = usernamePasswordToken.getUsername();
		SystemUser user = systemuserService.searchUserByName(username);
		if (null == user) {
			user = systemuserService.searchUserByPhone(username);
		}
		if (user == null) {
			throw new UnknownAccountException("用户名不存在");
		}
		if (!user.getPassword()
				.equals(systemuserService.encodeUserPassowrd(new String(usernamePasswordToken.getPassword())))) {
			throw new IncorrectCredentialsException("密码错误");
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(),
				ByteSource.Util.bytes(SystemConstans.SYSTEM_USER_SAL4T), getName());
		// 当前用户放入session
		UserUtil.setUserSession(user);
		return authenticationInfo;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		SystemUser user = UserUtil.getCurrentUser();
		Set<String> roleNames = new HashSet<String>();
		roleNames.add(user.getRoleType() + "");
		authorizationInfo.setRoles(roleNames);
		return authorizationInfo;
	}

	/**
	 * 重写缓存key，否则集群下session共享时，会重复执行doGetAuthorizationInfo权限配置
	 */
	@Override
	protected Object getAuthorizationCacheKey(PrincipalCollection principals) {
		SimplePrincipalCollection principalCollection = (SimplePrincipalCollection) principals;
		Object object = principalCollection.getPrimaryPrincipal();
		if (object instanceof SystemUser) {
			SystemUser user = (SystemUser) object;
			return "authorization:cache:key:users:" + user.getDatabaseId();
		}
		return super.getAuthorizationCacheKey(principals);
	}

}
