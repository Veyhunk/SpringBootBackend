package com.yj.server.service.impl;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.yj.server.constants.RedisKeyConstants;
import com.yj.server.dto.Token;
import com.yj.server.redis.RedisClient;
import com.yj.server.service.TokenService;
import com.yj.server.util.UUIDUtil;

/**
 * 
 * 
 * 功能描述： redis管理登录的token业务 创建人：Administrator 创建时间：2018年9月16日 上午2:16:33
 * 
 * @version
 *
 */
@Service
public class RedisTokenServiceImpl implements TokenService {
	@Autowired
	private RedisClient redisClient;

	/**
	 * 将token保存到redis
	 */
	@Override
	public Token saveToken(UsernamePasswordToken token) {
		String key = RedisKeyConstants.KEY_NAME_TOKEN + UUIDUtil.createUUID();
		redisClient.set(key, JSONObject.toJSONString(token));
		redisClient.expire(key, 120);
		return new Token(key, DateUtils.addSeconds(new Date(), 120));
	}

	/**
	 * 获取redis里面存的用户信息
	 */
	@Override
	public UsernamePasswordToken getToken(String key) {
		String json = redisClient.get(RedisKeyConstants.KEY_NAME_TOKEN + key);
		if (!StringUtils.isEmpty(json)) {
			UsernamePasswordToken usernamePasswordToken = JSONObject.parseObject(json, UsernamePasswordToken.class);
			return usernamePasswordToken;
		}
		return null;
	}

	/**
	 * 删除登录的用户信息
	 */
	@Override
	public boolean deleteToken(String key) {
		return redisClient.delete(key);
	}

}
