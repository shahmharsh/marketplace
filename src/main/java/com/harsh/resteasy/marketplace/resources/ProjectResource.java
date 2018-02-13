package com.harsh.resteasy.marketplace.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.harsh.resteasy.marketplace.managers.ProjectManager;
import com.harsh.resteasy.marketplace.model.CreateProjectRequest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/project")
@Produces(MediaType.TEXT_PLAIN)
public class ProjectResource {

    private final ProjectManager projectManager;
    private static final ObjectMapper mapper = new ObjectMapper()
            .enable(SerializationFeature.WRAP_ROOT_VALUE);

    public ProjectResource(final ProjectManager projectManager) {
        this.projectManager = projectManager;
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProject(final CreateProjectRequest createProjectRequest) {
        try {
            return Response.status(200)
                    .entity(mapper.writeValueAsString(projectManager.create(createProjectRequest)))
                    .build();
        } catch (IllegalArgumentException ex) {
            return Response.status(400).build();
        } catch (JsonProcessingException e) {
            return Response.status(500).build();
        }
    }
}
