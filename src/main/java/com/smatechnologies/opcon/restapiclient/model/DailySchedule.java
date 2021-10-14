package com.smatechnologies.opcon.restapiclient.model;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;


public class DailySchedule {

    public static final String RESOURCE = "dailySchedule";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_UID = "uid";
    public static final String PROPERTY_DATE = "date";
    public static final String PROPERTY_MASTER_ID = "masterId";
    public static final String PROPERTY_INSTANCE = "instance";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_PATH = "path";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_DEFINED_START_TIME = "definedStartTime";
    public static final String PROPERTY_COMPUTED_START_TIME = "computedStartTime";
    public static final String PROPERTY_END_TIME = "endTime";
    public static final String PROPERTY_DURATION = "duration";
    public static final String PROPERTY_WORKWEEK = "workWeek";

    private String id;
    private Integer uid;
    private LocalDate date;
    private Integer masterId;
    private Integer instance;
    private String name;
    private String path;
    private ScheduleStatus status;
    private ZonedDateTime definedStartTime;
    private ComputedTime computedStartTime;
    private ZonedDateTime endTime;
    private Long duration;
    private Integer workWeek;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getMasterId() {
        return masterId;
    }

    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

    public Integer getInstance() {
        return instance;
    }

    public void setInstance(Integer instance) {
        this.instance = instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ScheduleStatus getStatus() {
        return status;
    }

    public void setStatus(ScheduleStatus status) {
        this.status = status;
    }

    public ZonedDateTime getDefinedStartTime() {
        return definedStartTime;
    }

    public void setDefinedStartTime(ZonedDateTime definedStartTime) {
        this.definedStartTime = definedStartTime;
    }

    public ComputedTime getComputedStartTime() {
        return computedStartTime;
    }

    public void setComputedStartTime(ComputedTime computedStartTime) {
        this.computedStartTime = computedStartTime;
    }

    public ZonedDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(ZonedDateTime endTime) {
        this.endTime = endTime;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Integer getWorkWeek() {
        return workWeek;
    }

    public void setWorkWeek(Integer workWeek) {
        this.workWeek = workWeek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DailySchedule that = (DailySchedule) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(uid, that.uid) &&
                Objects.equals(date, that.date) &&
                Objects.equals(masterId, that.masterId) &&
                Objects.equals(instance, that.instance) &&
                Objects.equals(name, that.name) &&
                Objects.equals(path, that.path) &&
                Objects.equals(status, that.status) &&
                Objects.equals(definedStartTime, that.definedStartTime) &&
                Objects.equals(computedStartTime, that.computedStartTime) &&
                Objects.equals(endTime, that.endTime) &&
                Objects.equals(duration, that.duration) &&
                Objects.equals(workWeek, that.workWeek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uid, date, masterId, instance, name, path, status, definedStartTime, computedStartTime, endTime, duration, workWeek);
    }
}
