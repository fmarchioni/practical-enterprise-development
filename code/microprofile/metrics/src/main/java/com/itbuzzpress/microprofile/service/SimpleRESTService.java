package com.itbuzzpress.microprofile.service;

import com.itbuzzpress.microprofile.model.SimpleProperty;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.Timed;

@Path("/simple")
public class SimpleRESTService {

	@GET
	@Path("/time")
	@Gauge(unit = "time", absolute = true, name="checkTime")
	public Long checkTime() {
		return  System.currentTimeMillis();
	}

	@GET
	@Path("/hello")
    @Counted(description = "How many greetings", absolute = true, name="countHello")
	public String countHello ()
	{
		return "hello world!";
	}

	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	@Metered(name = "getJSON", unit = MetricUnits.MINUTES, description = "Metrics to monitor frequency of getPropertyJSON.", absolute = true)
	public SimpleProperty getPropertyJSON () 
	{
        SimpleProperty p = new SimpleProperty("key","value");
		return p;
	}
	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	@Timed(name = "getXML", absolute = true)
	public SimpleProperty getPropertyXML () 
	{
        SimpleProperty p = new SimpleProperty("key","value");
        try {  
          Thread.sleep((long)(Math.random() * 1000));
        }
        catch (Exception exc) {
          exc.printStackTrace();
        }	
		return p;
	}
}
