package com.yj.server.exception;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.yj.server.dto.ResponseInfo;

/**
 * 
 * 
 * 功能描述： 全局异常处理 创建人：Administrator 创建时间：2018年9月16日 上午10:46:21
 * 
 * @version
 *
 */
@RestControllerAdvice
public class ExceptionHandlerAdvice {

	/**
	 * 用户不存在或账号密码错误异常 返回401
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler({ UnknownAccountException.class, IncorrectCredentialsException.class })
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ResponseInfo loginException(Exception exception) {
		return new ResponseInfo(HttpStatus.UNAUTHORIZED.value() + "", exception.getMessage());
	}

	/**
	 * 认证异常 返回403
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler({ UnauthorizedException.class })
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ResponseInfo forbidden(Exception exception) {
		return new ResponseInfo(HttpStatus.FORBIDDEN.value() + "", exception.getMessage());
	}

	/**
	 * 验证码错误异常
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler({ VrcodeErrorException.class })
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ResponseInfo vrcodeError(Exception exception) {
		return new ResponseInfo(HttpStatus.UNAUTHORIZED.value() + "", exception.getMessage());
	}

}
