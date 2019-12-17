package com.smatechnologies.opcon.restapiclient.model.script;

import java.time.ZonedDateTime;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class ScriptType {

    public static final String RESOURCE = "script";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_EXTENSION = "extension";
    public static final String PROPERTY_CREATED_DATE = "createdDate";
    public static final String PROPERTY_LAST_UPDATED = "lastUpdated";

    private Integer id;
    private String name;
    private String description;
    private String extension;
    private ZonedDateTime createdDate;
    private ZonedDateTime lastUpdated;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public ZonedDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(ZonedDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ScriptType that = (ScriptType) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(extension, that.extension) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(lastUpdated, that.lastUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, extension, createdDate, lastUpdated);
    }
}
