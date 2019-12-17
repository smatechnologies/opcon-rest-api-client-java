package com.smatechnologies.opcon.restapiclient.model;

import java.util.Date;


/**
 * Resource describing an ServiceStatus.
 *
 * @author Pierre PINON
 */
public class ServiceStatus {

    public static final String RESOURCE = "serviceStatus";

    public static final String PROPERTY_TIME_STAMP = "timeStamp";
    public static final String PROPERTY_RUNNING = "running";

    private Date timeStamp;
    private Boolean running;

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Boolean getRunning() {
        return running;
    }

    public void setRunning(Boolean running) {
        this.running = running;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ServiceStatus that = (ServiceStatus) o;

        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null)
            return false;
        return running != null ? running.equals(that.running) : that.running == null;
    }

    @Override
    public int hashCode() {
        int result = timeStamp != null ? timeStamp.hashCode() : 0;
        result = 31 * result + (running != null ? running.hashCode() : 0);
        return result;
    }
}
