package com.yj.server.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @Description: 日志注解 在相关controller此注解 填写相关模块的名称 即可存入日志
 * @author zhhy19891013
 * @date 2018年9月17日 下午5:31:30
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAnnotation {
	String module() default "";
}
