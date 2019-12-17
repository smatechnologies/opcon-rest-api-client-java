package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


/**
 * @author Francois EYL
 */
public class JobDailyStatusCount {

    public static final String RESOURCE = "dailyStatusCount";

    public static final String PROPERTY_CANCELLED = "cancelled";
    public static final String PROPERTY_FAILED = "failed";
    public static final String PROPERTY_FINISHED_OK = "finishedOk";
    public static final String PROPERTY_HELD = "held";
    public static final String PROPERTY_MISSED_START_TIME = "missedStartTime";
    public static final String PROPERTY_RUNNING = "running";
    public static final String PROPERTY_SKIPPED = "skipped";
    public static final String PROPERTY_WAITING = "waiting";
    public static final String PROPERTY_UNDER_REVIEW = "underReview";

    private int cancelled = 0;

    private int failed = 0;

    @JsonProperty("finishedok")
    private int finishedOk = 0;

    private int held = 0;

    @JsonProperty("missedstarttime")
    private int missedStartTime = 0;

    private int running = 0;

    private int skipped = 0;

    private int waiting = 0;

    @JsonProperty("underreview")
    private int underReview = 0;

    private int fixed = 0;

    public int getCancelled() {
        return cancelled;
    }

    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }

    public int getFailed() {
        return failed;
    }

    public void setFailed(int failed) {
        this.failed = failed;
    }

    public int getFinishedOk() {
        return finishedOk;
    }

    public void setFinishedOk(int finishedOk) {
        this.finishedOk = finishedOk;
    }

    public int getHeld() {
        return held;
    }

    public void setHeld(int held) {
        this.held = held;
    }

    public int getMissedStartTime() {
        return missedStartTime;
    }

    public void setMissedStartTime(int missedStartTime) {
        this.missedStartTime = missedStartTime;
    }

    public int getRunning() {
        return running;
    }

    public void setRunning(int running) {
        this.running = running;
    }

    public int getSkipped() {
        return skipped;
    }

    public void setSkipped(int skipped) {
        this.skipped = skipped;
    }

    public int getWaiting() {
        return waiting;
    }

    public void setWaiting(int waiting) {
        this.waiting = waiting;
    }

    public int getUnderReview() {
        return underReview;
    }

    public void setUnderReview(int underReview) {
        this.underReview = underReview;
    }

    public int getFixed() {
        return fixed;
    }

    public void setFixed(int fixed) {
        this.fixed = fixed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        JobDailyStatusCount that = (JobDailyStatusCount) o;
        return cancelled == that.cancelled &&
                failed == that.failed &&
                finishedOk == that.finishedOk &&
                held == that.held &&
                missedStartTime == that.missedStartTime &&
                running == that.running &&
                skipped == that.skipped &&
                waiting == that.waiting &&
                underReview == that.underReview &&
                fixed == that.fixed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cancelled, failed, finishedOk, held, missedStartTime, running, skipped, waiting, underReview, fixed);
    }
}
