package com.itbuzzpress.jpa.service;


import com.itbuzzpress.jpa.ejb.ManagerEJB;
import com.itbuzzpress.jpa.entity.Customer;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/customer")
@Produces("application/json")
@Consumes("application/json")
public class CustomerService {

    
	@Inject ManagerEJB ejb;

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
