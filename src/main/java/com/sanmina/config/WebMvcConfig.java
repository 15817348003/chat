package com.sanmina.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * spring mvc的配置类
 * @author cat
 *
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//添加url映射 /ws到ws.html文件
		registry.addViewController("/ws").setViewName("/ws");
		registry.addViewController("/login").setViewName("/login");
		registry.addViewController("/chat").setViewName("/chat");
	
	}
	
}
