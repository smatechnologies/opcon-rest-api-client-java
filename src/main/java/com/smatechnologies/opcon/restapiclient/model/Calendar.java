package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;


/**
 * @author Matthieu COELHO
 */
public class Calendar {

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_SCHEDULE = "schedule";
    public static final String PROPERTY_TYPE = "type";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DATES = "dates";
    public static final String PROPERTY_DESCRIPTION = "description";

    private Integer id;
    private MasterSchedule schedule;
    private Type type;
    private String name;
    //TODO replace String to LocalDate when API will be ready
    private List<String> dates;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MasterSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(MasterSchedule schedule) {
        this.schedule = schedule;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDates() {
        return dates;
    }

    public void setDates(List<String> dates) {
        this.dates = dates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Calendar))
            return false;

        Calendar calendar = (Calendar) o;

        if (getId() != null ? !getId().equals(calendar.getId()) : calendar.getId() != null)
            return false;
        if (getSchedule() != null ? !getSchedule().equals(calendar.getSchedule()) : calendar.getSchedule() != null)
            return false;
        if (getType() != calendar.getType())
            return false;
        if (getName() != null ? !getName().equals(calendar.getName()) : calendar.getName() != null)
            return false;
        if (getDates() != null ? !getDates().equals(calendar.getDates()) : calendar.getDates() != null)
            return false;
        return getDescription() != null ? getDescription().equals(calendar.getDescription()) : calendar.getDescription() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getSchedule() != null ? getSchedule().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDates() != null ? getDates().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        return result;
    }

    public enum Type {
        HOLIDAY(0),
        USER_CALENDAR(1);

        private Integer value;

        Type(int value) {
            this.value = value;
        }

        @JsonValue
        public Integer getValue() {
            return value;
        }
    }
}
