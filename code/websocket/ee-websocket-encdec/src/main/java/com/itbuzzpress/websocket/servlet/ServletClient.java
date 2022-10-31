package com.itbuzzpress.websocket.servlet;


import com.itbuzzpress.websocket.endpoint.WebSocketEncodedEndpoint;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.ContainerProvider;
import jakarta.websocket.WebSocketContainer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
 
 
 
 
@WebServlet("/connect")

public class ServletClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out = response.getWriter();  
		try {
           
			WebSocketContainer container = ContainerProvider.getWebSocketContainer();
			String uri = "ws://localhost:8080/ee-websocket-encdec/helloencoded";
			container.connectToServer(WebSocketEncodedEndpoint.class, URI.create(uri));
			out.println("Message sent to Encoded WebSocket!");
			out.println("Check Server Logs.");
			 
		} catch (Exception e) {
			e.printStackTrace();
			out.println("Opps! it seems there was an error invoking the WebSocket !"+e.getMessage());
		}  
		 
	}

	 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
