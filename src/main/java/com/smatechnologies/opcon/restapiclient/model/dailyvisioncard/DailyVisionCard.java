package com.smatechnologies.opcon.restapiclient.model.dailyvisioncard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smatechnologies.opcon.restapiclient.model.RemoteInstance;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static com.smatechnologies.opcon.restapiclient.model.dailyvisioncard.DailyVisionCard.PROPERTY_PARENT_DAILY_VISION_CARD;


/**
 * @author Matthieu COELHO
 */
@JsonIgnoreProperties(value = { PROPERTY_PARENT_DAILY_VISION_CARD, DailyVisionGroupCard.PROPERTY_CHILDREN, DailyVisionTagCard.PROPERTY_TAG_PATTERN })
public abstract class DailyVisionCard {

    public static final String RESOURCE = "dailyVisionCard";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_TRACK_ID = "trackId";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DATE = "date";
    public static final String PROPERTY_OFFSET = "offset";
    public static final String PROPERTY_SCHEDULE_DATE = "scheduleDate";
    public static final String PROPERTY_STATS = "stats";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_REMOTE_INSTANCE = "remoteInstance";

    protected static final String PROPERTY_PARENT_DAILY_VISION_CARD = "parentDailyVisionCard";

    private Integer id;
    private String trackId;
    private String name;
    private LocalDate date;
    private Integer offset;
    private LocalDate scheduleDate;
    private DailyVisionCardStats stats;
    private List<DailyVisionCardStatus> status;
    private RemoteInstance remoteInstance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public LocalDate getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(LocalDate scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public DailyVisionCardStats getStats() {
        return stats;
    }

    public void setStats(DailyVisionCardStats stats) {
        this.stats = stats;
    }

    public List<DailyVisionCardStatus> getStatus() {
        return status;
    }

    public void setStatus(List<DailyVisionCardStatus> status) {
        this.status = status;
    }

    public RemoteInstance getRemoteInstance() {
        return remoteInstance;
    }

    public void setRemoteInstance(RemoteInstance remoteInstance) {
        this.remoteInstance = remoteInstance;
    }

    public abstract TYPE getType();

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DailyVisionCard that = (DailyVisionCard) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(trackId, that.trackId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(date, that.date) &&
                Objects.equals(offset, that.offset) &&
                Objects.equals(scheduleDate, that.scheduleDate) &&
                Objects.equals(stats, that.stats) &&
                Objects.equals(status, that.status) &&
                Objects.equals(remoteInstance, that.remoteInstance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, trackId, name, date, offset, scheduleDate, stats, status, remoteInstance);
    }

    public enum TYPE {
        GROUP,
        TAG
    }
}
