package com.yj.server;

import javax.jms.ConnectionFactory;
import javax.servlet.MultipartConfigElement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

/**
 * @Description: 启动类
 * @author zhhy19891013
 * @date 2018年9月17日 下午5:30:50
 */
@SpringBootApplication
@MapperScan("com.yj.server.dao")
@EnableJms // 启动jms服务器（本项目中用于activemq）
@ServletComponentScan // 配套filter使用
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	/*
	 * 
	 * 配置最大上传文件大小
	 */
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		// 单个文件最大
		factory.setMaxFileSize("10240KB");
		// 设置总上传数据总大小
		factory.setMaxRequestSize("1024000KB");
		return factory.createMultipartConfig();
	}

	/**
	 * 加入这个同时支持点对点和订阅者发布者模式
	 * 
	 * @param activeMQConnectionFactory
	 * @return
	 */
	@Bean
	public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
		DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
		bean.setPubSubDomain(true);
		bean.setConnectionFactory(activeMQConnectionFactory);
		return bean;
	}
}
