package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.OffsetTime;
import java.util.Map;
import java.util.Objects;


/**
 * @author Matthieu COELHO
 */
public class Sla {

    public static final String RESOURCE = "sla";

    public static final String PROPERTY_REQUIREMENT = "requirement";
    public static final String PROPERTY_TIME = "time";
    public static final String PROPERTY_OFFSET = "offset";

    private Requirement requirement;
    private OffsetTime time;
    private int offset;

    public Requirement getRequirement() {
        return requirement;
    }

    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }

    public OffsetTime getTime() {
        return time;
    }

    public void setTime(OffsetTime time) {
        this.time = time;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Sla))
            return false;
        Sla sla = (Sla) o;
        return getOffset() == sla.getOffset() &&
                getRequirement() == sla.getRequirement() &&
                Objects.equals(getTime(), sla.getTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRequirement(), getTime(), getOffset());
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    public enum Requirement {
        EXPECTED_START_TIME(1000, "Expected Start Time"),
        EXPECTED_END_TIME(1001, "Expected End Time");

        private final int id;
        @JsonIgnore
        private final String name;

        Requirement(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @JsonCreator
        public static Requirement fromObject(final Map<String, Object> obj) {
            if (obj != null && obj.containsKey("id")) {
                Integer id = null;
                if (obj.get("id") instanceof Integer) {
                    id = (Integer) obj.get("id");
                } else {
                    id = Integer.parseInt((String) obj.get("id"));
                }
                if (id != null) {
                    for (Requirement e : Requirement.values()) {
                        if (id.equals(e.getId()))
                            return e;
                    }
                }
                return null;
            }
            return null;
        }
    }

}
