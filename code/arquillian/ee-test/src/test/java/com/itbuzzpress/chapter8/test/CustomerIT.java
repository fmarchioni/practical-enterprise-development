package com.itbuzzpress.arquillian.test;


import com.itbuzzpress.arquillian.ejb.ManagerEJB;
import com.itbuzzpress.arquillian.entity.Customer;
import com.itbuzzpress.arquillian.entity.Request;
import jakarta.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(Arquillian.class)
 
public class CustomerIT {
	
	@Inject ManagerEJB ejb;
	
	@Deployment
	    public static Archive<?> createTestArchive() {
	        return ShrinkWrap.create(WebArchive.class, "testjpa.war")
	                .addPackage(Customer.class.getPackage())
	                .addPackage(ManagerEJB.class.getPackage())
	                .addAsResource("META-INF/persistence.xml")
	                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	              
	               
	    }

	@Test
	public void test() {	 
		try {
			
			ejb.createCustomer("john","park avenue 125", "jsmith@gmail.com", "+3955555");
			Customer customer = ejb.findCustomerByName("john");
			List<Customer> cc = ejb.findAllCustomers();
			System.out.println(cc);
			assertNotNull(customer);
			ejb.createRequest("john",100);

			List<Customer> customerList = ejb.findAllCustomers();

			log("=======> Customer List ");
			for (Customer c : customerList) {
				log("Customer found: "+c);
				log("============> Request Accociated:");	
				List<Request> requestList= ejb.findAllRequestsByCustomer(c.getName());
				for (Request r : requestList) {
					log("Request found: "+r);
				}
			}

		} catch (Exception e) {
			System.out.println(e.getClass());
			// TODO Auto-generated catch block
			e.getMessage();
		}  
	}

	private void log(String string) {
		System.out.println(string);
		
	}
	 
}
