package com.smatechnologies.opcon.restapiclient.model.dailyvisioncard;

import com.smatechnologies.opcon.restapiclient.model.ComputedDuration;
import com.smatechnologies.opcon.restapiclient.model.ComputedTime;

import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class DailyVisionCardStats {

    public static final String RESOURCE = "stats";

    public static final String PROPERTY_WAITING_COUNT = "waitingCount";
    public static final String PROPERTY_RUNNING_COUNT = "runningCount";
    public static final String PROPERTY_FAILED_COUNT = "failedCount";
    public static final String PROPERTY_FINISHED_OK_COUNT = "finishedOkCount";
    public static final String PROPERTY_NOT_RUN_COUNT = "notRunCount";
    public static final String PROPERTY_COMPUTED_START = "computedStart";
    public static final String PROPERTY_COMPUTED_END = "computedEnd";
    public static final String PROPERTY_COMPUTED_DURATION = "computedDuration";

    private Integer waitingCount;
    private Integer runningCount;
    private Integer failedCount;
    private Integer finishedOkCount;
    private Integer notRunCount;
    private ComputedTime computedStart;
    private ComputedTime computedEnd;
    private ComputedDuration computedDuration;

    public Integer getWaitingCount() {
        return waitingCount;
    }

    public void setWaitingCount(Integer waitingCount) {
        this.waitingCount = waitingCount;
    }

    public Integer getRunningCount() {
        return runningCount;
    }

    public void setRunningCount(Integer runningCount) {
        this.runningCount = runningCount;
    }

    public Integer getFailedCount() {
        return failedCount;
    }

    public void setFailedCount(Integer failedCount) {
        this.failedCount = failedCount;
    }

    public Integer getFinishedOkCount() {
        return finishedOkCount;
    }

    public void setFinishedOkCount(Integer finishedOkCount) {
        this.finishedOkCount = finishedOkCount;
    }

    public Integer getNotRunCount() {
        return notRunCount;
    }

    public void setNotRunCount(Integer notRunCount) {
        this.notRunCount = notRunCount;
    }

    public ComputedTime getComputedStart() {
        return computedStart;
    }

    public void setComputedStart(ComputedTime computedStart) {
        this.computedStart = computedStart;
    }

    public ComputedTime getComputedEnd() {
        return computedEnd;
    }

    public void setComputedEnd(ComputedTime computedEnd) {
        this.computedEnd = computedEnd;
    }

    public ComputedDuration getComputedDuration() {
        return computedDuration;
    }

    public void setComputedDuration(ComputedDuration computedDuration) {
        this.computedDuration = computedDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DailyVisionCardStats that = (DailyVisionCardStats) o;
        return Objects.equals(waitingCount, that.waitingCount) &&
                Objects.equals(runningCount, that.runningCount) &&
                Objects.equals(failedCount, that.failedCount) &&
                Objects.equals(finishedOkCount, that.finishedOkCount) &&
                Objects.equals(notRunCount, that.notRunCount) &&
                Objects.equals(computedStart, that.computedStart) &&
                Objects.equals(computedEnd, that.computedEnd) &&
                Objects.equals(computedDuration, that.computedDuration);
    }

    @Override
    public int hashCode() {

        return Objects.hash(waitingCount, runningCount, failedCount, finishedOkCount, notRunCount, computedStart, computedEnd, computedDuration);
    }
}
