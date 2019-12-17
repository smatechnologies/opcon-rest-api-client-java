package com.smatechnologies.opcon.restapiclient.model;

import com.smatechnologies.opcon.restapiclient.model.script.ScriptType;

import java.util.List;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class Script {

    public static final String RESOURCE = "script";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_TYPE = "type";
    public static final String PROPERTY_VERSIONS = "versions";

    private Integer id;
    private String name;
    private String description;
    private ScriptType type;
    private List<ScriptVersion> versions;

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

    public ScriptType getType() {
        return type;
    }

    public void setType(ScriptType type) {
        this.type = type;
    }

    public List<ScriptVersion> getVersions() {
        return versions;
    }

    public void setVersions(List<ScriptVersion> versions) {
        this.versions = versions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Script script = (Script) o;
        return Objects.equals(id, script.id) &&
                Objects.equals(name, script.name) &&
                Objects.equals(description, script.description) &&
                Objects.equals(type, script.type) &&
                Objects.equals(versions, script.versions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, type, versions);
    }

}
