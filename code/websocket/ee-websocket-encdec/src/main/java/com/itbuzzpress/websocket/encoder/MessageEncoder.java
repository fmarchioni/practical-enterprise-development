package com.itbuzzpress.websocket.encoder;


import com.itbuzzpress.websocket.model.User;
import jakarta.websocket.EncodeException;
import jakarta.websocket.Encoder;
import jakarta.websocket.EndpointConfig;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

import java.io.StringWriter;
 
public class MessageEncoder implements Encoder.Text<User> {
    public String encode(User object) throws EncodeException {
        JAXBContext jaxbContext = null;
        StringWriter st = null;
        try {
            jaxbContext = JAXBContext.newInstance(User.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            st = new StringWriter();
            marshaller.marshal(object, st);
            System.out.println("OutGoing XML " + st.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return st.toString();
    }
    public void init(EndpointConfig endpointConfig) {
        // do nothing.
    }
    public void destroy() {
        // do nothing.
    }
}
