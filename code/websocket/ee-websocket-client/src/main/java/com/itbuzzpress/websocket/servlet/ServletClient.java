package com.itbuzzpress.websocket.servlet;

import com.itbuzzpress.websocket.endpoint.WebSocketEndpoint;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.ContainerProvider;
import jakarta.websocket.Session;
import jakarta.websocket.WebSocketContainer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;

/**
 * Servlet implementation class ServletClient
 */
@WebServlet("/connect")
public class ServletClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ServletClient() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		WebSocketContainer container = ContainerProvider
				.getWebSocketContainer();
		String uri = "ws://localhost:8080/ee-websocket-client/hello";
		try {
			Session session = container.connectToServer(
					WebSocketEndpoint.class, new URI(uri));

			out.println("Message sent to WebSocket EndPoint!");
			out.println("Check Server Logs.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
