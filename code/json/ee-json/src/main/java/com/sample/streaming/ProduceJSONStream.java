package com.sample.streaming;

import jakarta.json.Json;
import jakarta.json.stream.JsonGenerator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

 
@WebServlet("/ProduceJSONStream")
public class ProduceJSONStream extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();

		JsonGenerator generator = Json.createGenerator(writer);

		generator.writeStartArray().writeStartObject().write("name", "Nicolas")
				.write("surname", "Cage").writeEnd().writeStartObject()
				.write("name", "John").write("surname", "Travolta").writeEnd()
				.writeEnd();
	




		generator.flush();

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
