package com.itbuzzpress.microprofile.configuration;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@WebServlet(name = "config", urlPatterns = { "/config" })
public class ConfigServlet extends HttpServlet {
	@Inject
	@ConfigProperty(name = "name")
	String prop1;
	@Inject
	@ConfigProperty(name = "surname")
	String prop2;
	public ConfigServlet() {
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Got property1 with: ").append(prop1);
		response.getWriter().append("<br/>Got property2 with: ").append(prop2);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}