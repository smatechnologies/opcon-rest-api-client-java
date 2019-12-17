package com.smatechnologies.opcon.restapiclient.api.servicerequestexecutions;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.ServiceRequestExecution;
import com.smatechnologies.opcon.restapiclient.model.ServiceRequestExecutionStatusCount;

import javax.ws.rs.core.GenericType;
import java.util.List;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class WsServiceRequestExecutions {

    private final WsFactory wsFactory;

    public WsServiceRequestExecutions(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("servicerequestexecutions");
    }

    public List<ServiceRequestExecution> get(ServiceRequestExecutionsCriteria serviceRequestExecutionsCriteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(serviceRequestExecutionsCriteria).run(new GenericType<List<ServiceRequestExecution>>() {

        });
    }

    public ServiceRequestExecution get(int ServiceRequestExecutionId) throws WsException {
        return wsFactory.create(Ws.Type.GET).path(String.valueOf(ServiceRequestExecutionId)).run(ServiceRequestExecution.class);
    }

    public ServiceRequestExecution post(ServiceRequestExecution serviceRequestExecution) throws WsException {
        Objects.requireNonNull(serviceRequestExecution, "ServiceRequestExecution cannot be null");

        return wsFactory.create(Ws.Type.POST, serviceRequestExecution).run(ServiceRequestExecution.class);
    }

    public ServiceRequestExecution put(ServiceRequestExecution serviceRequestExecution) throws WsException {
        Objects.requireNonNull(serviceRequestExecution, "ServiceRequestExecution cannot be null");
        int id = Objects.requireNonNull(serviceRequestExecution.getId(), "Id cannot be null");

        return wsFactory.create(Ws.Type.PUT, serviceRequestExecution).path(String.valueOf(id)).run(ServiceRequestExecution.class);
    }

    public void delete(int serviceRequestExecutionId) throws WsException {
        wsFactory.create(Ws.Type.DELETE).path(String.valueOf(serviceRequestExecutionId)).run();
    }

    public List<ServiceRequestExecutionStatusCount> countByStatus(ServiceRequestExecutionsStatusCountCriteria criteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).path("count_by_status").criteria(criteria).run(new GenericType<List<ServiceRequestExecutionStatusCount>>() {

        });
    }
}
