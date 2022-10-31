package com.itbuzzpress.websocket.endpoint;
 

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;

 
@ServerEndpoint(value="/hello")
	  
 

public class HelloWorldEndpoint {
	@OnMessage
	public String hello(String message) {
		System.out.println("Received : "+ message);
		return "Hello from HelloWorldEndpoint";
	}
	@OnOpen
	public void myOnOpen(Session session) {
		System.out.println("WebSocket opened: " + session.getId());
	}
	@OnClose
	public void myOnClose(CloseReason reason) {
	}
    @OnError
    public void error(Throwable t) {      
    	
    }
}
