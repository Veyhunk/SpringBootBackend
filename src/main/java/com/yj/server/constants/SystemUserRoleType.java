package com.yj.server.constants;

/**
 * 
 * 
 * 功能描述：系统用户类型 
 * 创建人：Administrator 创建时间：2018年9月16日 下午9:50:44
 * 
 * @version
 *
 */
public enum SystemUserRoleType {
	/**
	 * 管理员
	 */
	ADMIN(-1),
	/**
	 * 渠道
	 */
	QUDAO(0),
	/**
	 * 代理
	 */
	PROXY(1);

	private int type;

	private SystemUserRoleType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
