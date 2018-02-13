package com.harsh.resteasy.marketplace.managers;

import com.harsh.resteasy.marketplace.model.CreateProjectRequest;
import com.harsh.resteasy.marketplace.model.Project;

public class ProjectManager {
    public Project create(CreateProjectRequest createProjectRequest) throws IllegalArgumentException {
        return new Project(createProjectRequest);
    }
}
