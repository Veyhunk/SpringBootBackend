package com.yj.server.intecepter;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;
import com.yj.server.annotation.LogAnnotation;
import com.yj.server.model.SystemLog;
import com.yj.server.model.SystemUser;
import com.yj.server.service.SystemLogService;
import com.yj.server.util.UserUtil;
import com.yj.server.util.WebUtil;

/**
 * 
 * 
 * 功能描述：同一日志的处理 创建人：Administrator 创建时间：2018年9月14日 下午10:44:46
 * 
 * @version
 *
 */
@Aspect
@Component
public class LogAspect {
	@Autowired
	private SystemLogService systemLogService;

	/**
	 * 自定义注解处进行日志操作
	 * 
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around(value = "@annotation(com.yj.server.annotation.LogAnnotation)")
	public Object logSave(ProceedingJoinPoint joinPoint) throws Throwable {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		String module = null;// 自定义日志模块的属性
		LogAnnotation logAnnotation = methodSignature.getMethod().getDeclaredAnnotation(LogAnnotation.class);
		module = logAnnotation.module();
		SystemLog log = new SystemLog();
		SystemUser user = UserUtil.getCurrentUser();
		if (null != user) {
			log.setUserName(user.getUserName());
		}
		log.setModule(module);
		log.setParam(JSONObject.toJSONString(getParamNameAndValue(joinPoint)));
		log.setCreateTime(new Timestamp(System.currentTimeMillis()));
		/// 获取参数列表和参数值
		log.setRemark("参数列表:" + JSONObject.toJSONString(getParamNameAndValue(joinPoint)));
		// 获取request
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		log.setIp(WebUtil.getIpAddress(request));
		systemLogService.saveLog(log);
		// 让controller方法继续，返回的对象为controller带有LogAnnotation注解的方法返回的
		return joinPoint.proceed();
	}

	/**
	 * 获取下参数列表的值
	 * 
	 * @return
	 */
	private HashMap<String, Object> getParamNameAndValue(ProceedingJoinPoint joinPoint) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		List<String> names = Arrays.asList(methodSignature.getParameterNames());
		Object[] args = joinPoint.getArgs();
		for (int i = 0; i < names.size(); i++) {
			result.put(names.get(i), args[i]);
		}
		return result;
	}
}
