package com.itbuzzpress.websocket.endpoint;
 

import java.io.IOException;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

import com.itbuzzpress.websocket.encoder.*;
import com.itbuzzpress.websocket.model.User;
import com.itbuzzpress.websocket.decoder.*;
@ServerEndpoint(value = "/helloencoded",
encoders = { MessageEncoder.class},
decoders = { MessageDecoder.class})

public class HelloWorldEncodedEndpoint {
	@OnMessage
	public void onMessage(User person, Session session) {
	        System.out.println("Message Received from " + person.getEmail());
	        // Validate email
	        // .......
	        person.setRegistered(true);  
	        try {
				session.getBasicRemote().sendObject(person);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EncodeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	 }
	

}
