package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;


public class ScheduleStatus implements Comparable<ScheduleStatus> {

    public static final String RESOURCE = "scheduleStatus";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_CATEGORY = "category";
    public static final String PROPERTY_CONTAINS_FAILED_JOBS = "containsFailedJobs";

    public static final int ID_PARENT_HOLD = 15;

    private Integer id;
    private ScheduleStatusDescription description;

    private ScheduleStatusCategory category;

    private Boolean containsFailedJobs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ScheduleStatusDescription getDescription() {
        return description;
    }

    public void setDescription(ScheduleStatusDescription description) {
        this.description = description;
    }

    public ScheduleStatusCategory getCategory() {
        return category;
    }

    public void setCategory(ScheduleStatusCategory category) {
        this.category = category;
    }

    public Boolean getContainsFailedJobs() {
        return containsFailedJobs;
    }

    public void setContainsFailedJobs(Boolean containsFailedJobs) {
        this.containsFailedJobs = containsFailedJobs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ScheduleStatus that = (ScheduleStatus) o;

        if (id != null ? !id.equals(that.id) : that.id != null)
            return false;
        if (description != that.description)
            return false;
        if (category != that.category)
            return false;
        return containsFailedJobs != null ? containsFailedJobs.equals(that.containsFailedJobs) : that.containsFailedJobs == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (containsFailedJobs != null ? containsFailedJobs.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return description == null ? null : description.getValue();
    }

    @Override
    public int compareTo(ScheduleStatus o) {
        if (description == null && o.getDescription() == null) {
            return 0;
        } else if (description == null) {
            return -1;
        } else if (o.getDescription() == null) {
            return 1;
        } else {
            return description.getValue().compareTo(o.getDescription().getValue());
        }
    }

    public enum ScheduleStatusDescription {
        WAIT_TO_START("Wait to Start"),
        WAIT_CONTAINER_JOB("Wait Container Job"),
        ON_HOLD("On Hold"),
        PARENT_HOLD("Parent Hold"),
        STARTING("Starting"),
        IN_PROCESS("In Process"),
        STARTED_BY_USER("Started by User"),
        STARTED_BY_CONTAINER_JOB("Started by Container Job"),
        COMPLETED_PROCESSING_EVENTS("Completed; Processing Events"),
        COMPLETED("Completed");

        private final String value;

        ScheduleStatusDescription(String value) {
            this.value = Objects.requireNonNull(value, "Value cannot be null");
        }

        @JsonValue
        public String getValue() {
            return value;
        }
    }

    /**
     * Provides schedule status categories supported by OpCon Jobs.
     */
    public enum ScheduleStatusCategory {
        WAITING("Waiting"),
        HELD("Held"),
        RUNNING("Running"),
        FINISHED_OK("Finished Ok");

        private final String value;

        ScheduleStatusCategory(String opconValue) {
            this.value = opconValue;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }

        /**
         * Find the appropriate status category constant from the given value, can return <code>null</code> when
         * no category matches the value.
         *
         * @param value
         * @return <code>null</code> when not found!
         */
        @JsonCreator
        public static ScheduleStatus.ScheduleStatusCategory fromValue(String value) {
            for (ScheduleStatus.ScheduleStatusCategory category : ScheduleStatus.ScheduleStatusCategory.values()) {
                if (category.getValue().equalsIgnoreCase(value)) {
                    return category;
                }
            }

            return null;
        }
    }
}
