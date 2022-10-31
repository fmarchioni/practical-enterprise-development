package com.itbuzzpress.jaxrs.service;

import com.itbuzzpress.jaxrs.model.SimpleProperty;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;




@Path("/")
public class SimpleRESTService {
	@GET
	@Path("/text")
	public String getHello ()
	{
		return "hello world!";
	}
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public SimpleProperty getPropertyJSON ()
	{
        SimpleProperty p = new SimpleProperty("key","value");
		return p;
	}
	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	public SimpleProperty getPropertyXML ()
	{
        SimpleProperty p = new SimpleProperty("key","value");
		return p;
	}
}
