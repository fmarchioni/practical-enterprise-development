package com.itbuzzpress.jaxrs.service;


import com.itbuzzpress.jaxrs.ejb.DataList;
import com.itbuzzpress.jaxrs.handler.MyTimeoutHandler;
import com.itbuzzpress.jaxrs.model.SimpleProperty;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.container.AsyncResponse;
import jakarta.ws.rs.container.Suspended;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

 

@Path("/service")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ParamRESTService {
	 
    
	@Inject DataList ejb;

	@GET
	@Path("/stage/{key}")
	public CompletionStage<SimpleProperty> getAsync(final @PathParam("key") String key)  {

		CompletionStage<SimpleProperty> cs = CompletableFuture
				.<SimpleProperty>supplyAsync(
						() -> {

							System.out.println(" execute long run task in CompletionStageResource");
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							return ejb.get(key);


						}
						// , executor
				);

		return cs;
	}


		@GET 
		@Path("/{key}")
		public void asyncGet(final @Suspended AsyncResponse asyncResp,final @PathParam("key") String key) {
		 
			asyncResp.setTimeout(10,  TimeUnit.SECONDS);
			asyncResp.setTimeoutHandler(new MyTimeoutHandler());

			new Thread(new Runnable() { 
				public void run() { 
					SimpleProperty p = ejb.get(key);
					System.out.println("key is "+key);
					asyncResp.resume(p);
				}
			}).start();
		}

	@POST
	public Response  asyncPost(final @Suspended AsyncResponse asyncResp,SimpleProperty p) {
		asyncResp.setTimeout(10,  TimeUnit.SECONDS);
		asyncResp.setTimeoutHandler(new MyTimeoutHandler());

		new Thread(new Runnable() {
			public void run() {
				int n = ejb.addToList(p);
				asyncResp.resume(p);
			}
		}).start();


		return Response.ok(p).build();
		 
	}

}
