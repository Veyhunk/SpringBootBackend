package com.yj.server.util;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.http.HttpStatus;

import com.alibaba.fastjson.JSONObject;
import com.yj.server.constants.SystemConstans;
import com.yj.server.dto.ResponseInfo;

/**
 * 
 * 
 * 功能描述： shiro 工具类 创建人：Administrator 创建时间：2018年9月16日 下午8:27:50
 * 
 * @version
 *
 */
public final class ShiroUtil {
	/**
	 * token不存在或过期的返回信息
	 */
	public static String RESPONSE_TOKEN_NOT_EXIST = JSONObject
			.toJSONString(new ResponseInfo(HttpStatus.UNAUTHORIZED.value() + "", "token不存在或者过期"));
	/**
	 * 退出成功信息
	 */
	public static String RESPONSE_TOKEN_LOGOUT_SUCCESS_INFO = JSONObject
			.toJSONString(new ResponseInfo(HttpStatus.OK.value() + "", "退出成功"));
	/**
	 * 退出失败信息
	 */
	public static String RESPONSE_TOKEN_LOGOUT_ERR_INFO = JSONObject
			.toJSONString(new ResponseInfo(HttpStatus.BAD_REQUEST.value() + "", "退出失败,token不存在"));

	/**
	 * 将信息返回给前台
	 * 
	 * @param response
	 * @param status
	 * @param json
	 */
	public static void writeResponse(HttpServletResponse response, int status, String json) {
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "*");
			response.setContentType("application/json;charset=UTF-8");
			response.setStatus(status);
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据参数或者header获取login-token
	 * 
	 * @param request
	 * @return
	 */
	public static String getToken(ServletRequest request) {
		HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
		String loginToken = httpServletRequest.getParameter(SystemConstans.SYSTEM_USER_LOGIN_TOKEN);
		if (StringUtils.isBlank(loginToken)) {
			loginToken = httpServletRequest.getHeader(SystemConstans.SYSTEM_USER_LOGIN_TOKEN);
		}
		return loginToken;
	}

}
