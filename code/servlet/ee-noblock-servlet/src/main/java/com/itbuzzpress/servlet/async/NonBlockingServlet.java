package com.itbuzzpress.servlet.async;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/noblock", urlPatterns = { "/noblock" }, asyncSupported = true)
public class NonBlockingServlet  extends HttpServlet {
	 
 

	public NonBlockingServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		writer.println("Please use POST method from the index page");
		writer.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		final AsyncContext acontext = request.startAsync();
		final ServletInputStream input = request.getInputStream();

		input.setReadListener(new ExampleReadListener(input, acontext));
		PrintWriter writer = response.getWriter();
		writer.println("Non Blocking Servlet completed. Check logs.");
		writer.flush();
	}

}
