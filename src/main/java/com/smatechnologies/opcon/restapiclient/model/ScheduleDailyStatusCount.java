package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


/**
 * @author Francois EYL
 */
public class ScheduleDailyStatusCount {

    public static final String RESOURCE = "dailyStatusCount";

    public static final String PROPERTY_FAILED = "failed";
    public static final String PROPERTY_FINISHED_OK = "finishedOk";
    public static final String PROPERTY_HELD = "held";
    public static final String PROPERTY_RUNNING = "running";
    public static final String PROPERTY_WAITING = "waiting";

    private int failed = 0;

    @JsonProperty("finishedok")
    private int finishedOk = 0;

    private int held = 0;

    private int running = 0;

    private int waiting = 0;

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

    public int getRunning() {
        return running;
    }

    public void setRunning(int running) {
        this.running = running;
    }

    public int getWaiting() {
        return waiting;
    }

    public void setWaiting(int waiting) {
        this.waiting = waiting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ScheduleDailyStatusCount that = (ScheduleDailyStatusCount) o;
        return failed == that.failed &&
                finishedOk == that.finishedOk &&
                held == that.held &&
                running == that.running &&
                waiting == that.waiting;
    }

    @Override
    public int hashCode() {

        return Objects.hash(failed, finishedOk, held, running, waiting);
    }
}
