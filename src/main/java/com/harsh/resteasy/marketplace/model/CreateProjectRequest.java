package com.harsh.resteasy.marketplace.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.harsh.resteasy.marketplace.Utils;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateProjectRequest {

    private static final String DESCRIPTION = "description";
    private static final String MAX_BUDGET = "maxBudget";

    private String description;
    private double maxBudget;

    @JsonProperty
    private int sellerId;

    @JsonProperty
    private Map<String, Object> project;

    public String getDescription() {
        if (!project.containsKey(DESCRIPTION)) {
            return null;
        }

        return project.get(DESCRIPTION).toString();
    }

    public double getMaxBudget() {
        if (!project.containsKey(MAX_BUDGET)) {
            return 0;
        }

        return Double.valueOf(project.get(MAX_BUDGET).toString());
    }

    public int getSellerId() {
        return sellerId;
    }

    public boolean isValid() {
        return !Utils.isEmpty(getDescription())
                && getMaxBudget() != 0
                && sellerId != 0;
    }
}
