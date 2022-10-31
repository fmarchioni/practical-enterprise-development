
package com.itbuzzpress.microprofile.service;

import org.eclipse.microprofile.opentracing.Traced;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import com.itbuzzpress.microprofile.model.SimpleProperty;

@Path("/simple")
@ApplicationScoped
public class SimpleRESTService {

    @GET
    @Traced(operationName = "getText")
    @Path("/text")
    public String getHello ()
    {
        return "hello world!";
    }

    @GET
    @Traced(operationName = "getJSON")
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public SimpleProperty getPropertyJSON ()
    {
        SimpleProperty p = new SimpleProperty("key","value");
        return p;
    }
    @GET
    @Path("/xml")
    @Traced(operationName = "getXML")
    @Produces(MediaType.APPLICATION_XML)
    public SimpleProperty getPropertyXML ()
    {
        SimpleProperty p = new SimpleProperty("key","value");
        return p;
    }

}
