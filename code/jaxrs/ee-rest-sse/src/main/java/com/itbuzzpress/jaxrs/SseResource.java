package com.itbuzzpress.jaxrs;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.sse.OutboundSseEvent;
import jakarta.ws.rs.sse.Sse;
import jakarta.ws.rs.sse.SseEventSink;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
//import jakarta.enterprise.concurrent.ManagedExecutorService;
//import jakarta.enterprise.concurrent.ManagedScheduledExecutorService;
//import jakarta.enterprise.concurrent.ManagedThreadFactory;

@Path("/events")
public class SseResource {

 
	Executor executorService = Executors.newSingleThreadExecutor();

	// @Resource(name = "DefaultManagedExecutorService")
	// ManagedExecutorService executorService;

 

	@GET
	@Produces(MediaType.SERVER_SENT_EVENTS)
	public void sendEvents(@Context SseEventSink sseEventSink, @Context Sse sse) {
		Random rnd = new Random();
		IntStream rndStream = IntStream.generate(() -> rnd.nextInt(90));
		List<Integer> lottery = rndStream.limit(5).boxed().collect(Collectors.toList());

		executorService.execute(() -> {
			lottery.forEach(value -> {
				try {
					TimeUnit.SECONDS.sleep(5);
					System.out.println("Sending the following value: " + value);
					final OutboundSseEvent outboundSseEvent = sse.newEventBuilder().name("lottery")
							.data(Integer.class, value).build();
					sseEventSink.send(outboundSseEvent);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}

			});
			sseEventSink.close();
		});

	}
 
}
