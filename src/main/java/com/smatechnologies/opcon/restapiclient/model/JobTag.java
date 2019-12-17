package com.smatechnologies.opcon.restapiclient.model;

/**
 * @author Pierre PINON
 */
public class JobTag {

    public static final String RESOURCE = "jobTag";

    public static final String PROPERTY_NAME = "name";

    private String name;

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

        JobTag jobTag = (JobTag) o;

        return name != null ? name.equals(jobTag.name) : jobTag.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
