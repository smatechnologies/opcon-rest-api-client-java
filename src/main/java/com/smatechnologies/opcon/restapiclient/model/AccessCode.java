package com.smatechnologies.opcon.restapiclient.model;

/**
 * Resource describing an Access Code in OpCon.
 *
 * @author Francois EYL
 */
public class AccessCode {

    public static final String RESOURCE = "accessCode";

    public static final String PROPERTY_ID = "id";
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

        AccessCode that = (AccessCode) o;

        if (id != null ? !id.equals(that.id) : that.id != null)
            return false;
        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
