package com.smatechnologies.opcon.restapiclient.model;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;


/**
 * @author Francois EYL
 */
public class ComputedTime implements Cloneable {

    public static final String RESOURCE = "computedTime";

    public static final String PROPERTY_TIME = "time";
    public static final String PROPERTY_IS_ESTIMATED = "isEstimated";

    private ZonedDateTime time;
    private Boolean isEstimated;

    public ZonedDateTime getTime() {
        return time;
    }

    public void setTime(ZonedDateTime time) {
        this.time = time;
    }

    public Boolean getIsEstimated() {
        return isEstimated;
    }

    public void setIsEstimated(Boolean estimated) {
        this.isEstimated = estimated;
    }

    public ComputedTime truncatedToMinute() {
        ComputedTime truncatedComputedTime = new ComputedTime();
        truncatedComputedTime.setIsEstimated(isEstimated);
        truncatedComputedTime.setTime(Optional.ofNullable(time)
                .map(dateTime -> dateTime.truncatedTo(ChronoUnit.MINUTES))
                .orElse(null));

        return truncatedComputedTime;
    }

    @Override
    public ComputedTime clone() {
        try {
            ComputedTime computedTime = (ComputedTime) super.clone();
            computedTime.setIsEstimated(isEstimated);
            computedTime.setTime(time);

            return computedTime;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e); //Shouldn't never happen
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ComputedTime that = (ComputedTime) o;

        if (time != null ? !time.equals(that.time) : that.time != null)
            return false;
        return isEstimated != null ? isEstimated.equals(that.isEstimated) : that.isEstimated == null;

    }

    @Override
    public int hashCode() {
        int result = time != null ? time.hashCode() : 0;
        result = 31 * result + (isEstimated != null ? isEstimated.hashCode() : 0);
        return result;
    }
}
