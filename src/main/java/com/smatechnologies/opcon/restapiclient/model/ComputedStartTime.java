package com.smatechnologies.opcon.restapiclient.model;

import java.time.ZonedDateTime;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class ComputedStartTime extends ComputedStartEndTime {

    public static final String PROPERTY_LATEST_START = "latestStart";

    private ZonedDateTime latestStart;

    public ZonedDateTime getLatestStart() {
        return latestStart;
    }

    public void setLatestStart(ZonedDateTime latestStart) {
        this.latestStart = latestStart;
    }

    @Override
    public ComputedStartTime clone() {
        ComputedStartTime computedTime = (ComputedStartTime) super.clone();
        computedTime.setLatestStart(latestStart);

        return computedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        ComputedStartTime that = (ComputedStartTime) o;
        return Objects.equals(latestStart, that.latestStart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), latestStart);
    }
}
