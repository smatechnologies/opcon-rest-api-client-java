package com.smatechnologies.opcon.restapiclient.api.servicerequests;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.ServiceRequest;

import javax.ws.rs.core.GenericType;
import java.util.List;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class WsServiceRequests {

    private final WsFactory wsFactory;

    public WsServiceRequests(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("servicerequests");
    }

    public List<ServiceRequest> get(ServiceRequestsCriteria serviceRequestsCriteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(serviceRequestsCriteria).run(new GenericType<List<ServiceRequest>>() {

        });
    }

    public ServiceRequest get(int serviceRequestId) throws WsException {
        return wsFactory.create(Ws.Type.GET).path(String.valueOf(serviceRequestId)).run(ServiceRequest.class);
    }

    public ServiceRequest post(ServiceRequest serviceRequest) throws WsException {
        Objects.requireNonNull(serviceRequest, "ServiceRequest cannot be null");

        return wsFactory.create(Ws.Type.POST, serviceRequest).run(ServiceRequest.class);
    }

    public ServiceRequest put(ServiceRequest serviceRequest) throws WsException {
        Objects.requireNonNull(serviceRequest, "ServiceRequest cannot be null");
        int id = Objects.requireNonNull(serviceRequest.getId(), "Id cannot be null");

        return wsFactory.create(Ws.Type.PUT, serviceRequest).path(String.valueOf(id)).run(ServiceRequest.class);
    }

    public void delete(int serviceRequestId) throws WsException {
        wsFactory.create(Ws.Type.DELETE).path(String.valueOf(serviceRequestId)).run();
    }
}
