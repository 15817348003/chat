package com.sanmina.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.sanmina.entity.message.TestMessage;
import com.sanmina.entity.message.TestResponse;

@Controller
public class TestWebSokctContorller {

	//通过/welcome这个url向服务器请求
	@MessageMapping("/welcome")
	//当服务端有消息时，会对订阅了/topic/getResponse这个路径的浏览器发送消息
	@SendTo("/topic/getResponse")
	public TestResponse say(TestMessage message) throws InterruptedException{
		Thread.sleep(2000);
		return new TestResponse("welcome," + message.getName());
	}
	
	//通过SimpMessagingTemplate 向浏览器发送消息
	@Autowired
	SimpMessagingTemplate messagingTemplate;
	
	//principal包含用户信息
	@MessageMapping("/chat")
	public void handleChat(Principal principal, String msg){
		if(principal.getName().equals("cat")){
			messagingTemplate.convertAndSendToUser("nizgg", "/queue/notifications", principal.getName() + "_send: "
					+ msg);
		} else {
			messagingTemplate.convertAndSendToUser("cat", "/queue/notifications", principal.getName() + "_send: "
					+ msg);
		}
	}
	
}
