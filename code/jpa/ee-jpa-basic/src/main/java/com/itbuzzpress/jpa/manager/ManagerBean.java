package com.itbuzzpress.jpa.ejb;

import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.PersistenceContext;

import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import com.itbuzzpress.jpa.entity.Customer;
import com.itbuzzpress.jpa.entity.Request;
import javax.ws.rs.WebApplicationException;
import javax.transaction.Transactional;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ManagerBean {
	@PersistenceContext
	EntityManager em;

	@PersistenceUnit
	EntityManagerFactory emf;

	@Transactional
	public void createCustomer(Customer customer) {
		em.persist(customer);
		System.out.println("Created Customer");

	}

	@Transactional
	public void createRequest(Long id, Request request) {
		Customer customer = findCustomerById(id);
		request.setCustomer(customer);
		em.persist(request);
		System.out.println("Created Request");

	}


	@Transactional
	public void updateCustomer( Customer customer ) {

		Customer customerToUpdate = findCustomerById(customer.getId());
		customerToUpdate.setName(customer.getName());
		customerToUpdate.setEmail(customer.getEmail());
		customerToUpdate.setAddress(customer.getAddress());
		customerToUpdate.setPhoneNumber(customer.getPhoneNumber());
		System.out.println("Updated customer" + customer);
	}

	@Transactional
	public void updateRequest( Request request ) {

		Request requestToUpdate = findRequestById(request.getId());
		requestToUpdate.setProduct(request.getProduct());
		requestToUpdate.setQuantity(request.getQuantity());

		System.out.println("Updated customer" + request);
	}

	@Transactional
	public void deleteCustomer(Long customerId) {

		Customer c = findCustomerById(customerId);
		em.remove(c);
	}

	@Transactional
	public void deleteRequest(Long requestId) {

		Request r = findRequestById(requestId);
		em.remove(r);
	}

	@Transactional
	public Customer findCustomerById(Long id) {

		Customer customer = em.find(Customer.class, id);

		if (customer == null) {
			throw new WebApplicationException("Customer with id of " + id + " does not exist.", 404);
		}
		return customer;
	}
	@Transactional
	public Request findRequestById(Long id) {

		Request request = em.find(Request.class, id);

		if (request == null) {
			throw new WebApplicationException("Request with id of " + id + " does not exist.", 404);
		}
		return request;
	}
	public List<Customer> findAllCustomers() {
		Query query = em.createQuery("FROM Customer");
		List<Customer> customerList = query.getResultList();
		return customerList;
	}

	public List<Request> findAllRequests() {
		Query query = em.createQuery("FROM Request");
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
