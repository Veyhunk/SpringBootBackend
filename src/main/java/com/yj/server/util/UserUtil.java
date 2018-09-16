package com.yj.server.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.yj.server.constants.SystemConstans;
import com.yj.server.model.SystemUser;

/**
 * 
 * 
 * 功能描述：用户信息工具类 创建人：Administrator 创建时间：2018年9月16日 上午1:52:33
 * 
 * @version
 *
 */
public final class UserUtil {
	/**
	 * 获取当前登录的用户
	 * 
	 * @return
	 */
	public static SystemUser getCurrentUser() {
		SystemUser user = (SystemUser) getSession().getAttribute(SystemConstans.SYSTEM_USER_LOGIN_USER);
		return user;
	}

	/**
	 * 将当前登录的用户放入session
	 * 
	 * @param user
	 */
	public static void setUserSession(SystemUser user) {
		getSession().setAttribute(SystemConstans.SYSTEM_USER_LOGIN_USER, user);
	}

	/**
	 * 获取session
	 * 
	 * @return
	 */
	public static Session getSession() {
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		return session;
	}

	/**
	 * 不可实例化
	 */
	private UserUtil() {
	}

}
