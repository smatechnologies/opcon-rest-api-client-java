package com.smatechnologies.opcon.restapiclient.api.resources;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.Resource;

import javax.ws.rs.core.GenericType;
import java.util.List;
import java.util.Objects;


/**
 * @author Matthieu COELHO
 */
public class WsResources {

    private final WsFactory wsFactory;

    public WsResources(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("resources");
    }

    public List<Resource> get(ResourcesCriteria criteria) throws WsException {
        return wsFactory.create(Ws.Type.GET)
                .criteria(criteria)
                .run(new GenericType<List<Resource>>() {

                });
    }

    public int count(ResourcesCriteria criteria) throws WsException {
        if (criteria == null) {
            criteria = new ResourcesCriteria();
        }
        criteria.setIncludeCount(true);
        criteria.setLimit(0);
        Ws.Result run = wsFactory.create(Ws.Type.GET).criteria(criteria).run();
        return Integer.parseInt(run.getResponse().getHeaderString(Ws.COUNT_HEADER_KEY));
    }

    public Resource post(Resource resource) throws WsException {
        Objects.requireNonNull(resource, "Resource cannot be null");
        return wsFactory.create(Ws.Type.POST, resource).run(Resource.class);
    }

    public Resource put(Resource resource) throws WsException {
        Objects.requireNonNull(resource, "Resource cannot be null");
        return wsFactory.create(Ws.Type.PUT, resource).path(String.valueOf(resource.getId())).run(Resource.class);
    }

    public void delete(String ressourceId) throws WsException {
        wsFactory.create(Ws.Type.DELETE).path(String.valueOf(ressourceId)).run();
    }
}
