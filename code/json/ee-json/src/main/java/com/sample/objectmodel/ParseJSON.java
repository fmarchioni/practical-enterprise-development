package com.sample.objectmodel;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Transaction
 */
// @Transactional
@WebServlet("/ParseJSON")
public class ParseJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	
		PrintWriter writer = response.getWriter();
		
		// File is picked up from the src/main/resources folder of your project
		JsonReader jsonReader = Json.createReader(this.getClass()
				.getClassLoader().getResourceAsStream("data.json"));
		JsonArray array = jsonReader.readArray();

		for (int i = 0; i < array.size(); i++) {
			JsonObject jObj = array.getJsonObject(i);
			writer.write("Found actor " + jObj.getString("name") + " " +jObj.getString("surname") +"\n");
			 
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
