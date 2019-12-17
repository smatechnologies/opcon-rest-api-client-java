package com.smatechnologies.opcon.restapiclient.api.accesscodes;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.AccessCode;

import javax.ws.rs.core.GenericType;
import java.util.List;


/**
 * @author Francois EYL
 */
public class WsAccessCodes {

    private final WsFactory wsFactory;

    public WsAccessCodes(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("accesscodes");
    }

    public List<AccessCode> get() throws WsException {
        return wsFactory.create(Ws.Type.GET).run(new GenericType<List<AccessCode>>() {

        });
    }

    public int count(AccessCodesCriteria criteria) throws WsException {
        return get().size();

        /*
        TODO When api will accept Include Count, use  this code;
        if (criteria == null) {
            criteria = new AccessCodesCriteria();
        }
        criteria.setIncludeCount(true);
        criteria.setLimit(0);
        criteria.setOffset(0);

        Ws.Result run = wsFactory.create(Ws.Type.GET).criteria(criteria).run();
        return Integer.parseInt(run.getResponse().getHeaderString(Ws.COUNT_HEADER_KEY));
        */
    }
}
