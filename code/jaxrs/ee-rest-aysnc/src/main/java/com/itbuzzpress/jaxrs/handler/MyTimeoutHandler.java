package com.itbuzzpress.jaxrs.handler;

import java.net.HttpURLConnection;

import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.TimeoutHandler;
import javax.ws.rs.core.Response;

import com.itbuzzpress.jaxrs.model.SimpleProperty;

public class MyTimeoutHandler implements TimeoutHandler {

	@Override
	public void handleTimeout(AsyncResponse asyncResp) {
		Response r = Response.serverError().status( HttpURLConnection.HTTP_UNAVAILABLE).build( );
		asyncResp.resume( r );
		   
	}

}
