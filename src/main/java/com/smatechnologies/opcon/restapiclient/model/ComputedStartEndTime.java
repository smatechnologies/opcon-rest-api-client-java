package com.smatechnologies.opcon.restapiclient.model;

import java.time.ZonedDateTime;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
public abstract class ComputedStartEndTime extends ComputedTime {

    public static final String PROPERTY_PROGRAMMED_FOR = "programmedFor";
    public static final String PROPERTY_CONSIDERED_LATE_AT = "consideredLateAt";

    private ZonedDateTime programmedFor;
    private ZonedDateTime consideredLateAt;

    public ZonedDateTime getProgrammedFor() {
        return programmedFor;
    }

    public void setProgrammedFor(ZonedDateTime programmedFor) {
        this.programmedFor = programmedFor;
    }

    public ZonedDateTime getConsideredLateAt() {
        return consideredLateAt;
    }

    public void setConsideredLateAt(ZonedDateTime consideredLateAt) {
        this.consideredLateAt = consideredLateAt;
    }

    @Override
    public ComputedStartEndTime clone() {
        ComputedStartEndTime computedTime = (ComputedStartEndTime) super.clone();
        computedTime.setProgrammedFor(programmedFor);
        computedTime.setConsideredLateAt(consideredLateAt);

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
        ComputedStartEndTime that = (ComputedStartEndTime) o;
        return Objects.equals(programmedFor, that.programmedFor) &&
                Objects.equals(consideredLateAt, that.consideredLateAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), programmedFor, consideredLateAt);
    }
}
