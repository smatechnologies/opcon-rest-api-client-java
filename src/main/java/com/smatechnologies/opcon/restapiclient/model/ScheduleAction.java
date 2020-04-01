package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.smatechnologies.opcon.restapiclient.util.ScheduleActionUtil;

import java.util.Date;
import java.util.List;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class ScheduleAction {

    public static final String RESOURCE = "scheduleAction";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ACTION = "action";
    public static final String PROPERTY_STATES = "states";
    public static final String PROPERTY_RESULT = "result";
    public static final String PROPERTY_SCHEDULES = "scheduleActionItems";
    public static final String PROPERTY_EXPIRES = "expires";
    public static final String PROPERTY_MESSAGE = "message";
    public static final String PROPERTY_REASON = "reason";

    private Integer id;
    private Action action;
    private List<JobStatus.JobStatusCategory> states;
    private Result result;
    @JsonProperty("scheduleActionItems")
    private List<Schedule> schedules;
    private Date expires;
    private String message;
    private String reason;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public List<JobStatus.JobStatusCategory> getStates() {
        return states;
    }

    public void setStates(List<JobStatus.JobStatusCategory> states) {
        this.states = states;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ScheduleAction scheduleAction = (ScheduleAction) o;

        if (id != null ? !id.equals(scheduleAction.id) : scheduleAction.id != null)
            return false;
        if (action != scheduleAction.action)
            return false;
        if (states != null ? !states.equals(scheduleAction.states) : scheduleAction.states != null)
            return false;
        if (result != scheduleAction.result)
            return false;
        if (schedules != null ? !schedules.equals(scheduleAction.schedules) : scheduleAction.schedules != null)
            return false;
        if (expires != null ? !expires.equals(scheduleAction.expires) : scheduleAction.expires != null)
            return false;
        if (message != null ? !message.equals(scheduleAction.message) : scheduleAction.message != null)
            return false;
        return reason != null ? reason.equals(scheduleAction.reason) : scheduleAction.reason == null;
    }

    @Override
    public int hashCode() {
        int result1 = id != null ? id.hashCode() : 0;
        result1 = 31 * result1 + (action != null ? action.hashCode() : 0);
        result1 = 31 * result1 + (states != null ? states.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (schedules != null ? schedules.hashCode() : 0);
        result1 = 31 * result1 + (expires != null ? expires.hashCode() : 0);
        result1 = 31 * result1 + (message != null ? message.hashCode() : 0);
        result1 = 31 * result1 + (reason != null ? reason.hashCode() : 0);
        return result1;
    }

    public enum Action {
        RELEASE("release", ScheduleActionUtil::isReleaseActionAllowed, false),
        HOLD("hold", ScheduleActionUtil::isHoldActionAllowed, false),
        START("start", ScheduleActionUtil::isStartActionAllowed, false),
        CLOSE("close", ScheduleActionUtil::isCloseActionAllowed, false),
        CANCEL_JOBS("cancelJobs", null, true),
        FORCE_RESTART_JOBS("forceRestartJobs", null, true),
        HOLD_JOBS("holdJobs", null, true),
        KILL_JOBS("killJobs", null, false),
        MARK_JOBS_FAILED("markJobsFailed", null, true),
        MARK_JOBS_FINISHED_OK("markJobsFinishedOk", null, true),
        MARK_JOBS_UNDER_REVIEW("markJobsUnderReview", null, true),
        MARK_JOBS_FIXED("markJobsFixed", null, true),
        RELEASE_JOBS("releaseJobs", null, true),
        RESTART_JOBS("restartJobs", null, true),
        RESTART_JOBS_ON_HOLD("restartJobsOnHold", null, true),
        START_JOBS("startJobs", null, true),
        SKIP_JOBS("skipJobs", null, true),
        ADD_JOBS("addJobs", null, false),
        ADD_JOBS_ON_HOLD("addJobsOnHold", null, false);

        private final String value;
        private final ActionChecker actionChecker;
        private final boolean bulk;

        Action(String value, ActionChecker actionChecker, boolean bulk) {
            this.value = value;
            this.actionChecker = actionChecker;
            this.bulk = bulk;
        }

        @JsonValue
        public String value() {
            return value;
        }

        public boolean isAllowed(DailySchedule dailySchedule, User user) {
            return actionChecker.isAllowed(dailySchedule, user);
        }

        public boolean isBulk() {
            return bulk;
        }

        private interface ActionChecker {

            boolean isAllowed(DailySchedule dailySchedule, User user);
        }
    }

    public static class Schedule {

        public static final String RESOURCE = "schedule";

        public static final String PROPERTY_ID = "id";
        public static final String PROPERTY_RESULT = "result";
        public static final String PROPERTY_JOBS = "jobs";
        public static final String PROPERTY_MESSAGE = "message";
        public static final String PROPERTY_UPDATED = "updated";
        public static final String PROPERTY_STATUS = "status";

        private String id;
        private Result result;
        private List<Job> jobs;
        private String message;
        private Integer updated;
        private ScheduleStatus status;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Result getResult() {
            return result;
        }

        public void setResult(Result result) {
            this.result = result;
        }

        public List<Job> getJobs() {
            return jobs;
        }

        public void setJobs(List<Job> jobs) {
            this.jobs = jobs;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Integer getUpdated() {
            return updated;
        }

        public void setUpdated(Integer updated) {
            this.updated = updated;
        }

        public ScheduleStatus getStatus() {
            return status;
        }

        public void setStatus(ScheduleStatus status) {
            this.status = status;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Schedule schedule = (Schedule) o;
            return Objects.equals(id, schedule.id) &&
                    result == schedule.result &&
                    Objects.equals(jobs, schedule.jobs) &&
                    Objects.equals(message, schedule.message) &&
                    Objects.equals(updated, schedule.updated) &&
                    Objects.equals(status, schedule.status);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, result, jobs, message, updated, status);
        }

        public static class Job {

            public static final String RESOURCE = "job";

            public static final String PROPERTY_ID = "id";
            public static final String PROPERTY_FREQUENCY = "frequency";
            public static final String PROPERTY_RESULT = "result";
            public static final String PROPERTY_MESSAGE = "message";
            public static final String PROPERTY_REBUILD_ON_RESTART_IF_CONTAINER = "rebuildOnRestartIfContainer";
            public static final String PROPERTY_INSTANCE_PROPERTIES = "instanceProperties";
            public static final String PROPERTY_APPLY_EXCEPTIONS = "applyExceptions";

            private String id;
            private String frequency;
            private String result;
            private String message;
            private Boolean rebuildOnRestartIfContainer;
            private List<InstanceProperty> instanceProperties;
            private Boolean applyExceptions;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getFrequency() {
                return frequency;
            }

            public void setFrequency(String frequency) {
                this.frequency = frequency;
            }

            public String getResult() {
                return result;
            }

            public void setResult(String result) {
                this.result = result;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public Boolean getRebuildOnRestartIfContainer() {
                return rebuildOnRestartIfContainer;
            }

            public void setRebuildOnRestartIfContainer(Boolean rebuildOnRestartIfContainer) {
                this.rebuildOnRestartIfContainer = rebuildOnRestartIfContainer;
            }

            public List<InstanceProperty> getInstanceProperties() {
                return instanceProperties;
            }

            public void setInstanceProperties(List<InstanceProperty> instanceProperties) {
                this.instanceProperties = instanceProperties;
            }

            public Boolean getApplyExceptions() {
                return applyExceptions;
            }

            public void setApplyExceptions(Boolean applyExceptions) {
                this.applyExceptions = applyExceptions;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o)
                    return true;
                if (o == null || getClass() != o.getClass())
                    return false;
                Job job = (Job) o;
                return Objects.equals(id, job.id) &&
                        Objects.equals(frequency, job.frequency) &&
                        Objects.equals(result, job.result) &&
                        Objects.equals(message, job.message) &&
                        Objects.equals(rebuildOnRestartIfContainer, job.rebuildOnRestartIfContainer) &&
                        Objects.equals(instanceProperties, job.instanceProperties) &&
                        Objects.equals(applyExceptions, job.applyExceptions);
            }

            @Override
            public int hashCode() {
                return Objects.hash(id, frequency, result, message, rebuildOnRestartIfContainer, instanceProperties, applyExceptions);
            }

            public static class InstanceProperty {

                public static final String RESOURCE = "instanceProperty";

                public static final String PROPERTY_NAME = "name";
                public static final String PROPERTY_VALUE = "value";

                private String name;
                private String value;

                public void setName(String name) {
                    this.name = name;
                }

                public String getName() {
                    return name;
                }

                public void setValue(String value) {
                    this.value = value;
                }

                public String getValue() {
                    return value;
                }

                @Override
                public boolean equals(Object o) {
                    if (this == o)
                        return true;
                    if (o == null || getClass() != o.getClass())
                        return false;
                    InstanceProperty instanceProperty = (InstanceProperty) o;
                    return Objects.equals(name, instanceProperty.name) &&
                            Objects.equals(value, instanceProperty.value);
                }

                @Override
                public int hashCode() {
                    return Objects.hash(name, value);
                }
            }
        }
    }
}
