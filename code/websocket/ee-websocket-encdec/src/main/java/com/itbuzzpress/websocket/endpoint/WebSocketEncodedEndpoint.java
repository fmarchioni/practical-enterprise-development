 

package com.itbuzzpress.websocket.endpoint;


import com.itbuzzpress.websocket.decoder.MessageDecoder;
import com.itbuzzpress.websocket.encoder.MessageEncoder;
import com.itbuzzpress.websocket.model.User;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;

@jakarta.websocket.ClientEndpoint(
encoders = { MessageEncoder.class},
decoders = { MessageDecoder.class})
	public class WebSocketEncodedEndpoint {

	    @OnOpen
	    public void onOpen(Session session) {
	        try {
	        	User person = new User();
	        	person.setName("john");
	        	person.setSurname("smith");
	        	person.setEmail("acme@gmail.com");

	        	
	            session.getBasicRemote().sendObject(person);
	            
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @OnMessage
	    public void onMessage(String message) {
	        System.out.println("Received response from server: "+ message);
	    }
	}