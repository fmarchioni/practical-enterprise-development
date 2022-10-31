package com.itbuzzpress.websocket.endpoint;


import com.itbuzzpress.websocket.decoder.MessageDecoder;
import com.itbuzzpress.websocket.encoder.MessageEncoder;
import com.itbuzzpress.websocket.model.User;
import jakarta.websocket.EncodeException;
import jakarta.websocket.OnMessage;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
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
