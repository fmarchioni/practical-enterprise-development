package com.itbuzzpress.jaxrs.test;


import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.nio.charset.StandardCharsets;
import static org.junit.Assert.assertNotNull;

public class TestClient {
	String BASE_URL ="http://localhost:8080/ee-rest-interceptors/rest";

	@Test
	public void testParam()  throws IOException {

 Client client = ClientBuilder.newClient();
		WebTarget myResource = client.target(BASE_URL).path("/simple");

		Response rs = myResource.request(MediaType.TEXT_PLAIN)
				.post(Entity.text("Hello"), Response.class);

		String response = client.target(BASE_URL).path("/simple")
				.request(MediaType.TEXT_PLAIN)
				.get(String.class);

    assertNotNull(response);
		System.out.println(response);

	}



}
