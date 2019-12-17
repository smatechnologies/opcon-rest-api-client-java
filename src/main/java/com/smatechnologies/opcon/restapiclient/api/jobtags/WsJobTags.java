package com.smatechnologies.opcon.restapiclient.api.jobtags;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.JobTag;

import javax.ws.rs.core.GenericType;
import java.util.List;


/**
 * @author Pierre PINON
 */
public class WsJobTags {

    private final WsFactory wsFactory;

    public WsJobTags(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("jobtags");
    }

    public List<JobTag> get(JobTagCriteria criteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(criteria).run(new GenericType<List<JobTag>>() {

        });
    }
}
