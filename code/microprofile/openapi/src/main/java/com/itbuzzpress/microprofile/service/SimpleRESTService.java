package com.itbuzzpress.microprofile.service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import com.itbuzzpress.microprofile.model.SimpleProperty;

@Tag(name = "OpenAPI Example", description = "Get a text in various formats")

@Path("/simple")
public class SimpleRESTService {
	@GET
	@Operation(operationId = "all", description = "Getting Hello Text")
	@APIResponse(responseCode = "200", description = "Successful, Text")
	@Path("/text")
	public String getHello () 
	{
		return "hello world!";
	}

	@GET
	@Operation(operationId = "all", description = "Getting Hello JSON")
	@APIResponse(responseCode = "500", description = "Error in generating JSON")
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public SimpleProperty getPropertyJSON () 
	{
        SimpleProperty p = new SimpleProperty("key","value");
		return p;
	}
	@GET
	@Path("/xml")
	@Operation(operationId = "all", description = "Getting Hello XML")
	@APIResponse(responseCode = "200", description = "Successful, return XML")
	@Produces(MediaType.APPLICATION_XML)
	public SimpleProperty getPropertyXML () 
	{
        SimpleProperty p = new SimpleProperty("key","value");
		return p;
	}
}
