package com.smatechnologies.opcon.restapiclient.model.servicerequestexecution;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


/**
 * @author Pierre PINON
 */
@XmlRootElement(name = "details")
@XmlAccessorType(XmlAccessType.FIELD)
public class ServiceRequestExecutionDetails {

    public static final String PROPERTY_TRACK_EVENT_EXECUTIONS = "trackEventExecutions";
    public static final String PROPERTY_EVENT_EXECUTIONS = "eventExecution";
    public static final String PROPERTY_COMPLETED_COUNT = "completedCount";
    public static final String PROPERTY_TOTAL_COUNT = "totalCount";

    private Boolean trackEventExecutions;

    @XmlElementWrapper(name = "eventExecutions")
    @XmlElement(name = "eventExecution")
    private List<EventExecution> eventExecutions;

    private Integer completedCount;
    private Integer totalCount;

    public Boolean isTrackEventExecutions() {
        return trackEventExecutions;
    }

    public void setTrackEventExecutions(Boolean trackEventExecutions) {
        this.trackEventExecutions = trackEventExecutions;
    }

    public List<EventExecution> getEventExecutions() {
        return eventExecutions;
    }

    public void setEventExecutions(List<EventExecution> eventExecution) {
        this.eventExecutions = eventExecution;
    }

    public Integer getCompletedCount() {
        return completedCount;
    }

    public void setCompletedCount(Integer completedCount) {
        this.completedCount = completedCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ServiceRequestExecutionDetails that = (ServiceRequestExecutionDetails) o;

        if (trackEventExecutions != null ? !trackEventExecutions.equals(that.trackEventExecutions) : that.trackEventExecutions != null)
            return false;
        if (eventExecutions != null ? !eventExecutions.equals(that.eventExecutions) : that.eventExecutions != null)
            return false;
        if (completedCount != null ? !completedCount.equals(that.completedCount) : that.completedCount != null)
            return false;
        return totalCount != null ? totalCount.equals(that.totalCount) : that.totalCount == null;

    }

    @Override
    public int hashCode() {
        int result = trackEventExecutions != null ? trackEventExecutions.hashCode() : 0;
        result = 31 * result + (eventExecutions != null ? eventExecutions.hashCode() : 0);
        result = 31 * result + (completedCount != null ? completedCount.hashCode() : 0);
        result = 31 * result + (totalCount != null ? totalCount.hashCode() : 0);
        return result;
    }

    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class EventExecution {

        public static final String PROPERTY_STATUS = "status";
        public static final String PROPERTY_COMMAND = "command";
        public static final String PROPERTY_MESSAGE = "message";
        public static final String PROPERTY_EVENT_DETAILS = "eventDetails";

        private Status status;
        private String command;
        private String message;
        @XmlElementRefs({
                @XmlElementRef(name = "jobEventDetails", type = JobEventDetails.class)
        })
        private IEventDetails eventDetails;

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }

        public String getCommand() {
            return command;
        }

        public void setCommand(String command) {
            this.command = command;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public IEventDetails getEventDetails() {
            return eventDetails;
        }

        public void setEventDetails(IEventDetails eventDetails) {
            this.eventDetails = eventDetails;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            EventExecution that = (EventExecution) o;

            if (status != that.status)
                return false;
            if (command != null ? !command.equals(that.command) : that.command != null)
                return false;
            if (message != null ? !message.equals(that.message) : that.message != null)
                return false;
            return eventDetails != null ? eventDetails.equals(that.eventDetails) : that.eventDetails == null;

        }

        @Override
        public int hashCode() {
            int result = status != null ? status.hashCode() : 0;
            result = 31 * result + (command != null ? command.hashCode() : 0);
            result = 31 * result + (message != null ? message.hashCode() : 0);
            result = 31 * result + (eventDetails != null ? eventDetails.hashCode() : 0);
            return result;
        }

        public enum Status {
            WAITING,
            IN_PROCESS_VALID,
            IN_PROCESS_INVALID,
            COMPLETED_VALID,
            COMPLETED_INVALID
        }

        @XmlRootElement(name = "jobEventDetails")
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class JobEventDetails implements IEventDetails {

            public static final String PROPERTY_JOBS = "jobs";

            @XmlElementWrapper(name = "jobs")
            @XmlElement(name = "job")
            private List<OpconResponseDetails.JobEventResponse.Job> jobs;

            public List<OpconResponseDetails.JobEventResponse.Job> getJobs() {
                return jobs;
            }

            public void setJobs(List<OpconResponseDetails.JobEventResponse.Job> jobs) {
                this.jobs = jobs;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o)
                    return true;
                if (o == null || getClass() != o.getClass())
                    return false;

                JobEventDetails that = (JobEventDetails) o;

                return jobs != null ? jobs.equals(that.jobs) : that.jobs == null;

            }

            @Override
            public int hashCode() {
                return jobs != null ? jobs.hashCode() : 0;
            }
        }

        public interface IEventDetails {

        }
    }
}
