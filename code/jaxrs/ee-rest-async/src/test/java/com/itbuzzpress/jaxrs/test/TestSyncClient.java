package com.itbuzzpress.jaxrs.test;

import com.itbuzzpress.jaxrs.model.SimpleProperty;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import org.junit.Test;

import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;

public class TestSyncClient {
String BASE_URL ="http://localhost:8080/rest";

	 
@Test	
public void testClientAsync() throws Exception {

   Client client = ClientBuilder.newClient();
   SimpleProperty propertyIn = new SimpleProperty("mykey","value");
 
   WebTarget myResource = client.target(BASE_URL+"/service");
   Future<SimpleProperty> ret =  myResource.request(MediaType.APPLICATION_JSON).async()
				.post(Entity.json(propertyIn), SimpleProperty.class);			   
   SimpleProperty property = ret.get();
   assertEquals("value", property.getValue());
   
   Future<SimpleProperty> future = client
			.target(BASE_URL + "/service/{key}")
			.resolveTemplate("key", "mykey")
			.request(MediaType.APPLICATION_JSON).async()
			.get(SimpleProperty.class);

	SimpleProperty propertyOut = null;
		try {
			while (!future.isDone()) {
				Thread.sleep(100);
			}
			propertyOut = future.get();
		} catch (Exception e) {
				e.printStackTrace();
		}
	assertEquals("value", propertyOut.getValue());

}


}
