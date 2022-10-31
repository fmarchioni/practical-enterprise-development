package com.itbuzzpress.jaxrs.service;


import com.itbuzzpress.jaxrs.model.SimpleProperty;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;


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
