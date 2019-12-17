package com.smatechnologies.opcon.restapiclient.model;

import com.smatechnologies.opcon.restapiclient.model.dailyvisioncard.DailyVisionCardStatus;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;


/**
 * @author Matthieu COELHO
 */
public class VisionJobAnomaly {

    public static final String RESOURCE = "VisionJobAnomalies";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_VISION_CARD_ANOMALY = "visionCardAnomaly";
    public static final String PROPERTY_SCHEDULE_DATE = "scheduleDate";
    public static final String PROPERTY_TAGS = "tags";
    public static final String PROPERTY_SCHEDULE_PATH = "schedulePath";
    public static final String PROPERTY_JOB_NAME = "jobName";
    public static final String PROPERTY_RUN_NUMBER = "runNumber";
    public static final String PROPERTY_START_TIME = "startTime";
    public static final String PROPERTY_END_TIME = "endTime";
    public static final String PROPERTY_DURATION = "duration";
    public static final String PROPERTY_REMOTE_INSTANCE = "remoteInstance";
    public static final String PROPERTY_JOB_STATUS = "jobStatus";
    public static final String PROPERTY_STATUS = "status";

    private Integer id;
    private VisionCardAnomaly visionCardAnomaly;
    private LocalDate scheduleDate;
    private List<String> tags;
    private String schedulePath;
    private String jobName;
    private Integer runNumber;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
    private Long duration;
    private RemoteInstance remoteInstance;
    private JobStatus jobStatus;
    private List<DailyVisionCardStatus> status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public VisionCardAnomaly getVisionCardAnomaly() {
        return visionCardAnomaly;
    }

    public void setVisionCardAnomaly(VisionCardAnomaly visionCardAnomaly) {
        this.visionCardAnomaly = visionCardAnomaly;
    }

    public LocalDate getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(LocalDate scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getSchedulePath() {
        return schedulePath;
    }

    public void setSchedulePath(String schedulePath) {
        this.schedulePath = schedulePath;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Integer getRunNumber() {
        return runNumber;
    }

    public void setRunNumber(Integer runNumber) {
        this.runNumber = runNumber;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
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

    public RemoteInstance getRemoteInstance() {
        return remoteInstance;
    }

    public void setRemoteInstance(RemoteInstance remoteInstance) {
        this.remoteInstance = remoteInstance;
    }

    public JobStatus getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(JobStatus jobStatus) {
        this.jobStatus = jobStatus;
    }

    public List<DailyVisionCardStatus> getStatus() {
        return status;
    }

    public void setStatus(List<DailyVisionCardStatus> status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof VisionJobAnomaly))
            return false;
        VisionJobAnomaly that = (VisionJobAnomaly) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getVisionCardAnomaly(), that.getVisionCardAnomaly()) &&
                Objects.equals(getScheduleDate(), that.getScheduleDate()) &&
                Objects.equals(getTags(), that.getTags()) &&
                Objects.equals(getSchedulePath(), that.getSchedulePath()) &&
                Objects.equals(getJobName(), that.getJobName()) &&
                Objects.equals(getRunNumber(), that.getRunNumber()) &&
                Objects.equals(getStartTime(), that.getStartTime()) &&
                Objects.equals(getEndTime(), that.getEndTime()) &&
                Objects.equals(getDuration(), that.getDuration()) &&
                Objects.equals(getRemoteInstance(), that.getRemoteInstance()) &&
                Objects.equals(getJobStatus(), that.getJobStatus()) &&
                Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getVisionCardAnomaly(), getScheduleDate(), getTags(), getSchedulePath(), getJobName(), getRunNumber(), getStartTime(), getEndTime(), getDuration(), getRemoteInstance(), getJobStatus(), getStatus());
    }
}