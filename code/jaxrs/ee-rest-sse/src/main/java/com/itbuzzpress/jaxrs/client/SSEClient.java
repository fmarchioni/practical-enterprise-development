package com.itbuzzpress.jaxrs.client;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import jakarta.ejb.*;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.sse.SseEventSource;

import java.util.ArrayList;

@Singleton
@Startup
public class SSEClient {
	Client sseClient;
	WebTarget target;
	SseEventSource eventSource;
	@Resource 
	TimerService timerService;

	public ArrayList<String> listUsers;

	@PostConstruct
	public void init() {

		this.sseClient = ClientBuilder.newClient();
		this.target = this.sseClient.target("http://localhost:8080/ee-rest-sse/rest/events");

		timerService.createSingleActionTimer(5000, new TimerConfig());
		System.out.println("SSE client timer created");

		// Server side event source 
		eventSource = SseEventSource.target(target).build();
		System.out.println("SSE Event source created........");

	}

	public void addUser(String username) {
		listUsers.add(username);
	}

	public void removeUser(String username) {
		listUsers.remove(username);
	}

	public ArrayList<String> getListUsers() {
		return listUsers;
	}

	@Timeout
	public void client() {

		try {
			eventSource.register((sseEvent) -> {
				System.out.println("SSE event received ----- " + sseEvent.readData());
			}, (e) -> e.printStackTrace());

			eventSource.open();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@PreDestroy
	public void close() {
		eventSource.close();
		System.out.println("Closed SSE Event source..");
		sseClient.close();
		System.out.println("Closed JAX-RS client..");
	}

}