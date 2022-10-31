package com.sample.jwt;


import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.util.Set;

@Path("jwt")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
@DenyAll
public class SampleEndpoint {


    @Inject
    JsonWebToken jwt;

    @Inject
    @Claim(standard = Claims.groups)
    private Set<String> groups;

    @Inject
    @Claim(standard = Claims.sub)
    private String subject;


    @GET
    @Path("goadmin")
    @RolesAllowed("admin")
    public String adminMethod() {
        return "You are logged with " +this.subject + ": " + this.groups.toString();

    }
    
    @GET
    @Path("gouser")
    @RolesAllowed("user")
    public String userMethod() {
        return "You are logged with " +this.subject + ": " + this.groups.toString();

    }



}
