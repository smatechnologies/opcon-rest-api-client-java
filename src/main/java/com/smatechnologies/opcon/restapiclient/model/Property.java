package com.smatechnologies.opcon.restapiclient.model;

import java.util.regex.Pattern;


public class Property {

    public static final String KEY_INVALID_CHARS = "'()\\,=;|";
    public static final String VALUE_INVALID_CHARS = ";";

    public static final String KEY_VALID_REGEX = "(?!^\\s)[^" + Pattern.quote(KEY_INVALID_CHARS) + "]+(?<! )";
    public static final String VALUE_VALID_REGEX = "((?!" + Pattern.quote(VALUE_INVALID_CHARS) + ").)*";

    public static final String RESOURCE = "property";

    public static final String PROPERTY_KEY = "key";
    public static final String PROPERTY_VALUE = "value";

    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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

        Property property = (Property) o;

        if (key != null ? !key.equals(property.key) : property.key != null)
            return false;
        return value != null ? value.equals(property.value) : property.value == null;
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
