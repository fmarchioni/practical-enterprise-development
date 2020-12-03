package com.itbuzzpress.jaxrs.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.inject.Inject;
import javax.ws.rs.*;

import com.itbuzzpress.jpa.entity.Customer;
import com.itbuzzpress.jpa.entity.Request;
import com.itbuzzpress.jpa.ejb.ManagerEJB;
import javax.ws.rs.core.Response;

@Path("/request")
@Produces("application/json")
@Consumes("application/json")
public class RequestService {

    
	@Inject ManagerBean ejb;

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
        System.out.println("Looking for customer "+customer);
		return ejb.findAllRequestsByCustomer(customer);
	}
}
