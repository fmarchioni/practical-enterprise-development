package com.itbuzzpress.cdi.microprofile.service;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;



@Path("/simple")
public class SimpleRESTService {
	@GET
	@Path("/text")
	public String getHello ()
	{
		return "hello world!";
	}

}
