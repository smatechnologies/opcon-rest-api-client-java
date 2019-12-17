package com.smatechnologies.opcon.restapiclient.model.visionstatistic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Objects;


/**
 * @author Matthieu COELHO
 */
public class ThresholdStatus {

    public static final String PROPERTY_TOLERABLE_THRESHOLD = "tolerableThreshold";
    public static final String PROPERTY_CRITICAL_THRESHOLD = "criticalThreshold";
    public static final String PROPERTY_STATUS = "status";

    private Integer tolerableThreshold;
    private Integer criticalThreshold;
    private Status status;

    public Integer getTolerableThreshold() {
        return tolerableThreshold;
    }

    public void setTolerableThreshold(Integer tolerableThreshold) {
        this.tolerableThreshold = tolerableThreshold;
    }

    public Integer getCriticalThreshold() {
        return criticalThreshold;
    }

    public void setCriticalThreshold(Integer criticalThreshold) {
        this.criticalThreshold = criticalThreshold;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ThresholdStatus))
            return false;
        ThresholdStatus that = (ThresholdStatus) o;
        return Objects.equals(getTolerableThreshold(), that.getTolerableThreshold()) &&
                Objects.equals(getCriticalThreshold(), that.getCriticalThreshold()) &&
                getStatus() == that.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTolerableThreshold(), getCriticalThreshold(), getStatus());
    }

    public enum Status {
        OK(1),
        TOLERABLE(2),
        CRITICAL(3),
        NOT_APPLICABLE(4),
        UNDEFINED(5),
        UNKNOWN(6);

        int value;

        Status(int value) {
            this.value = value;
        }

        @JsonValue
        public int getValue() {
            return value;
        }

        @JsonCreator
        public static Status fromValue(int value) {
            return Arrays.stream(Status.values())
                    .filter(status1 -> status1.value == value)
                    .findFirst().orElse(null);
        }
    }
}
