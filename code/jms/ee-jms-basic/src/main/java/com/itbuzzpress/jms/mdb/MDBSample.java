package com.itbuzzpress.jms.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.jboss.ejb3.annotation.ResourceAdapter;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/queue/exampleQueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"), })
@ResourceAdapter(value = "activemq-rar.rar")
public class MDBSample implements MessageListener {

	public void onMessage(Message message) {
		try {
			TextMessage tm = (TextMessage) message;
			System.out.println("Message received  : " + tm.getText());
		} catch (JMSException ex) {
			ex.printStackTrace();
		}
	}

}
