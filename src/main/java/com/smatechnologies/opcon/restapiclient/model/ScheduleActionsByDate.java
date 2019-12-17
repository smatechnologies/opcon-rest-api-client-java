package com.smatechnologies.opcon.restapiclient.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;


public class ScheduleActionsByDate {

    public static final String RESOURCE = "scheduleActionsByDate";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_SCHEDULE_DATES = "scheduleDates";
    public static final String PROPERTY_ACTION = "action";
    public static final String PROPERTY_STATES = "states";
    public static final String PROPERTY_RESULT = "result";
    public static final String PROPERTY_JOBS = "jobs";
    public static final String PROPERTY_MESSAGE = "message";
    public static final String PROPERTY_REASON = "reason";
    public static final String PROPERTY_EXPIRES = "expires";
    public static final String PROPERTY_UPDATED = "updated";

    private Integer id;
    private List<LocalDate> scheduleDates;
    private ScheduleAction.Action action;
    private List<JobStatus.JobStatusCategory> states;
    private Result result;
    private List<ScheduleAction.Schedule.Job> jobs;
    private String message;
    private String reason;
    private Date expires;
    private Integer updated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<LocalDate> getScheduleDates() {
        return scheduleDates;
    }

    public void setScheduleDates(List<LocalDate> scheduleDates) {
        this.scheduleDates = scheduleDates;
    }

    public ScheduleAction.Action getAction() {
        return action;
    }

    public void setAction(ScheduleAction.Action action) {
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

    public List<ScheduleAction.Schedule.Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<ScheduleAction.Schedule.Job> jobs) {
        this.jobs = jobs;
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

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    public Integer getUpdated() {
        return updated;
    }

    public void setUpdated(Integer updated) {
        this.updated = updated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ScheduleActionsByDate that = (ScheduleActionsByDate) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(scheduleDates, that.scheduleDates) &&
                action == that.action &&
                Objects.equals(states, that.states) &&
                result == that.result &&
                Objects.equals(jobs, that.jobs) &&
                Objects.equals(message, that.message) &&
                Objects.equals(reason, that.reason) &&
                Objects.equals(expires, that.expires) &&
                Objects.equals(updated, that.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, scheduleDates, action, states, result, jobs, message, reason, expires, updated);
    }
}
