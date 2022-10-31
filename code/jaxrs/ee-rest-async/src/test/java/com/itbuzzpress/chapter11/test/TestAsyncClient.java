package com.itbuzzpress.jaxrs.test;

import com.itbuzzpress.jaxrs.model.SimpleProperty;
import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.MediaType;
import org.junit.Test;

import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;

public class TestAsyncClient {
	String BASE_URL = "http://localhost:8080/ee-rest-async/rest";

	@Test
	public void testClientAsync() throws Exception {

		Client client = ClientBuilder.newClient();
		SimpleProperty propertyIn = new SimpleProperty("secretkey", "value");

		WebTarget myResource = client.target(BASE_URL + "/service");
		Future<SimpleProperty> ret = myResource
				.request(MediaType.APPLICATION_JSON).async()
				.post(Entity.json(propertyIn), SimpleProperty.class);

		
		SimpleProperty property = ret.get();
		assertEquals("value", property.getValue());

		// Wait for Future
		Future<SimpleProperty> future = client
				.target(BASE_URL + "/service/{key}")
				.resolveTemplate("key", "secretkey")
				.request(MediaType.APPLICATION_JSON).async()
				.get(SimpleProperty.class);

		SimpleProperty propertyOut = null;
		try {
			while (!future.isDone()) {
				Thread.sleep(100);
			}
			propertyOut = future.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("value", propertyOut.getValue());
		
		// Alternative approach using InvocationCallback
		client.target(BASE_URL + "/service/{key}")
		.resolveTemplate("key", "secretkey")
		.request(MediaType.APPLICATION_JSON)
				.async()
				.get(new InvocationCallback<SimpleProperty>() {
					@Override
					public void completed(SimpleProperty p) {
						System.out.println("Got a "+p);
					}
					@Override
					public void failed(Throwable t) {
						//. . .
					}
				});

	}

}
