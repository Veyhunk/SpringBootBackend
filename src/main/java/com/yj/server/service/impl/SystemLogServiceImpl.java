package com.yj.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.yj.server.dao.SystemLogDao;
import com.yj.server.model.SystemLog;
import com.yj.server.service.SystemLogService;

@Service
public class SystemLogServiceImpl implements SystemLogService {
	@Autowired
	private SystemLogDao systemLogDao;

	@Override
	@Async
	public void saveLog(SystemLog log) {
		systemLogDao.addLog(log);
	}

}
