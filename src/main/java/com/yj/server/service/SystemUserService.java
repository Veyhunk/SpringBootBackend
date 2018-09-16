package com.yj.server.service;

import com.yj.server.model.SystemUser;

/**
 * 
 * 
 * 功能描述： 用户信息业务 创建人：Administrator 创建时间：2018年9月16日 上午1:31:59
 * 
 * @version
 *
 */
public interface SystemUserService {

	/**
	 * 根据用户名查询
	 * 
	 * @param userName
	 * @return
	 */
	SystemUser searchUserByName(String userName);

	/**
	 * 根据手机号查询
	 * 
	 * @param phone
	 * @return
	 */
	SystemUser searchUserByPhone(String phone);

	/**
	 * 加密密码
	 * 
	 * @param password
	 * @return
	 */
	String encodeUserPassowrd(String password);

}
