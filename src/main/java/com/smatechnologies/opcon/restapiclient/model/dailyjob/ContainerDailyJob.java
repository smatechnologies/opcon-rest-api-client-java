package com.smatechnologies.opcon.restapiclient.model.dailyjob;

import com.smatechnologies.opcon.restapiclient.model.dailyjob.details.ContainerDetails;

import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class ContainerDailyJob extends DailyJob {

    public static final String PROPERTY_DETAILS = "details";

    private ContainerDetails details;

    public ContainerDetails getDetails() {
        return details;
    }

    public void setDetails(ContainerDetails details) {
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
        ContainerDailyJob that = (ContainerDailyJob) o;
        return Objects.equals(details, that.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), details);
    }
}
