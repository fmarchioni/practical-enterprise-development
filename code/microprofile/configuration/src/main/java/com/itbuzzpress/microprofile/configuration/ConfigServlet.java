package com.itbuzzpress.microprofile.configuration;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "config", urlPatterns = { "/config" })
public class ConfigServlet extends HttpServlet {
	@Inject
	@ConfigProperty(name = "name")
	String name;

	@Inject
	@ConfigProperty(name = "year", defaultValue = "2020")
	Integer year;

	@Inject
	@ConfigProperty(name = "users")
	List<String> userList;

	public ConfigServlet() {
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append("<h2>Microprofile Config example</h2>").append(name);
		response.getWriter().append("<br/>Got name: ").append(name);
		response.getWriter().append("<br/>Got year with: ").append(String.valueOf(year));

		for (String user:userList)
			response.getWriter().append("<br/>Got User: ").append(user);

	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}