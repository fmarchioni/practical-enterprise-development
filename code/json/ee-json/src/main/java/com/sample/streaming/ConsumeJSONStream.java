package com.sample.streaming;

import jakarta.json.Json;
import jakarta.json.stream.JsonParser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/ConsumeJSONStream")
public class ConsumeJSONStream extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		
		jakarta.json.stream.JsonParser parser = Json.createParser(this.getClass()
				.getClassLoader().getResourceAsStream("data.json"));

		
		while (parser.hasNext()) {
			JsonParser.Event event = parser.next();

			switch (event) {
			case START_ARRAY:
				writer.write(event.toString() + "\n");
				break;
			case END_ARRAY:
				writer.write(event.toString() + "\n");
				break;
			case START_OBJECT:
				writer.write("Found JSON object \n");
				break;
			case END_OBJECT:
				writer.write("\nEnd JSON object"+ "\n");
				break;
			case VALUE_FALSE:
			case VALUE_NULL:
			case VALUE_TRUE:
			case KEY_NAME:
				writer.write(event.toString() + " " + parser.getString()
						+ " - ");
				break;
			case VALUE_STRING:
				writer.write(event.toString() + " " + parser.getString()
						+ " - ");
				break;
			case VALUE_NUMBER:
				writer.write(event.toString() + " " + parser.getString());
				break;
			}
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
