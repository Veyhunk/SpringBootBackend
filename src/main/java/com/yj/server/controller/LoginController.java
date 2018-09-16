package com.yj.server.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yj.server.dto.ResponseInfo;
import com.yj.server.dto.Token;
import com.yj.server.exception.VrcodeErrorException;
import com.yj.server.service.TokenService;
import com.yj.server.service.VrcodeService;

/**
 * 
 * 
 * 功能描述： 登录controller 两种方式 restful方式 和 web方式 区别一个返回token信息 一个不返回
 * 创建人：Administrator 创建时间：2018年9月16日 上午10:42:42
 * 
 * @version
 *
 */
@RestController
@RequestMapping("system")
public class LoginController {

	@Autowired
	private TokenService tokenService;
	@Autowired
	private VrcodeService vrcodeService;

	/**
	 * rest登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@PostMapping("restLogin")
	public Token restfulLogin(String username, String password) {
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
		SecurityUtils.getSubject().login(usernamePasswordToken);
		return tokenService.saveToken(usernamePasswordToken);
	}

	/**
	 * web登录
	 * 
	 * @param username
	 * @param password
	 */
	@PostMapping("webLogin")
	public ResponseInfo login(String username, String password, String vrcode, String id) {
		if (null == id || null == vrcode || !vrcodeService.checkVrcode(id, vrcode)) {
			throw new VrcodeErrorException("验证码错误");
		}
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
		SecurityUtils.getSubject().login(usernamePasswordToken);
		return new ResponseInfo(HttpStatus.OK.value() + "", "success");
	}

}
