package com.itbuzzpress.jms.mdb;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;
import org.jboss.ejb3.annotation.ResourceAdapter;

@MessageDriven(name = "HelloWorldQueueMDB", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "queue/exampleQueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")})

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
