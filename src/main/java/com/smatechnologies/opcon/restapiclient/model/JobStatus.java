package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;


public class JobStatus implements Comparable<JobStatus> {

    public static final String RESOURCE = "jobStatus";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_START_STATUS = "startStatus";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_CATEGORY = "category";
    public static final String PROPERTY_CHANGE_REASON = "changeReason";

    private Integer id;
    private Integer startStatus;
    private JobStatusDescription description;
    private JobStatusCategory category;
    private String changeReason;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStartStatus() {
        return startStatus;
    }

    public void setStartStatus(Integer startStatus) {
        this.startStatus = startStatus;
    }

    public JobStatusDescription getDescription() {
        return description;
    }

    public void setDescription(JobStatusDescription description) {
        this.description = description;
        this.category = getCategory(); //This Field is useless for Solution Manager but updated automatically for the Rest API
    }

    public String getChangeReason() {
        return changeReason;
    }

    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason;
    }

    public JobStatusCategory getCategory() {
        return description == null ? null : description.getCategory();
    }

    public boolean isProcessingEvents() {
        return (description != null && description.isProcessingEvents());
    }

    /**
     * {@link JobStatusCategory#isTerminated()}
     *
     * @return
     */
    public boolean isTerminated() {
        return getCategory().isTerminated();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        JobStatus jobStatus = (JobStatus) o;

        if (id != null ? !id.equals(jobStatus.id) : jobStatus.id != null)
            return false;
        if (startStatus != null ? !startStatus.equals(jobStatus.startStatus) : jobStatus.startStatus != null)
            return false;
        if (description != jobStatus.description)
            return false;
        if (category != jobStatus.category)
            return false;
        return changeReason != null ? changeReason.equals(jobStatus.changeReason) : jobStatus.changeReason == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (startStatus != null ? startStatus.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (changeReason != null ? changeReason.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return description == null ? null : description.getValue();
    }

    @Override
    public int compareTo(JobStatus o) {
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

    public enum JobStatusDescription {
        ON_HOLD("On Hold", JobStatusCategory.HELD, false),
        UNDER_CONSTRUCTION("Under Construction", JobStatusCategory.WAITING, false),
        QUALIFYING("Qualifying", JobStatusCategory.WAITING, false),
        RELEASED("Released", JobStatusCategory.WAITING, false),
        WAIT_START_TIME("Wait Start Time", JobStatusCategory.WAITING, false),
        WAIT_JOB_DEPENDENCY("Wait Job Dependency", JobStatusCategory.WAITING, false),
        WAIT_EXPRESSION_DEPENDENCY("Wait Expression Dependency", JobStatusCategory.WAITING, false),
        WAIT_THRESHOLD_RESOURCE_DEPENDENCY("Wait Threshold/Resource Dependency", JobStatusCategory.WAITING, false),
        WAIT_MACHINE("Wait Machine", JobStatusCategory.WAITING, false),
        WAIT_JOB_CONFLICT("Wait Job Conflict", JobStatusCategory.WAITING, false),
        JOB_TO_BE_SKIPPED("Job to be Skipped", JobStatusCategory.WAITING, false),
        LATE_TO_START("Late to Start", JobStatusCategory.WAITING, false),
        WAIT_TO_START("Wait to Start", JobStatusCategory.WAITING, false),
        ATTEMPT_TO_START("Attempt to Start", JobStatusCategory.RUNNING, false),
        START_ATTEMPTED("Start Attempted", JobStatusCategory.RUNNING, false),
        STILL_ATTEMPTING_START("Still Attempting Start", JobStatusCategory.RUNNING, false),
        INITIALIZATION_ERROR("Initialization Error", JobStatusCategory.FAILED, false),
        PRERUN_ACTIVE("Prerun Active", JobStatusCategory.RUNNING, false),
        PRERUN_FAILED("Prerun Failed", JobStatusCategory.WAITING, false),
        JOB_RUNNING("Job Running", JobStatusCategory.RUNNING, false),
        JOB_RUNNING_AND_LATE_TO_FINISH("Job Running; Late to Finish", JobStatusCategory.RUNNING, false),
        JOB_RUNNING_AND_TO_BE_TERMINATED("Job Running; To be terminated", JobStatusCategory.RUNNING, false),
        FINISHED_OK_AND_PROCESSING_EVENTS("Finished OK; Processing Events", JobStatusCategory.FINISHED_OK, true),
        FAILED_AND_PROCESSING_EVENTS("Failed; Processing Events", JobStatusCategory.FAILED, true),
        MARKED_FINISHED_OK_AND_PROCESSING_EVENTS("Marked Finished OK; Processing Events", JobStatusCategory.FINISHED_OK, true),
        MARKED_FAILED_AND_PROCESSING_EVENTS("Marked Failed; Processing Events", JobStatusCategory.FAILED, true),
        SKIPPED_AND_PROCESSING_EVENTS("Skipped; Processing Events", JobStatusCategory.SKIPPED, true),
        UNDER_REVIEW_AND_PROCESSING_EVENTS("Under Review; Processing Events", JobStatusCategory.UNDER_REVIEW, true),
        FIXED_AND_PROCESSING_EVENTS("Fixed; Processing Events", JobStatusCategory.FIXED, true),
        FINISHED_OK("Finished OK", JobStatusCategory.FINISHED_OK, false),
        FAILED("Failed", JobStatusCategory.FAILED, false),
        MARKED_FINISHED_OK("Marked Finished OK", JobStatusCategory.FINISHED_OK, false),
        MARKED_FAILED("Marked Failed", JobStatusCategory.FAILED, false),
        SKIPPED("Skipped", JobStatusCategory.SKIPPED, false),
        UNDER_REVIEW("Under Review", JobStatusCategory.UNDER_REVIEW, false),
        FIXED("Fixed", JobStatusCategory.FIXED, false),
        CANCELLED("Cancelled", JobStatusCategory.CANCELLED, false),
        MISSED_START_TIME("Missed Start Time", JobStatusCategory.MISSED_START_TIME, false),
        WAIT_TO_START_AND_FORCED("Wait to Start; Forced", JobStatusCategory.WAITING, false);

        private final String value;
        private final JobStatusCategory category;
        private final boolean processingEvents;

        JobStatusDescription(String value, JobStatusCategory category, boolean processingEvents) {
            this.value = Objects.requireNonNull(value, "Value cannot be null");
            this.category = Objects.requireNonNull(category, "Category cannot be null");
            this.processingEvents = processingEvents;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        public JobStatusCategory getCategory() {
            return category;
        }

        public boolean isProcessingEvents() {
            return processingEvents;
        }
    }

    /**
     * Provides job status categories supported by OpCon Jobs.
     */
    public enum JobStatusCategory {
        HELD("Held"),
        WAITING("Waiting"),
        RUNNING("Running"),
        FINISHED_OK("Finished Ok"),
        FAILED("Failed"),
        MISSED_START_TIME("Missed Start Time"),
        CANCELLED("Cancelled"),
        SKIPPED("Skipped"),
        UNDER_REVIEW("Under Review"),
        FIXED("Fixed");

        private final String value;

        JobStatusCategory(String opconValue) {
            this.value = opconValue;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        public boolean isWaiting() {
            return this == WAITING || this == HELD;
        }

        public boolean isNeverRan() {
            return this == CANCELLED || this == SKIPPED || this == MISSED_START_TIME;
        }

        public boolean isFinishedOk() {
            return this == FINISHED_OK || this == FIXED;
        }

        public boolean isFailed() {
            return this == FAILED || this == UNDER_REVIEW;
        }

        public boolean isEnded() {
            return isFinishedOk() || isFailed();
        }

        public boolean isTerminated() {
            return isNeverRan() || isEnded();
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
        public static JobStatusCategory fromValue(String value) {
            for (JobStatusCategory category : JobStatusCategory.values()) {
                if (category.getValue().equalsIgnoreCase(value)) {
                    return category;
                }
            }

            return null;
        }
    }
}
