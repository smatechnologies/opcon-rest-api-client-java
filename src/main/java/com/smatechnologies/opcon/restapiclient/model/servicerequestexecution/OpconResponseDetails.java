package com.smatechnologies.opcon.restapiclient.model.servicerequestexecution;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;


/**
 * @author Pierre PINON
 */
@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
public class OpconResponseDetails {

    public static final String RESOURCE = "result";

    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_MESSAGE = "message";
    public static final String PROPERTY_TYPE = "type";
    public static final String PROPERTY_RESPONSE = "response";

    private Status status;
    private String message;
    private String type;
    @XmlElementRefs({
            @XmlElementRef(name = "jobEventResponse", type = JobEventResponse.class)
    })
    private IResponse response;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public IResponse getResponse() {
        return response;
    }

    public void setResponse(IResponse response) {
        this.response = response;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        OpconResponseDetails result = (OpconResponseDetails) o;

        if (status != result.status)
            return false;
        if (message != null ? !message.equals(result.message) : result.message != null)
            return false;
        if (type != null ? !type.equals(result.type) : result.type != null)
            return false;
        return response != null ? response.equals(result.response) : result.response == null;

    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (response != null ? response.hashCode() : 0);
        return result;
    }

    @XmlType(name = "resultStatus")
    public enum Status {
        @XmlEnumValue("success") SUCCESS,
        @XmlEnumValue("failed") FAILED
    }

    @XmlRootElement(name = "jobEventResponse")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class JobEventResponse extends AbstractEventResponse {

        public static final String RESOURCE = "jobEventResponse";

        public static final String PROPERTY_JOBS = "jobs";

        @XmlElementWrapper(name = "jobs")
        @XmlElement(name = "job")
        private List<Job> jobs;

        public List<Job> getJobs() {
            return jobs;
        }

        public void setJobs(List<Job> jobs) {
            this.jobs = jobs;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            if (!super.equals(o))
                return false;

            JobEventResponse that = (JobEventResponse) o;

            return jobs != null ? jobs.equals(that.jobs) : that.jobs == null;

        }

        @Override
        public int hashCode() {
            int result = super.hashCode();
            result = 31 * result + (jobs != null ? jobs.hashCode() : 0);
            return result;
        }

        @XmlRootElement(name = "job")
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class Job {

            public static final String RESOURCE = "job";

            public static final String PROPERTY_ID = "id";
            public static final String PROPERTY_STATUS = "status";
            public static final String PROPERTY_MESSAGE = "message";

            private String id;
            private Status status;
            private String message;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public Status getStatus() {
                return status;
            }

            public void setStatus(Status status) {
                this.status = status;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o)
                    return true;
                if (o == null || getClass() != o.getClass())
                    return false;

                Job job = (Job) o;

                if (id != null ? !id.equals(job.id) : job.id != null)
                    return false;
                if (status != job.status)
                    return false;
                return message != null ? message.equals(job.message) : job.message == null;

            }

            @Override
            public int hashCode() {
                int result = id != null ? id.hashCode() : 0;
                result = 31 * result + (status != null ? status.hashCode() : 0);
                result = 31 * result + (message != null ? message.hashCode() : 0);
                return result;
            }

            @XmlType(name = "jobStatus")
            public enum Status {
                @XmlEnumValue("success") SUCCESS,
                @XmlEnumValue("failed") FAILED
            }
        }
    }

    public static abstract class AbstractEventResponse implements IEventResponse {

        public static final String PROPERTY_COMMAND = "command";

        private String command;

        @Override
        public String getCommand() {
            return command;
        }

        public void setCommand(String command) {
            this.command = command;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            AbstractEventResponse that = (AbstractEventResponse) o;

            return command != null ? command.equals(that.command) : that.command == null;

        }

        @Override
        public int hashCode() {
            return command != null ? command.hashCode() : 0;
        }
    }

    public interface IEventResponse extends IResponse {

        String getCommand();
    }

    public interface IResponse {

    }
}
