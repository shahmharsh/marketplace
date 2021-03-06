package com.harsh.resteasy.marketplace;

import com.harsh.resteasy.marketplace.managers.ProjectManager;
import com.harsh.resteasy.marketplace.resources.ProjectResource;

import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RestApplication extends Application {
    private final Set<Object> singletons;

    public RestApplication () {
        final ProjectManager projectManager = new ProjectManager();
        final ProjectResource messageResource = new ProjectResource(projectManager);
        singletons = Collections.unmodifiableSet(Stream.of(
                messageResource
        ).collect(Collectors.toSet()));
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
