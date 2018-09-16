package com.yj.server.service;

import org.apache.shiro.authc.UsernamePasswordToken;

import com.yj.server.dto.Token;
/**
 * Token管理器<br>
 * 
 * 
 *
 *   */
public interface TokenService {

	/**
	 * 保存Token
	 * 
	 * @param token
	 * @return
	 */
	Token saveToken(UsernamePasswordToken token);

	/**
	 * 根据token获取凭证
	 * 
	 * @param key
	 * @return
	 */
	UsernamePasswordToken getToken(String key);

	/**
	 * 删除token
	 * 
	 * @param key
	 */
	boolean deleteToken(String key);
}
