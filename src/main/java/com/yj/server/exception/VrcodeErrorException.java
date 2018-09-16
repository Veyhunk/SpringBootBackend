package com.yj.server.exception;

/**
 * 
 * 
 * 功能描述： 验证码异常 创建人：Administrator 创建时间：2018年9月16日 上午11:18:36
 * 
 * @version
 *
 */
public class VrcodeErrorException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public VrcodeErrorException(String msg) {
		super(msg);
	}

}
