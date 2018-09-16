package com.yj.server.constants;

/**
 * 
 * 
 * 功能描述：系统的一些常量 创建人：Administrator 创建时间：2018年9月16日 上午1:41:34
 * 
 * @version
 *
 */
public interface SystemConstans {
	/**
	 * 加密盐
	 */
	public static final String SYSTEM_USER_SAL4T = "yj4Salt";
	/**
	 * 加密次数
	 */
	public static final int SYSTEM_USER_HASH_ITERATIONS = 3;

	/**
	 * 登录用户标记
	 */
	public static final String SYSTEM_USER_LOGIN_USER = "login_user";

	/**
	 * 登陆token
	 */
	public static final String SYSTEM_USER_LOGIN_TOKEN = "login-token";

}
