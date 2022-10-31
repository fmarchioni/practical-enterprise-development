package com.itbuzzpress.jaxrs.test.filter;

import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;
import jakarta.ws.rs.client.ClientResponseContext;
import jakarta.ws.rs.client.ClientResponseFilter;
import org.apache.commons.codec.binary.Base64;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
 
public class ClientFilter implements ClientRequestFilter,ClientResponseFilter {
	private final String username;
	private final String password;

	public ClientFilter(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public void filter(ClientRequestContext req) {
		String token = username + ":" + password;

		String base64Token = new String
	    		(Base64.encodeBase64(token.getBytes(StandardCharsets.UTF_8)));
	    req.getHeaders().add("Authorization", "Basic " + base64Token);
	    
	    System.out.println("Added to HTTP Request Authorization ["+base64Token+"]");
		 

	}

	@Override
	public void filter(ClientRequestContext arg0, ClientResponseContext crc1)
			throws IOException {

		for (String key : crc1.getHeaders().keySet()) {
			System.out.println("Response Header: " +crc1.getHeaders().get(key));
		}

	}

}