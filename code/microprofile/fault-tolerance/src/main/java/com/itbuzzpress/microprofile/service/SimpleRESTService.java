package com.mastertheboss.microprofile.service;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import com.itbuzzpress.microprofile.model.SimpleProperty;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.exceptions.TimeoutException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Random;
import java.util.UUID;

@Path("/")
public class SimpleRESTService {
	@GET
	@Path("/text")
	@Timeout(250)
	@Retry(retryOn = TimeoutException.class,
			maxRetries = 3)
	public String getHello ()
	{
		randomSleep();
		return "hello world!";
	}

	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	@Timeout(250)
	@Fallback(fallbackMethod = "fallbackJSON")
	public SimpleProperty getPropertyJSON ()
	{
		SimpleProperty p = new SimpleProperty("key","value");
		randomSleep();
		return p;
	}


	public SimpleProperty fallbackJSON()
	{
		SimpleProperty p = new SimpleProperty("key","fallback");
		return p;
	}

	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	@CircuitBreaker(successThreshold = 5, requestVolumeThreshold = 4, failureRatio=0.75, delay = 1000)
	public SimpleProperty getPropertyXML ()
	{
		SimpleProperty p = buildPOJO();

		return p;
	}

	private void randomSleep() {
		try {
			long sleep = new Random().nextInt(500);
			System.out.println("I will sleep for  "+sleep);
			Thread.sleep(sleep);

		}
		catch (Exception exc) {
			exc.printStackTrace();
		}

	}

	private SimpleProperty buildPOJO() {
		if (new Random().nextFloat() < 0.5f) {
			System.out.println("Error!!!");
			throw new RuntimeException("System unavailable. Try a bit later.");
		}
		SimpleProperty p = new SimpleProperty("key","value");
		return p;
	}

}
