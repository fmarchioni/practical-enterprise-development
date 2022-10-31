package com.itbuzzpress.jaxrs.service;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/simple")
public class SimpleRESTService {
	@GET
	public String getHello ()
	{
		return "hello world!";
	}

	@POST
	public Response setHello (String greeting)
	{
		System.out.println(greeting);
		return Response.status(Response.Status.OK).build();
	}

}
