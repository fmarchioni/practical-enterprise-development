package com.itbuzzpress.jms.controller;

import jakarta.annotation.Resource;
import jakarta.enterprise.inject.Model;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.jms.JMSContext;
import jakarta.jms.Queue;

@Model
public class MessageSender {
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Inject
	JMSContext context;

	@Resource(mappedName = "java:/queue/exampleQueue")
	private Queue queue;

	public void sendMessage() {
		context.createProducer().send(queue, message);
		
		
		printMessage("Sent message " + message);
	}

	private void printMessage(String string) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, string, string));

	}
	 

}
