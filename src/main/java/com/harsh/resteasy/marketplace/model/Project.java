package com.harsh.resteasy.marketplace.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.concurrent.atomic.AtomicInteger;

@JsonRootName(value = "project")
public class Project {
    private static AtomicInteger count = new AtomicInteger(0);

    @JsonProperty
    private final int id;

    @JsonProperty
    private final String description;

    @JsonProperty
    private final double maxBudget;

    @JsonProperty
    private final int sellerId;

    public Project(final CreateProjectRequest createProjectRequest) throws IllegalArgumentException {
        if (!createProjectRequest.isValid()) {
            throw new IllegalArgumentException();
        }

        this.sellerId =  createProjectRequest.getSellerId();
        this.description = createProjectRequest.getDescription();
        this.maxBudget = createProjectRequest.getMaxBudget();
        this.id = count.incrementAndGet();
    }
}
