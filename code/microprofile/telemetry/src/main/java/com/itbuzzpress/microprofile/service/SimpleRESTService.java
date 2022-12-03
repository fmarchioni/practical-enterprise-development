
package com.itbuzzpress.microprofile.service;

import jakarta.enterprise.context.ApplicationScoped;

import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;

import java.util.UUID;

import com.itbuzzpress.microprofile.model.SimpleProperty;
 
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.instrumentation.annotations.WithSpan;

@Path("/simple")
@ApplicationScoped
public class SimpleRESTService {

    @Inject
    private Tracer tracer;

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public SimpleProperty getPropertyJSON (@Context HttpServletRequest request)
    {
        final Span span = tracer.spanBuilder("Preparing JSON").setAttribute("SESSION", request.getSession().getId())
                .startSpan();
        span.makeCurrent();

        SimpleProperty p = new SimpleProperty(UUID.randomUUID().toString(),
                UUID.randomUUID().toString());

        span.addEvent("Built Property");
        span.end();

        return p;
    }
    @GET
    @Path("/xml")
    @Produces(MediaType.APPLICATION_XML)
    public SimpleProperty getPropertyXML ()
    {
        final Span span = tracer.spanBuilder("Preparing XML").startSpan();
        span.makeCurrent();

        SimpleProperty p = new SimpleProperty(UUID.randomUUID().toString(),
        		                              UUID.randomUUID().toString());

        span.addEvent("Built Property");
        span.end();

        return p;
    }

}
