package com.itbuzzpress.websocket.decoder;


import com.itbuzzpress.websocket.model.User;
import jakarta.websocket.Decoder;
import jakarta.websocket.EndpointConfig;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

import java.io.StringReader;

public class MessageDecoder implements Decoder.Text<User> {
 
   public User decode(String s) {
       System.out.println("Incoming XML " + s);
       User person = null;
       JAXBContext jaxbContext;
       try {
           jaxbContext = JAXBContext.newInstance(User.class);
           Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
           StringReader reader = new StringReader(s);
           person = (User) unmarshaller.unmarshal(reader);
       } catch (Exception ex) {
           ex.printStackTrace();
       }
       return person;
   }
   
   public boolean willDecode(String s) {
	   // Determine if the message can be converted  
       return (s != null);
   }
   
   public void init(EndpointConfig endpointConfig) {
       // do nothing.
   }
   
   public void destroy() {
       // do nothing.
   }
}
