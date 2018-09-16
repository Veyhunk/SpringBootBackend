package com.yj.server.model;

import java.sql.Timestamp;

import com.yj.server.model.base.BasicModel;

/**
 * 
 * 
 * 功能描述： 系统用户实体类 创建人：Administrator 创建时间：2018年9月16日 上午12:30:58
 * 
 * @version
 *
 */
public class SystemUser extends BasicModel {
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 最后登录时间
	 */
	private Timestamp lastLoginTime;
	/**
	 * 用户角色
	 */
	private int roleType;
	/**
	 * 手机号
	 */
	private String phone;
	/**
	 * 微信号
	 */
	private String wx;
	/**
	 * 支付宝
	 */
	private String zfb;
	/**
	 * 上级用户id
	 */
	private long fatherUserId;
	/**
	 * 上级用户名
	 */
	private String fatherName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public int getRoleType() {
		return roleType;
	}

	public void setRoleType(int roleType) {
		this.roleType = roleType;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWx() {
		return wx;
	}

	public void setWx(String wx) {
		this.wx = wx;
	}

	public String getZfb() {
		return zfb;
	}

	public void setZfb(String zfb) {
		this.zfb = zfb;
	}

	public long getFatherUserId() {
		return fatherUserId;
	}

	public void setFatherUserId(long fatherUserId) {
		this.fatherUserId = fatherUserId;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

}
