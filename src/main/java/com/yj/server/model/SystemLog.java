package com.yj.server.model;

import com.yj.server.model.base.BasicModel;

/**
 * 
 * 
 * 功能描述： 系统日志 创建人：Administrator 创建时间：2018年9月16日 下午9:13:34
 * 
 * @version
 *
 */
public class SystemLog extends BasicModel {
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 模块
	 */
	private String module;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 登录ip
	 */
	private String ip;
	/**
	 * 参数
	 */
	private String param;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

}
