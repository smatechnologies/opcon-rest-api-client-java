package com.smatechnologies.opcon.restapiclient.api.servicerequestexecutions;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.restapiclient.criteria.AbstractResourcesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.SortedColumn;
import com.smatechnologies.opcon.restapiclient.model.ServiceRequestExecution;

import java.util.Collection;
import java.util.Date;


/**
 * @author Pierre PINON
 */
public class ServiceRequestExecutionsCriteria extends AbstractResourcesCriteria<ServiceRequestExecutionsCriteria.ServiceRequestExecutionColumns> {

    @ObjMapperField
    private Collection<Integer> ids;
    @ObjMapperField
    private Boolean includeServiceRequests;
    @ObjMapperField
    private Boolean includeUsers;
    @ObjMapperField
    private Boolean includeOpconRequests;
    @ObjMapperField
    private Boolean includeOpconResponses;
    @ObjMapperField
    private String serviceRequestName;
    @ObjMapperField
    private Collection<ServiceRequestExecution.ExecutionStatus> executionStatuses;
    @ObjMapperField
    private String loginName;
    @ObjMapperField
    private Date lastUpdateLessThan;
    @ObjMapperField
    private Collection<Integer> serviceRequestIds;

    public Collection<Integer> getIds() {
        return ids;
    }

    public void setIds(Collection<Integer> ids) {
        this.ids = ids;
    }

    public Boolean isIncludeServiceRequests() {
        return includeServiceRequests;
    }

    public void setIncludeServiceRequests(Boolean includeServiceRequests) {
        this.includeServiceRequests = includeServiceRequests;
    }

    public Boolean isIncludeUsers() {
        return includeUsers;
    }

    public void setIncludeUsers(Boolean includeUsers) {
        this.includeUsers = includeUsers;
    }

    public Boolean isIncludeOpconRequests() {
        return includeOpconRequests;
    }

    public void setIncludeOpconRequests(Boolean includeOpconRequests) {
        this.includeOpconRequests = includeOpconRequests;
    }

    public Boolean isIncludeOpconResponses() {
        return includeOpconResponses;
    }

    public void setIncludeOpconResponses(Boolean includeOpconResponses) {
        this.includeOpconResponses = includeOpconResponses;
    }

    public String getServiceRequestName() {
        return serviceRequestName;
    }

    public void setServiceRequestName(String serviceRequestName) {
        this.serviceRequestName = serviceRequestName;
    }

    public Collection<ServiceRequestExecution.ExecutionStatus> getExecutionStatuses() {
        return executionStatuses;
    }

    public void setExecutionStatuses(Collection<ServiceRequestExecution.ExecutionStatus> executionStatuses) {
        this.executionStatuses = executionStatuses;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Date getLastUpdateLessThan() {
        return lastUpdateLessThan;
    }

    public void setLastUpdateLessThan(Date lastUpdateLessThan) {
        this.lastUpdateLessThan = lastUpdateLessThan;
    }

    public Collection<Integer> setServiceRequestIds() {
        return serviceRequestIds;
    }

    public void setServiceRequestIds(Collection<Integer> serviceRequestIds) {
        this.serviceRequestIds = serviceRequestIds;
    }

    /**
     * Allowed columns on ServiceRequestExecutions to specify sort order.
     *
     * @author Pierre PINON.
     */
    public enum ServiceRequestExecutionColumns implements SortedColumn.Column {

        ID("id"),
        SERVICE_REQUEST_ID("servicerequestid"),
        SERVICE_REQUEST_NAME("servicerequestname"),
        EXECUTION_STATUS("executionstatus"),
        LOGIN_NAME("loginname");

        private String name;

        ServiceRequestExecutionColumns(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }
    }
}
