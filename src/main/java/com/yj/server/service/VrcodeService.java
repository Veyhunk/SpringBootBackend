package com.yj.server.service;

import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 
 * 功能描述： 图片验证码业务 创建人：Administrator 创建时间：2018年9月15日 下午1:49:30
 * 
 * @version
 *
 */
public interface VrcodeService {
	/**
	 * 创建验证码
	 * 
	 * @param httpServletRequest
	 * @param httpServletResponse
	 */
	void createVrcode(String id, HttpServletResponse httpServletResponse);

	/**
	 * 
	 * @param id
	 * @return
	 */
	boolean checkVrcode(String id, String code);

}
