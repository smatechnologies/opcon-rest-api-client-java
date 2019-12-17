package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperValue;
import com.smatechnologies.opcon.restapiclient.jackson.deserializer.XmlJsonDeserializer;
import com.smatechnologies.opcon.restapiclient.jackson.serializer.XmlJsonSerializer;
import com.smatechnologies.opcon.restapiclient.model.servicerequestexecution.OpconResponseDetails;
import com.smatechnologies.opcon.restapiclient.model.servicerequestexecution.ServiceRequestExecutionDetails;

import java.util.Date;
import java.util.List;


/**
 * @author Pierre PINON
 */
public class ServiceRequestExecution {

    public static final String RESOURCE = "serviceRequestExecution";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_EXECUTION_STATUS = "executionStatus";
    public static final String PROPERTY_DETAILS = "details";
    public static final String PROPERTY_REQUEST_TIME_STAMP = "requestTimeStamp";
    public static final String PROPERTY_LAST_UPDATE_TIME_STAMP = "lastUpdateTimeStamp";
    public static final String PROPERTY_USER = "user";
    public static final String PROPERTY_SUBMIT_AS_OCADM = "submitAsOCADM";
    public static final String PROPERTY_SERVICE_REQUEST = "serviceRequest";
    public static final String PROPERTY_OPCON_REQUESTS = "opconRequests";
    public static final String PROPERTY_OPCON_RESPONSES = "opconResponses";

    private Integer id;
    private ExecutionStatus executionStatus;
    @JsonSerialize(using = XmlJsonSerializer.class)
    @JsonDeserialize(using = XmlJsonDeserializer.class)
    private ServiceRequestExecutionDetails details;
    private Date requestTimeStamp;
    private Date lastUpdateTimeStamp;
    private User user;
    private Boolean submitAsOCADM;
    private ServiceRequest serviceRequest;
    private List<OpconRequest> opconRequests;
    private List<OpconResponse> opconResponses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ExecutionStatus getExecutionStatus() {
        return executionStatus;
    }

    public void setExecutionStatus(ExecutionStatus executionStatus) {
        this.executionStatus = executionStatus;
    }

    public ServiceRequestExecutionDetails getDetails() {
        return details;
    }

    public void setDetails(ServiceRequestExecutionDetails details) {
        this.details = details;
    }

    public Date getRequestTimeStamp() {
        return requestTimeStamp;
    }

    public void setRequestTimeStamp(Date requestTimeStamp) {
        this.requestTimeStamp = requestTimeStamp;
    }

    public Date getLastUpdateTimeStamp() {
        return lastUpdateTimeStamp;
    }

