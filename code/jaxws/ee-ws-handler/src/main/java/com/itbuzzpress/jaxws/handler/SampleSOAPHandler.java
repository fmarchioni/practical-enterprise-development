package com.itbuzzpress.jaxws.handler;

import javax.xml.namespace.QName;
import jakarta.xml.soap.SOAPMessage;
import jakarta.xml.ws.handler.MessageContext;
import jakarta.xml.ws.handler.soap.SOAPMessageContext;

import java.io.ByteArrayOutputStream;
import java.util.Set;

public class SampleSOAPHandler implements jakarta.xml.ws.handler.soap.SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext mc) {
		Boolean outboundProperty = (Boolean)
				mc.get (MessageContext.MESSAGE_OUTBOUND_PROPERTY);

		if (outboundProperty.booleanValue()) {
			System.out.println("\nOutbound message:");
		} else {
			System.out.println("\nInbound message:");
		}
		SOAPMessage soapMessage =
				((SOAPMessageContext)mc).getMessage();

		try {
			ByteArrayOutputStream baos = new
					ByteArrayOutputStream();
			soapMessage.writeTo(baos);
			System.out.println(baos.toString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}
	@Override
	public Set<QName> getHeaders() {
		return null;
	}

	@Override
	public void close(MessageContext mc) {
	}

	@Override
	public boolean handleFault(SOAPMessageContext mc) {
		return true;
	}	
}