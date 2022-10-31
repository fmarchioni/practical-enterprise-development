package com.sample.objectmodel;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ProduceJSONArray")  
public class ProduceJSONArray extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		
		JsonArray jsonArray = Json.createArrayBuilder()
				.add(Json.createObjectBuilder() 
					.add("name", "Nicolas")
					.add("surname", "Cage")
				  .build())
				.add(Json.createObjectBuilder()//Another object builder to build JSON Object.
					.add("name", "John")
					.add("surname", "Travolta")
				  .build()).build();
			Json.createWriter(writer).writeArray(jsonArray);

		 
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
