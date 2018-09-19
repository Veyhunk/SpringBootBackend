package com.yj.server.service;

import com.yj.server.model.SystemLog;

/**
 * 
 * @Description: 系统日志
 * @author zhhy19891013
 * @date 2018年9月19日 下午9:00:11
 */
public interface SystemLogService {

	void saveLog(SystemLog log);

}
