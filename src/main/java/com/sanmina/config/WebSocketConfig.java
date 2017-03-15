package com.sanmina.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * websocket的配置类
 * @author cat
 *
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		//配置一个/topic广播消息代理,配置一个/queue消息代理（点对点式）
		registry.enableSimpleBroker("/queue","/topic");
		
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		//注册一个stomp的节点并指定url且指定使用sockjs协议
		registry.addEndpoint("/mytest").withSockJS();
		registry.addEndpoint("/testChat").withSockJS();
	}
	

}
