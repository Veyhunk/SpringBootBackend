package com.yj.server.dao;

import org.apache.ibatis.annotations.Mapper;

import com.yj.server.model.SystemLog;

/**
 * 
 * 
 * 功能描述：系统日志 创建人：Administrator 创建时间：2018年9月16日 下午9:30:34
 * 
 * @version
 *
 */
@Mapper
public interface SystemLogDao {
	/**
	 * 新增日志
	 * 
	 * @param log
	 */
	void addLog(SystemLog log);
}
