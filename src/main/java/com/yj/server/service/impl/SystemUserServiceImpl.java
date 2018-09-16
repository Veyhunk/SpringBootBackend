package com.yj.server.service.impl;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yj.server.constants.SystemConstans;
import com.yj.server.dao.SystemUserDao;
import com.yj.server.model.SystemUser;
import com.yj.server.service.SystemUserService;

/**
 * 
 * 
 * 功能描述： 用户信息业务 创建人：Administrator 创建时间：2018年9月16日 上午1:33:31
 * 
 * @version
 *
 */
@Service
public class SystemUserServiceImpl implements SystemUserService {
	@Autowired
	private SystemUserDao systemUserDao;

	/**
	 * 根据用户名查询
	 */
	@Override
	public SystemUser searchUserByName(String userName) {
		return systemUserDao.searchUserByName(userName);
	}

	/**
	 * 根据手机号查询
	 */
	@Override
	public SystemUser searchUserByPhone(String phone) {
		return systemUserDao.searchUserByPhone(phone);
	}

	/**
	 * 加密密码
	 */
	@Override
	public String encodeUserPassowrd(String password) {
		return new SimpleHash("MD5", password, SystemConstans.SYSTEM_USER_SAL4T,
				SystemConstans.SYSTEM_USER_HASH_ITERATIONS).toString();
	}

}
