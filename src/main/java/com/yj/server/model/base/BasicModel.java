package com.yj.server.model.base;

import java.sql.Timestamp;

/**
 * 
 * 
 * 功能描述： 实体类的基类 创建人：Administrator 创建时间：2018年9月16日 上午12:31:48
 * 
 * @version
 *
 */
public class BasicModel {

	private long databaseId;// 数据库id
	private Timestamp createTime;// 创建时间

	public long getDatabaseId() {
		return databaseId;
	}

	public void setDatabaseId(long databaseId) {
		this.databaseId = databaseId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}