    public void setLastUpdateTimeStamp(Date lastUpdateTimeStamp) {
        this.lastUpdateTimeStamp = lastUpdateTimeStamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getSubmitAsOCADM() {
        return submitAsOCADM;
    }

    public void setSubmitAsOCADM(Boolean submitAsOCADM) {
        this.submitAsOCADM = submitAsOCADM;
    }

    public ServiceRequest getServiceRequest() {
        return serviceRequest;
    }

    public void setServiceRequest(ServiceRequest serviceRequest) {
        this.serviceRequest = serviceRequest;
    }

    public List<OpconResponse> getOpconResponses() {
        return opconResponses;
    }

    public void setOpconResponses(List<OpconResponse> opconResponses) {
        this.opconResponses = opconResponses;
    }

    public List<OpconRequest> getOpconRequests() {
        return opconRequests;
    }

    public void setOpconRequests(List<OpconRequest> opconRequests) {
        this.opconRequests = opconRequests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ServiceRequestExecution that = (ServiceRequestExecution) o;

        if (id != null ? !id.equals(that.id) : that.id != null)
            return false;
        if (executionStatus != that.executionStatus)
            return false;
        if (details != null ? !details.equals(that.details) : that.details != null)
            return false;
        if (requestTimeStamp != null ? !requestTimeStamp.equals(that.requestTimeStamp) : that.requestTimeStamp != null)
            return false;
        if (lastUpdateTimeStamp != null ? !lastUpdateTimeStamp.equals(that.lastUpdateTimeStamp) : that.lastUpdateTimeStamp != null)
            return false;
        if (user != null ? !user.equals(that.user) : that.user != null)
            return false;
        if (submitAsOCADM != null ? !submitAsOCADM.equals(that.submitAsOCADM) : that.submitAsOCADM != null)
            return false;
        if (serviceRequest != null ? !serviceRequest.equals(that.serviceRequest) : that.serviceRequest != null)
            return false;
        if (opconRequests != null ? !opconRequests.equals(that.opconRequests) : that.opconRequests != null)
            return false;
        if (opconResponses != null ? !opconResponses.equals(that.opconResponses) : that.opconResponses != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (executionStatus != null ? executionStatus.hashCode() : 0);
        result = 31 * result + (details != null ? details.hashCode() : 0);
        result = 31 * result + (requestTimeStamp != null ? requestTimeStamp.hashCode() : 0);
        result = 31 * result + (lastUpdateTimeStamp != null ? lastUpdateTimeStamp.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (submitAsOCADM != null ? submitAsOCADM.hashCode() : 0);
        result = 31 * result + (serviceRequest != null ? serviceRequest.hashCode() : 0);
        result = 31 * result + (opconRequests != null ? opconRequests.hashCode() : 0);
        result = 31 * result + (opconResponses != null ? opconResponses.hashCode() : 0);
        return result;
    }

    public enum ExecutionStatus {

        WAITING("Waiting"),
        IN_PROCESS_VALID("In Process Valid"),
        IN_PROCESS_INVALID("In Process Invalid"),
        COMPLETED_VALID("Completed Valid"),
        COMPLETED_INVALID("Completed Invalid"),
        ZOMBIFIED("Zombified");

        private final String value;

        ExecutionStatus(String value) {
            this.value = value;
        }

        @ObjMapperValue
        @JsonValue
        public String value() {
            return value;
        }
    }

    public static class OpconRequest {

        public static final String RESOURCE = "opconRequest";

        public static final String PROPERTY_HANDLER = "handler";
        public static final String PROPERTY_SOURCE_DESCRIPTION = "sourceDescription";
        public static final String PROPERTY_SOURCE_NAME = "sourceName";
        public static final String PROPERTY_TYPE = "type";
        public static final String PROPERTY_DETAILS = "details";

        private String handler;
        private String sourceDescription;
        private String sourceName;
        private String type;
        private String details;

        public String getHandler() {
            return handler;
        }

        public void setHandler(String handler) {
            this.handler = handler;
        }

        public String getSourceDescription() {
            return sourceDescription;
        }

        public void setSourceDescription(String sourceDescription) {
            this.sourceDescription = sourceDescription;
        }

        public String getSourceName() {
            return sourceName;
        }

        public void setSourceName(String sourceName) {
            this.sourceName = sourceName;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            OpconRequest that = (OpconRequest) o;

            if (handler != null ? !handler.equals(that.handler) : that.handler != null)
                return false;
            if (sourceDescription != null ? !sourceDescription.equals(that.sourceDescription) : that.sourceDescription != null)
                return false;
            if (sourceName != null ? !sourceName.equals(that.sourceName) : that.sourceName != null)
                return false;
            if (type != null ? !type.equals(that.type) : that.type != null)
                return false;
            return details != null ? details.equals(that.details) : that.details == null;

        }

        @Override
        public int hashCode() {
            int result = handler != null ? handler.hashCode() : 0;
            result = 31 * result + (sourceDescription != null ? sourceDescription.hashCode() : 0);
            result = 31 * result + (sourceName != null ? sourceName.hashCode() : 0);
            result = 31 * result + (type != null ? type.hashCode() : 0);
            result = 31 * result + (details != null ? details.hashCode() : 0);
            return result;
        }
    }

    public static class OpconResponse {

        public static final String RESOURCE = "opconResponse";

        public static final String PROPERTY_ID = "id";
        public static final String PROPERTY_TYPE = "type";
        public static final String PROPERTY_DETAILS = "details";

        private Long id;
        private Type type;

        @JsonSerialize(using = XmlJsonSerializer.class)
        @JsonDeserialize(using = XmlJsonDeserializer.class)
        private OpconResponseDetails details;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }

        public OpconResponseDetails getDetails() {
            return details;
        }

        public void setDetails(OpconResponseDetails details) {
            this.details = details;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            OpconResponse that = (OpconResponse) o;

            if (id != null ? !id.equals(that.id) : that.id != null)
                return false;
            if (type != that.type)
                return false;
            return details != null ? details.equals(that.details) : that.details == null;

        }

        @Override
        public int hashCode() {
            int result = id != null ? id.hashCode() : 0;
            result = 31 * result + (type != null ? type.hashCode() : 0);
            result = 31 * result + (details != null ? details.hashCode() : 0);
            return result;
        }

        public enum Type {
            VALID("VALID"),
            INVALID("INVALID");

            private final String value;

            Type(String value) {
                this.value = value;
            }

            @JsonValue
            public String value() {
                return value;
            }
        }
    }
}
