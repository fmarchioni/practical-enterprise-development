package com.itbuzzpress.jaxrs.service;



import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.container.AsyncResponse;
import jakarta.ws.rs.container.Suspended;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import com.itbuzzpress.jaxrs.model.SimpleProperty;



//Example URL: http://localhost:8080/rest/simple/text

@Path("/simple")
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
        SimpleProperty p = new SimpleProperty("A","B");
		return p;
	}
	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	public SimpleProperty getPropertyXML ()
	{
        SimpleProperty p = new SimpleProperty("A","B");
		return p;
	}
}
