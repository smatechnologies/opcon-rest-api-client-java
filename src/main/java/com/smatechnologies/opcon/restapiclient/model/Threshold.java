package com.smatechnologies.opcon.restapiclient.model;

import com.smatechnologies.opcon.restapiclient.model.dailyjob.DailyJob;

import java.util.List;
import java.util.Objects;


/**
 * @author Matthieu COELHO
 */
public class Threshold {

    public static final String RESOURCE = "threshold";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_DEPENDENT_DAILY_JOBS = "dependentDailyJobs";
    public static final String PROPERTY_UPDATED_BY_DAILY_JOBS = "updatedByDailyJobs";
    private Integer id;
    private String name;
    private Integer value;
    private String description;
    private List<DailyJob> dependentDailyJobs;
    private List<DailyJob> updatedByDailyJobs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DailyJob> getDependentDailyJobs() {
        return dependentDailyJobs;
    }

    public void setDependentDailyJobs(List<DailyJob> dependentDailyJobs) {
        this.dependentDailyJobs = dependentDailyJobs;
    }

    public List<DailyJob> getUpdatedByDailyJobs() {
        return updatedByDailyJobs;
    }

    public void setUpdatedByDailyJobs(List<DailyJob> updatedByDailyJobs) {
        this.updatedByDailyJobs = updatedByDailyJobs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Threshold))
            return false;
        Threshold threshold = (Threshold) o;
        return Objects.equals(getId(), threshold.getId()) &&
                Objects.equals(getName(), threshold.getName()) &&
                Objects.equals(getValue(), threshold.getValue()) &&
                Objects.equals(getDescription(), threshold.getDescription()) &&
                Objects.equals(getDependentDailyJobs(), threshold.getDependentDailyJobs()) &&
                Objects.equals(getUpdatedByDailyJobs(), threshold.getUpdatedByDailyJobs());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getValue(), getDescription(), getDependentDailyJobs(), getUpdatedByDailyJobs());
    }

}
