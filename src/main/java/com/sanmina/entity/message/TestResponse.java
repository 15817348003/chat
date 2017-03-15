package com.sanmina.entity.message;

/**
 * 广播消息响应的类
 * @author cat
 *
 */
public class TestResponse {
	private String responseMessage;

	public TestResponse(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	

}
