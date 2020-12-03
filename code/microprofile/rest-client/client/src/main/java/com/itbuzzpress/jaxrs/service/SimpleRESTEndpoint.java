package com.itbuzzpress.jaxrs.service;



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

import com.itbuzzpress.jaxrs.model.SimpleProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import javax.enterprise.context.ApplicationScoped;

//Example URL: http://localhost:8080/rest/simple/text

@Path("/proxy")
@ApplicationScoped
public class SimpleRESTEndpoint {

    @Inject
    @RestClient
    SimpleRESTServiceItf service;

    @GET
    @Path("/text")
    public String getHello() {
        return service.getHello();
    }

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public SimpleProperty getPropertyJSON(){
        return service.getPropertyJSON();
    }

    @GET
    @Path("/xml")
    @Produces(MediaType.APPLICATION_XML)
    public SimpleProperty getPropertyXML() {
        return service.getPropertyXML();
    }

}
