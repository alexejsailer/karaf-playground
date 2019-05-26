package com.dualexec.osgi.blueprint.rest.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/sample")
@Produces(MediaType.APPLICATION_JSON)
public class SampleResource {

	@GET
	public ResourceState currentValue() {
		return new ResourceState(1);
	}

	@POST
	public ResourceState increment() {
		return new ResourceState(2);
	}

}
