package com.smatechnologies.opcon.restapiclient.api.batchusers;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.BatchUser;

import javax.ws.rs.core.GenericType;
import java.util.List;


/**
 * @author Matthieu COELHO
 */
public class WsBatchUsers {

    private final WsFactory wsFactory;

    public WsBatchUsers(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("batchusers");
    }

    public List<BatchUser> get() throws WsException {
        return wsFactory.create(Ws.Type.GET).run(new GenericType<List<BatchUser>>() {

        });
    }

    public List<BatchUser> get(BatchUsersCriteria criteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(criteria).run(new GenericType<List<BatchUser>>() {

        });
    }

    public int count(BatchUsersCriteria criteria) throws WsException {
        if (criteria == null) {
            criteria = new BatchUsersCriteria();
        }
        criteria.setIncludeCount(true);
        criteria.setLimit(0);

        Ws.Result run = wsFactory.create(Ws.Type.GET).criteria(criteria).run();
        return Integer.parseInt(run.getResponse().getHeaderString(Ws.COUNT_HEADER_KEY));
    }
}
