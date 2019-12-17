package com.smatechnologies.opcon.restapiclient.api.servicerequestcategories;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.ServiceRequestCategory;

import javax.ws.rs.core.GenericType;
import java.util.List;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class WsServiceRequestCategories {

    private final WsFactory wsFactory;

    public WsServiceRequestCategories(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("servicerequestcategories");
    }

    public List<ServiceRequestCategory> get(ServiceRequestCategoriesCriteria serviceRequestCategoriesCriteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(serviceRequestCategoriesCriteria).run(new GenericType<List<ServiceRequestCategory>>() {

        });
    }

    public ServiceRequestCategory get(int serviceRequestCategoryId) throws WsException {
        return wsFactory.create(Ws.Type.GET).path(String.valueOf(serviceRequestCategoryId)).run(ServiceRequestCategory.class);
    }

    public ServiceRequestCategory post(ServiceRequestCategory serviceRequestCategory) throws WsException {
        Objects.requireNonNull(serviceRequestCategory, "ServiceRequestCategory cannot be null");

        return wsFactory.create(Ws.Type.POST, serviceRequestCategory).run(ServiceRequestCategory.class);
    }

    public ServiceRequestCategory put(ServiceRequestCategory serviceRequestCategory) throws WsException {
        Objects.requireNonNull(serviceRequestCategory, "ServiceRequestCategory cannot be null");
        int id = Objects.requireNonNull(serviceRequestCategory.getId(), "Id cannot be null");

        return wsFactory.create(Ws.Type.PUT, serviceRequestCategory).path(String.valueOf(id)).run(ServiceRequestCategory.class);
    }

    public void delete(int serviceRequestId) throws WsException {
        wsFactory.create(Ws.Type.DELETE).path(String.valueOf(serviceRequestId)).run();
    }
}
