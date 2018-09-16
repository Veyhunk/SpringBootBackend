package com.yj.server.dto;

import java.io.Serializable;

/**
 * 
 * 
 * 功能描述： 响应json信息 创建人：Administrator 创建时间：2018年9月16日 上午10:49:14
 * 
 * @version
 *
 */
public class ResponseInfo implements Serializable {

	private static final long serialVersionUID = -4417715614021482064L;

	private String code;// 状态码
	private String message;// 响应消息

	public ResponseInfo(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
