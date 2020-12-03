package com.itbuzzpress.jaxrs.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.inject.Inject;
import javax.ws.rs.*;

import com.itbuzzpress.jpa.entity.Customer;

import javax.ws.rs.core.Response;

@Path("/customer")
@Produces("application/json")
@Consumes("application/json")
public class CustomerService {

    
	@Inject
	com.itbuzzpress.jpa.ejb.ManagerBean ejb;

	@POST
	public Response create(Customer customer) {
		ejb.createCustomer(customer);
		return Response.status(201).build();
	}

	@GET
	public List<Customer> findAllCustomers() {
		return ejb.findAllCustomers();
	}

	@PUT
	public Response updateCustomer(Customer customer) {
		ejb.updateCustomer(customer);
		return Response.status(204).build();
	}
	@DELETE
	public Response delete(@QueryParam("id") Long id) {
		ejb.deleteCustomer(id);
		return Response.status(204).build();
	}
}
