package com.itbuzzpress.servlet.push;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.PushBuilder;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = { "/pushresource" })
public class PushResources extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PushBuilder pushBuilder = req.newPushBuilder();
		if (pushBuilder != null) {
			pushBuilder.path("css/style.css").push();
			pushBuilder.path("css/myscript.js").push();

		}
		try (PrintWriter respWriter = resp.getWriter();) {
			respWriter.write("<html><head>" + "<link rel=\"stylesheet\" href=\"css/style.css\"></head>"
					+ "<script src=\"css/myscript.js\"></script><body onload=\"hello()\"></body></html>");
		}

	}
}
