package com.itbuzzpress.microprofile.service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.itbuzzpress.microprofile.model.SimpleProperty;
import org.eclipse.microprofile.metrics.annotation.*;
import org.eclipse.microprofile.metrics.MetricUnits;

import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.Metadata;
import org.eclipse.microprofile.metrics.MetricRegistry;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.ConcurrentGauge;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.Metric;
import org.eclipse.microprofile.metrics.annotation.RegistryType;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.CountDownLatch;

@Path("/")
public class SimpleRESTService {


	@GET
	@Path("/time")
	@Gauge(unit = "time", absolute = true)
	public Long checkTime() {
		return  System.currentTimeMillis();
	}

	@GET
	@Path("/hello")
    @Counted(description = "How many greetings", absolute = true)
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
