package com.smatechnologies.opcon.restapiclient.model;

import com.smatechnologies.opcon.restapiclient.model.dailyvisioncard.DailyVisionCardStatus;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;


/**
 * @author Matthieu COELHO
 */
public class VisionCardAnomaly {

    public static final String RESOURCE = "VisionCardAnomalies";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_VISION_HISTORY_ID = "visionHistoryId";
    public static final String PROPERTY_CARD_ID = "cardId";
    public static final String PROPERTY_SOURCE_CARD = "sourceCard";
    public static final String PROPERTY_TRACK_ID = "trackId";
    public static final String PROPERTY_VISION_DATE = "visionDate";
    public static final String PROPERTY_CARD_PATH = "cardPath";
    public static final String PROPERTY_TAG = "tag";
    public static final String PROPERTY_OFFSET = "offset";
    public static final String PROPERTY_START_TIME = "startTime";
    public static final String PROPERTY_END_TIME = "endTime";
    public static final String PROPERTY_DURATION = "duration";
    public static final String PROPERTY_REMOTE_INSTANCE = "remoteInstance";
    public static final String PROPERTY_FAILED = "failed";
    public static final String PROPERTY_STATUS = "status";

    private long id;
    private Integer visionHistoryId;
    private Integer cardId;
    private Card sourceCard;
    private String trackId;
    private LocalDate visionDate;
    private String cardPath;
    private String tag;
    private int offset;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
    private Long duration;
    private RemoteInstance remoteInstance;
    private Boolean failed;
    private List<DailyVisionCardStatus> status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getVisionHistoryId() {
        return visionHistoryId;
    }

    public void setVisionHistoryId(Integer visionHistoryId) {
        this.visionHistoryId = visionHistoryId;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Card getSourceCard() {
        return sourceCard;
    }

    public void setSourceCard(Card sourceCard) {
        this.sourceCard = sourceCard;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public LocalDate getVisionDate() {
        return visionDate;
    }

    public void setVisionDate(LocalDate visionDate) {
        this.visionDate = visionDate;
    }

    public String getCardPath() {
        return cardPath;
    }

    public void setCardPath(String cardPath) {
        this.cardPath = cardPath;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
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

    public Boolean getFailed() {
        return failed;
    }

    public void setFailed(Boolean failed) {
        this.failed = failed;
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
        if (!(o instanceof VisionCardAnomaly))
            return false;
        VisionCardAnomaly that = (VisionCardAnomaly) o;
        return getId() == that.getId() &&
                getOffset() == that.getOffset() &&
                Objects.equals(getVisionHistoryId(), that.getVisionHistoryId()) &&
                Objects.equals(getCardId(), that.getCardId()) &&
                Objects.equals(getSourceCard(), that.getSourceCard()) &&
                Objects.equals(getTrackId(), that.getTrackId()) &&
                Objects.equals(getVisionDate(), that.getVisionDate()) &&
                Objects.equals(getCardPath(), that.getCardPath()) &&
                Objects.equals(getTag(), that.getTag()) &&
                Objects.equals(getStartTime(), that.getStartTime()) &&
                Objects.equals(getEndTime(), that.getEndTime()) &&
                Objects.equals(getDuration(), that.getDuration()) &&
                Objects.equals(getRemoteInstance(), that.getRemoteInstance()) &&
                Objects.equals(getFailed(), that.getFailed()) &&
                Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getVisionHistoryId(), getCardId(), getSourceCard(), getTrackId(), getVisionDate(), getCardPath(), getTag(), getOffset(), getStartTime(), getEndTime(), getDuration(), getRemoteInstance(), getFailed(), getStatus());
    }

    public static class Card {

        public static final String PROPERTY_CARD_ID = "cardId";
        public static final String PROPERTY_VISION_HISTORY_ID = "visionHistoryId";

        private Integer cardId;
        private Integer visionHistoryId;

        public Integer getCardId() {
            return cardId;
        }

        public void setCardId(Integer cardId) {
            this.cardId = cardId;
        }

        public Integer getVisionHistoryId() {
            return visionHistoryId;
        }

        public void setVisionHistoryId(Integer visionHistoryId) {
            this.visionHistoryId = visionHistoryId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Card))
                return false;
            Card card = (Card) o;
            return Objects.equals(getCardId(), card.getCardId()) &&
                    Objects.equals(getVisionHistoryId(), card.getVisionHistoryId());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getCardId(), getVisionHistoryId());
        }
    }
}
