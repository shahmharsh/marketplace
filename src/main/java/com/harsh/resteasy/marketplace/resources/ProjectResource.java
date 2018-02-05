package com.harsh.resteasy.marketplace.resources;

import com.harsh.resteasy.marketplace.model.Project;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/project")
@Produces(MediaType.TEXT_PLAIN)
public class ProjectResource {

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response printMessage(Project project) {
        return Response.status(200)
                .entity(project)
                .build();
    }

}
