package com.smatechnologies.opcon.restapiclient.api.masterjobs;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.MasterJob;

import javax.ws.rs.core.GenericType;
import java.util.List;


/**
 * @author Pierre PINON
 */
public class WsMasterJobs {

    private final WsFactory wsFactory;

    public WsMasterJobs(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("masterjobs");
    }

    public List<MasterJob> get(MasterJobsCriteria masterJobsCriteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(masterJobsCriteria).run(new GenericType<List<MasterJob>>() {

        });
    }

    public int count(MasterJobsCriteria masterJobsCriteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(masterJobsCriteria).count();
    }
}
