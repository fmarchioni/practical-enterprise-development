package com.itbuzzpress.microprofile.configuration;

import java.io.IOException;
import java.util.List;
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
		response.getWriter().append("Got name: ").append(name);
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