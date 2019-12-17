package com.smatechnologies.opcon.restapiclient.model.dailyvisioncard;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class DailyVisionCardSla {

    public static final String RESOURCE = "sla";

    public static final String PROPERTY_REQUIREMENT = "requirement";
    public static final String PROPERTY_DATE_TIME = "dateTime";

    private Requirement requirement;
    private ZonedDateTime dateTime;

    public Requirement getRequirement() {
        return requirement;
    }

    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(ZonedDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DailyVisionCardSla that = (DailyVisionCardSla) o;
        return requirement == that.requirement &&
                Objects.equals(dateTime, that.dateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(requirement, dateTime);
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    public enum Requirement {
        FREQUENCY_DAY_NOT_FOUND(2, "Frequency Day not Found"),
        LATE_TO_START(1000, "Late To Start"),
        LATE_TO_FINISH(1001, "Late To Finish"),
        ESTIMATED_LATE_TO_START(1002, "Estimated Late To Start"),
        ESTIMATED_LATE_TO_FINISH(1003, "Estimated Late To Finish");

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

        public boolean isLate() {
            return isLateToStart() || isLateToFinish();
        }

        public boolean isLateToStart() {
            return this == LATE_TO_START || this == ESTIMATED_LATE_TO_START;
        }

        public boolean isLateToFinish() {
            return this == LATE_TO_FINISH || this == ESTIMATED_LATE_TO_FINISH;
        }

        public boolean isEstimatedLate() {
            return this == ESTIMATED_LATE_TO_START || this == ESTIMATED_LATE_TO_FINISH;
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
