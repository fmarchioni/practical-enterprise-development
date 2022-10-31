package com.sample.objectmodel;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ProduceJSON") 
public class ProduceJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		
		JsonObject obj = Json.createObjectBuilder()
				.add("name", "Nicolas")
				.add("surname", "Cage")
				.add("age", 50)
				.add("movies", Json.createArrayBuilder()
					.add("The Family Man ")
					.add("Gone in Sixty Seconds ")
					.add("City of Angels ")).build();   

	 
		Json.createWriter(writer).writeObject(obj);
		 
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
