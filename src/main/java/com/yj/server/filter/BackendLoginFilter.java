package com.yj.server.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.yj.server.service.TokenService;
import com.yj.server.util.ShiroUtil;

/**
 * Restful方式登陆 在参数中或者header里加参数login-token作为登陆凭证 参数值是登陆成功后的返回值中获取
 * 
 * 
 *
 */
public class BackendLoginFilter extends UserFilter {
	@Autowired
	private TokenService tokenService;

	/**
	 * 判断是否登录
	 */
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		String loginToken = ShiroUtil.getToken(request);
		if (StringUtils.isBlank(loginToken)) {// 非Restful方式
			return super.isAccessAllowed(request, response, mappedValue);
		}
		UsernamePasswordToken token = tokenService.getToken(loginToken);
		if (token != null) {
			try {
				Subject subject = getSubject(request, response);
				if (subject.getPrincipal() == null) {
					subject.login(token);
				}
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * 检查到用户未登录后进行相应的处理 1.web登录的 返回相应的跳转目录 2.非web登录的 返回json
	 */
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		String loginToken = ShiroUtil.getToken(request);
		if (StringUtils.isBlank(loginToken)) {
			return super.onAccessDenied(request, response);
		}
		ShiroUtil.writeResponse(WebUtils.toHttp(response), HttpStatus.UNAUTHORIZED.value(),
				ShiroUtil.RESPONSE_TOKEN_NOT_EXIST);
		return false;
	}

}
