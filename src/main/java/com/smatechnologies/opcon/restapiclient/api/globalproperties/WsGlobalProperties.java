package com.smatechnologies.opcon.restapiclient.api.globalproperties;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.GlobalProperty;

import javax.ws.rs.core.GenericType;
import java.util.List;
import java.util.Objects;


public class WsGlobalProperties {

    private final WsFactory wsFactory;

    public WsGlobalProperties(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("globalproperties");
    }

    public List<GlobalProperty> get(GlobalPropertiesCriteria criteria) throws WsException {
        return wsFactory.create(Ws.Type.GET)
                .criteria(criteria)
                .run(new GenericType<List<GlobalProperty>>() {

                });
    }

    public int count(GlobalPropertiesCriteria criteria) throws WsException {
        if (criteria == null) {
            criteria = new GlobalPropertiesCriteria();
        }
        criteria.setIncludeCount(true);
        criteria.setLimit(0);
        Ws.Result run = wsFactory.create(Ws.Type.GET).criteria(criteria).run();
        return Integer.parseInt(run.getResponse().getHeaderString(Ws.COUNT_HEADER_KEY));
    }

    public GlobalProperty post(GlobalProperty globalProperty) throws WsException {
        Objects.requireNonNull(globalProperty, "GlobalProperty cannot be null");
        return wsFactory.create(Ws.Type.POST, globalProperty).run(GlobalProperty.class);
    }

    public GlobalProperty put(GlobalProperty globalProperty) throws WsException {
        Objects.requireNonNull(globalProperty, "GlobalProperty cannot be null");
        return wsFactory.create(Ws.Type.PUT, globalProperty).path(String.valueOf(globalProperty.getId())).run(GlobalProperty.class);
    }

    public void delete(String globalPropertyId) throws WsException {
        wsFactory.create(Ws.Type.DELETE).path(String.valueOf(globalPropertyId)).run();
    }
}
