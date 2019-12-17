package com.smatechnologies.opcon.restapiclient.api.servicerequestexecutions;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperValue;
import com.smatechnologies.opcon.restapiclient.criteria.AbstractResourcesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.SortedColumn;

import java.util.Collection;


/**
 * @author Pierre PINON
 */
public class ServiceRequestExecutionsStatusCountCriteria extends AbstractResourcesCriteria<ServiceRequestExecutionsStatusCountCriteria.ServiceRequestExecutionsStatusCountColumns> {

    @ObjMapperField
    private GroupBy groupBy;
    @ObjMapperField
    private Collection<Integer> serviceRequestIds;

    public GroupBy getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(GroupBy groupBy) {
        this.groupBy = groupBy;
    }

    public Collection<Integer> getServiceRequestIds() {
        return serviceRequestIds;
    }

    public void setServiceRequestIds(Collection<Integer> serviceRequestIds) {
        this.serviceRequestIds = serviceRequestIds;
    }

    public enum GroupBy {
        SERVICE_REQUEST_ID("serviceRequestId");

        private final String value;

        GroupBy(String name) {
            this.value = name;
        }

        @ObjMapperValue
        public String value() {
            return value;
        }
    }

    /**
     * Allowed columns on ServiceRequestExecutionsStatusCount to specify sort order.
     *
     * @author Pierre PINON.
     */
    public enum ServiceRequestExecutionsStatusCountColumns implements SortedColumn.Column {
        ;

        private String name;

        ServiceRequestExecutionsStatusCountColumns(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }
    }
}
