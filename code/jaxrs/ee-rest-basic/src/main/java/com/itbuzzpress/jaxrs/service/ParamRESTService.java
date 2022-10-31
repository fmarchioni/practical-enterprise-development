package com.itbuzzpress.jaxrs.service;


import com.itbuzzpress.jaxrs.ejb.DataList;
import com.itbuzzpress.jaxrs.model.SimpleProperty;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;





@Path("/param")
public class ParamRESTService {
    String RESPONSE_OK="<p>Property has been added ! </p>" +
		"<p><a href=\"http://localhost:8080/\">Back</a></p>";
    
	@Inject DataList ejb;

	@GET
	@Path("/xml/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public SimpleProperty getPropertyByPathParam(@PathParam("id")int id) 
	{
		return ejb.getList().get(id);
	}

	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	public SimpleProperty getPropertyByQueryId(@QueryParam("id") int id) 
	{
		return ejb.getList().get(id);
	}
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_XML)
	public List<SimpleProperty> getProperty() 
	{
		return ejb.getList();
	}
	@POST
	@Produces("text/html")
	public Response createProperty(@FormParam("key")String key,
			@FormParam("value")String value)
	{	 
		int n = ejb.addToList(key,value);	 
		return Response.ok(RESPONSE_OK).build();	 

	}  
 
}
