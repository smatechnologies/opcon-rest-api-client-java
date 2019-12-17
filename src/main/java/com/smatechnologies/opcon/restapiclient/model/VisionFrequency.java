package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;


/**
 * @author Matthieu COELHO
 */
public class VisionFrequency {

    public static final Integer ALL_DAYS_ID = 1;

    public static final String RESOURCE = "visionFrequency";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_TYPE = "type";
    public static final String PROPERTY_DATES = "dates";

    private Integer id;
    private String name;
    private String description;
    private Type type;
    private Set<LocalDate> dates;

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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Set<LocalDate> getDates() {
        return dates;
    }

    public void setDates(Set<LocalDate> dates) {
        this.dates = dates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof VisionFrequency))
            return false;
        VisionFrequency that = (VisionFrequency) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                getType() == that.getType() &&
                Objects.equals(getDates(), that.getDates());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getName(), getDescription(), getType(), getDates());
    }

    public enum Type {
        INCLUDE_DATES(0),
        EXCLUDE_DATES(1);

        private int value;

        Type(int value) {
            this.value = value;
        }

        @JsonValue
        public Integer getValue() {
            return value;
        }

        @JsonCreator
        public static Type fromValue(int value) {
            if (value == 0) {
                return INCLUDE_DATES;
            } else if (value == 1) {
                return EXCLUDE_DATES;
            }
            return null;
        }
    }
}
