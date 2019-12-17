package com.smatechnologies.opcon.restapiclient.model.dailyjob.details.commons;

import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class EnvironmentVariable {

    public static final int NAME_VALUE_MAX_LENGTH = 4000;
    public static final String KEY_INVALID_CHARS = "=";

    public static final String RESOURCE = "environmentVariable";

    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_VALUE = "value";

    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        EnvironmentVariable that = (EnvironmentVariable) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }
}
