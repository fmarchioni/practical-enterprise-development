package com.itbuzzpress.microprofile.service;

import com.itbuzzpress.microprofile.model.SimpleProperty;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.UUID;

@Tag(name = "OpenAPI Example", description = "Get a text in various formats")

@Path("/simple")
public class SimpleRESTService {
	@GET
	@Operation(description = "Getting Hello Text")
	@APIResponse(responseCode = "200", description = "Successful, Text")
	@Path("/text")
	public String getHello () 
	{
		return "hello world!";
	}

	@GET
	@Operation(description = "Getting Hello JSON")
	@APIResponse(responseCode = "500", description = "Error in generating JSON")
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public SimpleProperty getPropertyJSON () 
	{
		SimpleProperty p = new SimpleProperty(UUID.randomUUID().toString(),
				UUID.randomUUID().toString());
		return p;
	}
	@GET
	@Path("/xml")
	@Operation(description = "Getting Hello XML")
	@APIResponse(responseCode = "200", description = "Successful, return XML")
	@Produces(MediaType.APPLICATION_XML)
	public SimpleProperty getPropertyXML () 
	{
		SimpleProperty p = new SimpleProperty(UUID.randomUUID().toString(),
				UUID.randomUUID().toString());
		return p;
	}
}
