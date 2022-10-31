package com.itbuzzpress.jaxrs.filter;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;

@Provider 
public class LoggingFilter implements ContainerRequestFilter  {

    public void filter(ContainerRequestContext crc) throws IOException {
        
        System.out.println(crc.getMethod() + " " + crc.getUriInfo().getAbsolutePath());
        for (String key : crc.getHeaders().keySet()) {
            System.out.println("[Logging Filter] " +key + ": " + crc.getHeaders().get(key));
        }   
    }	 
}