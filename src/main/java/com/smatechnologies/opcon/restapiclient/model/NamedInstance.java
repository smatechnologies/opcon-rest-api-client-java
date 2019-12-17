package com.smatechnologies.opcon.restapiclient.model;

import java.util.Objects;


public class NamedInstance {

    public static final String RESOURCE = "namedInstance";

    public static final String PROPERTY_TYPE = "id";
    public static final String PROPERTY_NAME = "name";

    private Integer id;
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        NamedInstance that = (NamedInstance) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
