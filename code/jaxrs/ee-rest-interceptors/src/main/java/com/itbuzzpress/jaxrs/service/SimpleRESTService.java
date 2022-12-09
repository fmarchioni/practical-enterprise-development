package com.itbuzzpress.jaxrs.service;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import com.itbuzzpress.jaxrs.interceptor.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.Consumes;
@Path("/simple")
public class SimpleRESTService {
	@GET
	public String getHello ()
	{
		return "hello world!";
	}

	@POST
	public Response setHello (String input)
	{
		System.out.println(input);
		return Response.status(Response.Status.OK).build();
	}

}
