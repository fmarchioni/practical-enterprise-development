package com.itbuzzpress.jpa.ejb;

import com.itbuzzpress.jpa.entity.Customer;
import com.itbuzzpress.jpa.entity.Request;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import jakarta.ws.rs.WebApplicationException;

import java.util.List;
import java.util.logging.Logger;

@Stateless
public class ManagerEJB {
	@PersistenceContext
	EntityManager em;

	@PersistenceUnit
	EntityManagerFactory emf;

	private static final Logger LOGGER = Logger.getLogger(ManagerEJB.class.getName());

	public void createCustomer(Customer customer) {
		em.persist(customer);
		LOGGER.info("Created Customer "+customer);

	}

	public void createRequest(Long id, Request request) {
		Customer customer = findCustomerById(id);
		request.setCustomer(customer);
		em.persist(request);
		LOGGER.info("Created Request "+request);

	}

	public void updateCustomer( Customer customer ) {
		Customer customerToUpdate = findCustomerById(customer.getId());
		customerToUpdate.setName(customer.getName());
		customerToUpdate.setEmail(customer.getEmail());
		customerToUpdate.setAddress(customer.getAddress());
		customerToUpdate.setPhoneNumber(customer.getPhoneNumber());
		LOGGER.info("Updated customer" + customer);
	}

	public void updateRequest( Request request ) {
		Request requestToUpdate = findRequestById(request.getId());
		requestToUpdate.setProduct(request.getProduct());
		requestToUpdate.setQuantity(request.getQuantity());
		LOGGER.info("Updated request" + request);
	}

	public void deleteCustomer(Long customerId) {
		Customer c = findCustomerById(customerId);
		em.remove(c);
		LOGGER.info("Deleted Customer with id" + customerId);
	}

	public void deleteRequest(Long requestId) {
		Request r = findRequestById(requestId);
		em.remove(r);
		LOGGER.info("Deleted request with id" + requestId);
	}

	public Customer findCustomerById(Long id) {
		Customer customer = em.find(Customer.class, id);
		if (customer == null) {
			throw new WebApplicationException("Customer with id of " + id + " does not exist.", 404);
		}
		return customer;
	}

	public Request findRequestById(Long id) {
		Request request = em.find(Request.class, id);
		if (request == null) {
			throw new WebApplicationException("Request with id of " + id + " does not exist.", 404);
		}
		return request;
	}
	public List<Customer> findAllCustomers() {
		Query query = em.createQuery("SELECT c FROM Customer c");
		List<Customer> customerList = query.getResultList();
		return customerList;
	}

	public List<Request> findAllRequests() {
		Query query = em.createQuery("SELECT r FROM Request r");
		List<Request> customerOrders = query.getResultList();
		return customerOrders;
	}

	public Customer findCustomerByName(String name) {
		Query query = em
				.createQuery("SELECT c FROM Customer c WHERE c.name = :name");
		query.setParameter("name", name);
		Customer customer = (Customer) query.getSingleResult();
		return customer;
	}

	public List<Request> findAllRequestsByCustomer(String name) {
		Query query = em
				.createQuery("SELECT r FROM Request r WHERE customer.name = :name");
		query.setParameter("name", name);
		List<Request> customerOrders = query.getResultList();
		return customerOrders;
	}
}
