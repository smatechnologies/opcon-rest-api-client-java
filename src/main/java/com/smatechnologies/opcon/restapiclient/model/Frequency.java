package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonValue;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class Frequency {

    public static final String RESOURCE = "frequency";

    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_IN_USE = "inUse"; 
    public static final String PROPERTY_AOBN = "aobn"; 
    public static final String PROPERTY_FREQUENCY_PRIORITY = "frequencyPriority"; 
    public static final String PROPERTY_JOB_EXECUTION = "jobExecution";
    public static final String PROPERTY_FINISH_OK_BEHAVIOR = "finishOkBehavior";
    public static final String PROPERTY_START_TIME_ESTIMATION = "startTimeEstimation";
    public static final String PROPERTY_RETRY_BEHAVIOR = "retryBehavior";
    public static final String PROPERTY_JOB_TIMES_ESTIMATION = "jobTimesEstimation";

    /*
     * "inUse": 0,
"aobn": "Unknown",
"name": "SMASun-SatO7",
"frequencyPriority": 0,
     */
    
    private String name;
    private Integer inUse;
    private Integer aobn;
    private Integer frequencyPriority;
    private JobExecution jobExecution;
    private FinishOkBehavior finishOkBehavior;
    private StartTimeEstimation startTimeEstimation;
    private RetryBehavior retryBehavior;
    private JobTimesEstimation jobTimesEstimation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getInUse() {
		return inUse;
	}

	public void setInUse(Integer inUse) {
		this.inUse = inUse;
	}

	public Integer getAobn() {
		return aobn;
	}

	public void setAobn(Integer aobn) {
		this.aobn = aobn;
	}

	public Integer getFrequencyPriority() {
		return frequencyPriority;
	}

	public void setFrequencyPriority(Integer frequencyPriority) {
		this.frequencyPriority = frequencyPriority;
	}

	public JobExecution getJobExecution() {
        return jobExecution;
    }

    public void setJobExecution(JobExecution jobExecution) {
        this.jobExecution = jobExecution;
    }

    public FinishOkBehavior getFinishOkBehavior() {
        return finishOkBehavior;
    }

    public void setFinishOkBehavior(FinishOkBehavior finishOkBehavior) {
        this.finishOkBehavior = finishOkBehavior;
    }

    public StartTimeEstimation getStartTimeEstimation() {
        return startTimeEstimation;
    }

    public void setStartTimeEstimation(StartTimeEstimation startTimeEstimation) {
        this.startTimeEstimation = startTimeEstimation;
    }

    public RetryBehavior getRetryBehavior() {
        return retryBehavior;
    }

    public void setRetryBehavior(RetryBehavior retryBehavior) {
        this.retryBehavior = retryBehavior;
    }

    public JobTimesEstimation getJobTimesEstimation() {
        return jobTimesEstimation;
    }

    public void setJobTimesEstimation(JobTimesEstimation jobTimesEstimation) {
        this.jobTimesEstimation = jobTimesEstimation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Frequency frequency = (Frequency) o;
        return Objects.equals(name, frequency.name) &&
                Objects.equals(jobExecution, frequency.jobExecution) &&
                Objects.equals(finishOkBehavior, frequency.finishOkBehavior) &&
                Objects.equals(startTimeEstimation, frequency.startTimeEstimation) &&
                Objects.equals(retryBehavior, frequency.retryBehavior) &&
                Objects.equals(jobTimesEstimation, frequency.jobTimesEstimation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, jobExecution, finishOkBehavior, startTimeEstimation, retryBehavior, jobTimesEstimation);
    }

    public static class JobExecution {

        public static final String PROPERTY_SAM_PRIORITY = "samPriority";
        public static final String PROPERTY_MAX_RUN_TIME = "maxRunTime";

        private Integer samPriority;
        private Integer maxRunTime;

        public Integer getSamPriority() {
            return samPriority;
        }

        public void setSamPriority(Integer samPriority) {
            this.samPriority = samPriority;
        }

        public Integer getMaxRunTime() {
            return maxRunTime;
        }

        public void setMaxRunTime(Integer maxRunTime) {
            this.maxRunTime = maxRunTime;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            JobExecution that = (JobExecution) o;
            return Objects.equals(samPriority, that.samPriority) &&
                    Objects.equals(maxRunTime, that.maxRunTime);
        }

        @Override
        public int hashCode() {
            return Objects.hash(samPriority, maxRunTime);
        }
    }

    public static class FinishOkBehavior {

        public static final String PROPERTY_TYPE = "type";
        public static final String PROPERTY_ACTION_ON_OVERLAP = "actionOnOverlap";
        public static final String PROPERTY_INSTANCE_TIMES = "instanceTimes";
        public static final String PROPERTY_MINUTES_FROM_START_TO_START = "minutesFromStartToStart";
        public static final String PROPERTY_MINUTES_FROM_END_TO_START = "minutesFromEndToStart";
        public static final String PROPERTY_NUMBER_OF_RUNS = "numberOfRuns";
        public static final String PROPERTY_LATEST_RUN_TIME_OFFSET = "latestRunTimeOffset";

        private Type type;
        private ActionOnOverlap actionOnOverlap;
        private List<ZonedDateTime> instanceTimes;
        private Integer minutesFromStartToStart;
        private Integer minutesFromEndToStart;
        private Integer numberOfRuns;
        private Integer latestRunTimeOffset;

        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }

        public ActionOnOverlap getActionOnOverlap() {
            return actionOnOverlap;
        }

        public void setActionOnOverlap(ActionOnOverlap actionOnOverlap) {
            this.actionOnOverlap = actionOnOverlap;
        }

        public List<ZonedDateTime> getInstanceTimes() {
            return instanceTimes;
        }

        public void setInstanceTimes(List<ZonedDateTime> instanceTimes) {
            this.instanceTimes = instanceTimes;
        }

        public Integer getMinutesFromStartToStart() {
            return minutesFromStartToStart;
        }

        public void setMinutesFromStartToStart(Integer minutesFromStartToStart) {
            this.minutesFromStartToStart = minutesFromStartToStart;
        }

        public Integer getMinutesFromEndToStart() {
            return minutesFromEndToStart;
        }

        public void setMinutesFromEndToStart(Integer minutesFromEndToStart) {
            this.minutesFromEndToStart = minutesFromEndToStart;
        }

        public Integer getNumberOfRuns() {
            return numberOfRuns;
        }

        public void setNumberOfRuns(Integer numberOfRuns) {
            this.numberOfRuns = numberOfRuns;
        }

        public Integer getLatestRunTimeOffset() {
            return latestRunTimeOffset;
        }

        public void setLatestRunTimeOffset(Integer latestRunTimeOffset) {
            this.latestRunTimeOffset = latestRunTimeOffset;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            FinishOkBehavior that = (FinishOkBehavior) o;
            return Objects.equals(type, that.type) &&
                    Objects.equals(actionOnOverlap, that.actionOnOverlap) &&
                    Objects.equals(instanceTimes, that.instanceTimes) &&
                    Objects.equals(minutesFromStartToStart, that.minutesFromStartToStart) &&
                    Objects.equals(minutesFromEndToStart, that.minutesFromEndToStart) &&
                    Objects.equals(numberOfRuns, that.numberOfRuns) &&
                    Objects.equals(latestRunTimeOffset, that.latestRunTimeOffset);
        }

        @Override
        public int hashCode() {
            return Objects.hash(type, actionOnOverlap, instanceTimes, minutesFromStartToStart, minutesFromEndToStart, numberOfRuns, latestRunTimeOffset);
        }

        public enum Type {
            NONE("None"),
            RECURRING_INSTANCES("RecurringInstances"),
            RESTART_OFFSET("RestartOffset");

            private final String value;

            Type(String value) {
                this.value = value;
            }

            @JsonValue
            public String getValue() {
                return value;
            }

            @Override
            public String toString() {
                return value;
            }
        }

        public enum ActionOnOverlap {
            SKIP("Skip"),
            START_ON_COMPLETION("StartOnCompletion");

            private final String value;

            ActionOnOverlap(String value) {
                this.value = value;
            }

            @JsonValue
            public String getValue() {
                return value;
            }

            @Override
            public String toString() {
                return value;
            }
        }
    }

    public static class StartTimeEstimation {

        public static final String PROPERTY_ESTIMATION_SOURCE = "estimationSource";
        public static final String PROPERTY_ESTIMATED_RUN_TIME = "estimatedRunTime";
        public static final String PROPERTY_PREDICTED_START_TIME_OFFSET = "predictedStartTimeOffset";

        private EstimationSource estimationSource;
        private Integer estimatedRunTime;
        private Integer predictedStartTimeOffset;

        public EstimationSource getEstimationSource() {
            return estimationSource;
        }

        public void setEstimationSource(EstimationSource estimationSource) {
            this.estimationSource = estimationSource;
        }

        public Integer getEstimatedRunTime() {
            return estimatedRunTime;
        }

        public void setEstimatedRunTime(Integer estimatedRunTime) {
            this.estimatedRunTime = estimatedRunTime;
        }

        public Integer getPredictedStartTimeOffset() {
            return predictedStartTimeOffset;
        }

        public void setPredictedStartTimeOffset(Integer predictedStartTimeOffset) {
            this.predictedStartTimeOffset = predictedStartTimeOffset;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            StartTimeEstimation that = (StartTimeEstimation) o;
            return Objects.equals(estimationSource, that.estimationSource) &&
                    Objects.equals(estimatedRunTime, that.estimatedRunTime) &&
                    Objects.equals(predictedStartTimeOffset, that.predictedStartTimeOffset);
        }

        @Override
        public int hashCode() {
            return Objects.hash(estimationSource, estimatedRunTime, predictedStartTimeOffset);
        }

        public enum EstimationSource {
            CALCULATED("Calculated"),
            HISTORY("History"),
            USER_DEFINED("UserDefined");

            private final String value;

            EstimationSource(String value) {
                this.value = value;
            }

            @JsonValue
            public String getValue() {
                return value;
            }

            @Override
            public String toString() {
                return value;
            }
        }
    }

    public static class RetryBehavior {

        public static final String PROPERTY_RETRY_ON_FAIL = "retryOnFail";
        public static final String PROPERTY_MINUTES_BETWEEN_ATTEMPTS = "minutesBetweenAttempts";
        public static final String PROPERTY_MAXIMUM_ATTEMPTS = "maximumAttempts";

        private Boolean retryOnFail;
        private Integer minutesBetweenAttempts;
        private Integer maximumAttempts;

        public Boolean isRetryOnFail() {
            return retryOnFail;
        }

        public void setRetryOnFail(Boolean retryOnFail) {
            this.retryOnFail = retryOnFail;
        }

        public Integer getMinutesBetweenAttempts() {
            return minutesBetweenAttempts;
        }

        public void setMinutesBetweenAttempts(Integer minutesBetweenAttempts) {
            this.minutesBetweenAttempts = minutesBetweenAttempts;
        }

        public Integer getMaximumAttempts() {
            return maximumAttempts;
        }

        public void setMaximumAttempts(Integer maximumAttempts) {
            this.maximumAttempts = maximumAttempts;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            RetryBehavior that = (RetryBehavior) o;
            return Objects.equals(retryOnFail, that.retryOnFail) &&
                    Objects.equals(minutesBetweenAttempts, that.minutesBetweenAttempts) &&
                    Objects.equals(maximumAttempts, that.maximumAttempts);
        }

        @Override
        public int hashCode() {
            return Objects.hash(retryOnFail, minutesBetweenAttempts, maximumAttempts);
        }
    }

    public static class JobTimesEstimation {

        public static final String PROPERTY_PARENT_SCHEDULE_START_TIME = "parentScheduleStartTime";
        public static final String PROPERTY_START_OFFSET_TIME_FORMAT = "startOffsetTimeFormat";
        public static final String PROPERTY_START_OFFSET = "startOffset";
        public static final String PROPERTY_LATEST_START_OFFSET = "latestStartOffset";
        public static final String PROPERTY_LATEST_START_OFFSET_TIME_FORMAT = "latestStartOffsetTimeFormat";
        public static final String PROPERTY_LATE_TO_FINISH_OFFSET = "lateToFinishOffset";
        public static final String PROPERTY_LATE_TO_START_OFFSET = "lateToStartOffset";

        private ZonedDateTime parentScheduleStartTime;
        private Format startOffsetTimeFormat;
        private Integer startOffset;
        private Integer latestStartOffset;
        private Format latestStartOffsetTimeFormat;
        private Integer lateToFinishOffset;
        private Integer lateToStartOffset;

        public ZonedDateTime getParentScheduleStartTime() {
            return parentScheduleStartTime;
        }

        public void setParentScheduleStartTime(ZonedDateTime parentScheduleStartTime) {
            this.parentScheduleStartTime = parentScheduleStartTime;
        }

        public Format getStartOffsetTimeFormat() {
            return startOffsetTimeFormat;
        }

        public void setStartOffsetTimeFormat(Format startOffsetTimeFormat) {
            this.startOffsetTimeFormat = startOffsetTimeFormat;
        }

        public Integer getStartOffset() {
            return startOffset;
        }

        public void setStartOffset(Integer startOffset) {
            this.startOffset = startOffset;
        }

        public Integer getLatestStartOffset() {
            return latestStartOffset;
        }

        public void setLatestStartOffset(Integer latestStartOffset) {
            this.latestStartOffset = latestStartOffset;
        }

        public Format getLatestStartOffsetTimeFormat() {
            return latestStartOffsetTimeFormat;
        }

        public void setLatestStartOffsetTimeFormat(Format latestStartOffsetTimeFormat) {
            this.latestStartOffsetTimeFormat = latestStartOffsetTimeFormat;
        }

        public Integer getLateToFinishOffset() {
            return lateToFinishOffset;
        }

        public void setLateToFinishOffset(Integer lateToFinishOffset) {
            this.lateToFinishOffset = lateToFinishOffset;
        }

        public Integer getLateToStartOffset() {
            return lateToStartOffset;
        }

        public void setLateToStartOffset(Integer lateToStartOffset) {
            this.lateToStartOffset = lateToStartOffset;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            JobTimesEstimation that = (JobTimesEstimation) o;
            return Objects.equals(parentScheduleStartTime, that.parentScheduleStartTime) &&
                    Objects.equals(startOffsetTimeFormat, that.startOffsetTimeFormat) &&
                    Objects.equals(startOffset, that.startOffset) &&
                    Objects.equals(latestStartOffset, that.latestStartOffset) &&
                    Objects.equals(latestStartOffsetTimeFormat, that.latestStartOffsetTimeFormat) &&
                    Objects.equals(lateToFinishOffset, that.lateToFinishOffset) &&
                    Objects.equals(lateToStartOffset, that.lateToStartOffset);
        }

        @Override
        public int hashCode() {
            return Objects.hash(parentScheduleStartTime, startOffsetTimeFormat, startOffset, latestStartOffset, latestStartOffsetTimeFormat, lateToFinishOffset, lateToStartOffset);
        }

        public enum Format {
            EQUAL("Relative"),
            NOT_EQUAL("Absolute");

            private final String value;

            Format(String value) {
                this.value = value;
            }

            @JsonValue
            public String getValue() {
                return value;
            }

            @Override
            public String toString() {
                return value;
            }
        }
    }
}
