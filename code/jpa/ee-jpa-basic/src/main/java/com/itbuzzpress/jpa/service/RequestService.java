package com.itbuzzpress.jpa.service;


import com.itbuzzpress.jpa.ejb.ManagerEJB;
import com.itbuzzpress.jpa.entity.Request;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/request")
@Produces("application/json")
@Consumes("application/json")
public class RequestService {

    
	@Inject ManagerEJB ejb;

	@POST
	@Path("/{id}")
	public Response createRequest(@PathParam("id") Long id, Request request) {
		ejb.createRequest(id, request);
		return Response.status(201).build();
	}

	@GET
	public List<Request> findRequests() {
		return ejb.findAllRequests();
	}

	@PUT
	public Response updateRequest(Request request) {
		ejb.updateRequest(request);
		return Response.status(204).build();
	}
	@DELETE
	public Response deleteRequest(@QueryParam("id") Long id) {
		ejb.deleteRequest(id);
		return Response.status(204).build();
	}

	@GET
	@Path("/{customer}")
	public List<Request> findAllRequestsByCustomer(@PathParam("customer") String customer) {
		return ejb.findAllRequestsByCustomer(customer);
	}
}
