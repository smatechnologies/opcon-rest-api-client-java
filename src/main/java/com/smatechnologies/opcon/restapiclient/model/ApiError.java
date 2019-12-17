package com.smatechnologies.opcon.restapiclient.model;

/**
 * @author Pierre PINON
 */
public class ApiError {

    public static final String RESOURCE = "apiError";

    public static final String PROPERTY_RESOURCE = "resource";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_CODE = "code";
    public static final String PROPERTY_MESSAGE = "message";

    private String resource;
    private String name;
    private Integer code;
    private String message;

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ApiError apiError = (ApiError) o;

        if (resource != null ? !resource.equals(apiError.resource) : apiError.resource != null)
            return false;
        if (name != null ? !name.equals(apiError.name) : apiError.name != null)
            return false;
        if (code != null ? !code.equals(apiError.code) : apiError.code != null)
            return false;
        return message != null ? message.equals(apiError.message) : apiError.message == null;

    }

    @Override
    public int hashCode() {
        int result = resource != null ? resource.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }
}
