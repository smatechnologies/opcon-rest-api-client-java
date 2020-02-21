package com.smatechnologies.opcon.restapiclient.model;

public class GlobalProperty {

    public static final String RESOURCE = "globalproperties";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_ENCRYPTED = "encrypted";

    private Integer id;
    private String name;
    private String value;
    private String description;
    private Boolean encrypted;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getEncrypted() {
        return encrypted;
    }

    public void setEncrypted(Boolean encrypted) {
        this.encrypted = encrypted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof GlobalProperty))
            return false;

        GlobalProperty that = (GlobalProperty) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null)
            return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null)
            return false;
        if (getValue() != null ? !getValue().equals(that.getValue()) : that.getValue() != null)
            return false;
  	    if (getEncrypted() != null ? !getEncrypted().equals(that.getEncrypted()) : that.getEncrypted() != null)
            return false;
        return getDescription() != null ? getDescription().equals(that.getDescription()) : that.getDescription() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
        result = 31 * result + (getEncrypted() != null ? getEncrypted().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        return result;
    }
}

