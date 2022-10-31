package com.itbuzzpress.jaxrs.test;

import com.itbuzzpress.jaxrs.model.SimpleProperty;
import com.itbuzzpress.jaxrs.test.filter.ClientFilter;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestClient {
String BASE_URL ="http://localhost:8080/ee-rest-filters/rest";
 
	@Test
	public void testParam() {
		Client client = ClientBuilder.newClient();
		client.register(new ClientFilter("user","password"));
		SimpleProperty p1 = new SimpleProperty("mykey","value");

		WebTarget myResource = client.target(BASE_URL).path("/service");
		Response rs = myResource.request(MediaType.APPLICATION_JSON)
						.post(Entity.json(p1), Response.class);

		assertEquals(rs.getStatus(),200);

		SimpleProperty property =
				client.target(BASE_URL).path("/service/{key}")
				        .resolveTemplate("key", "0")
						.request(MediaType.APPLICATION_JSON)
						.get(SimpleProperty.class);
		assertNotNull(property);

        List<SimpleProperty> result = client.target(BASE_URL).path("/service")
            .request(MediaType.APPLICATION_JSON).get(new GenericType<List<SimpleProperty>>() {
            });

		assertEquals("mykey",result.get(0).getKey());
		assertEquals("value",result.get(0).getValue());

	}
}
