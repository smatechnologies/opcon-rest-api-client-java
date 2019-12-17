package com.smatechnologies.opcon.restapiclient.model.dailyjob;

import com.smatechnologies.opcon.restapiclient.model.dailyjob.details.UNIXDetails;

import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class UNIXDailyJob extends DailyJob {

    public static final String PROPERTY_DETAILS = "details";

    private UNIXDetails details;

    public UNIXDetails getDetails() {
        return details;
    }

    public void setDetails(UNIXDetails details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        UNIXDailyJob that = (UNIXDailyJob) o;
        return Objects.equals(details, that.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), details);
    }
}
