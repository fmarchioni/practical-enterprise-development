package com.itbuzzpress.jaxrs.service;

import com.itbuzzpress.jaxrs.model.SimpleProperty;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;



@RegisterRestClient(baseUri = "http://localhost:8080/ee-microprofile-rest-server/rest")
@Path("/api")
public interface SimpleRESTServiceItf {
	@GET
	@Path("/text")
	public String getHello();

	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public SimpleProperty getPropertyJSON();

	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	public SimpleProperty getPropertyXML();

}
