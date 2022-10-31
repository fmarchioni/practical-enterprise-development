package com.itbuzzpress.websocket.endpoint;


import jakarta.websocket.*;
 
 

@jakarta.websocket.ClientEndpoint()
public class WebSocketEndpoint   {
	 
 

	@OnOpen
	public void onOpen(Session session) {
		
	 
		 
	}
	 @OnClose
    public void onClose(Session userSession, CloseReason reason) {
        
        System.out.println("Session closed!");
    } 
	@OnMessage
	public void onMessage(String message) {
		System.out.println("Received message: " + message);
		 
	}

	 
    
}
