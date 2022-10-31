package com.itbuzzpress.json.service;

import com.itbuzzpress.json.model.Person;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/jsonb")
public class JsonService {

	@POST
	@Path("/tojava")
	public Response createJava(@FormParam("json") String json) {
		Response response;

		Jsonb jsonb = JsonbBuilder.create();

		Person p = jsonb.fromJson(json, Person.class);
		System.out.println("Created Person " + p);
		response = Response.ok(p.toString()).build();

		return response;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/tojson")
	public Response createJson(@FormParam("name") String name, @FormParam("surname") String surname,
			@FormParam("address") String address, @FormParam("city") String city) {
		Response response;
		Person p = new Person(name, surname, address, city);

		Jsonb jsonb = JsonbBuilder.create();
		String jsonString = jsonb.toJson(p);
		response = Response.ok(jsonString).build();

		return response;
	}
}
