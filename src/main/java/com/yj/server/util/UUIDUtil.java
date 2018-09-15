package com.yj.server.util;

import java.util.UUID;

/**
 * 
 * 
 * 功能描述： 创建uuid
 *  创建人：Administrator 创建时间：2018年9月15日 下午1:55:50
 * 
 * @version
 *
 */
public final class UUIDUtil {

	public static String createUUID() {
		return UUID.randomUUID().toString().replace("-", "").toLowerCase();
	}

	/**
	 * 不可实例化
	 */
	private UUIDUtil() {
	}
}
