package com.itbuzzpress.jaxws.handler;


import javax.xml.transform.dom.DOMSource;
import jakarta.xml.ws.LogicalMessage;
import jakarta.xml.ws.handler.LogicalHandler;
import jakarta.xml.ws.handler.LogicalMessageContext;
import jakarta.xml.ws.handler.MessageContext;
import org.w3c.dom.Node;





public class  SampleLogicalHandler implements LogicalHandler {
	@Override
	public boolean handleMessage(MessageContext context) {


		LogicalMessage   soapmc = ((LogicalMessageContext)context).getMessage();

		DOMSource source = (DOMSource) soapmc.getPayload();
		Node rootNode = source.getNode();
		System.out.println("[Logical Handler] Root Node"+rootNode.getNodeName());
		// Manipulate DOM here
		// . . . .
		source.setNode(rootNode);
		soapmc.setPayload(source);
		return true; 

 
	}


	@Override
	public boolean handleFault(MessageContext context) {
		return false;
	}
	@Override
	public void close(MessageContext context) {
		//. . .
	}
	
 
}
