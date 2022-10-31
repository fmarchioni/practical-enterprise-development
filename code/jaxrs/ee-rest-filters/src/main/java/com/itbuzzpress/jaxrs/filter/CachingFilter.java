package com.itbuzzpress.jaxrs.filter;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;

@Provider
public class CachingFilter implements  ContainerResponseFilter {
    
    @Override
    public void filter(ContainerRequestContext crc, ContainerResponseContext crc1) throws IOException {
    	 System.out.println("[Caching filter] Running");
    	if (crc.getMethod().equals("GET")) {    		 
    		crc.getHeaders().add("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0, post-check=0, pre-check=0");
    		crc.getHeaders().add("Expires", "-1"); 
    		}
    }
	 
}
