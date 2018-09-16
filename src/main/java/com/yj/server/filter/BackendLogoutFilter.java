package com.yj.server.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.yj.server.model.SystemUser;
import com.yj.server.service.TokenService;
import com.yj.server.util.ShiroUtil;
import com.yj.server.util.UserUtil;

/**
 * 
 * 
 * 功能描述：退出 创建人：Administrator 创建时间：2018年9月16日 上午11:49:07
 * 
 * @version
 *
 */
public class BackendLogoutFilter extends LogoutFilter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TokenService tokenService;
	
	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		String loginToken = ShiroUtil.getToken(request);
		SystemUser user = UserUtil.getCurrentUser();
		if (StringUtils.isBlank(loginToken)) {// 非Restful方式
			boolean flag = super.preHandle(request, response);
			logger.debug("{}退出成功", user.getUserName());
			return flag;
		} else {
			boolean flag = tokenService.deleteToken(loginToken);// Restfulf方式
																// 从redis清空下
			if (flag) {
				ShiroUtil.writeResponse(WebUtils.toHttp(response), HttpStatus.OK.value(),
						ShiroUtil.RESPONSE_TOKEN_LOGOUT_SUCCESS_INFO);
				logger.debug("{}退出成功", user.getUserName());
			} else {
				ShiroUtil.writeResponse(WebUtils.toHttp(response), HttpStatus.BAD_REQUEST.value(),
						ShiroUtil.RESPONSE_TOKEN_LOGOUT_ERR_INFO);
			}
			return false;
		}
	}

}
