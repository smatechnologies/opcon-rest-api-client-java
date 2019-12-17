package com.smatechnologies.opcon.restapiclient.api.jobhistories;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.JobHistory;

import javax.ws.rs.core.GenericType;
import java.util.List;


/**
 * @author Matthieu COELHO
 */
public class WsJobHistories {

    private final WsFactory wsFactory;

    public WsJobHistories(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("jobHistories");
    }

    public List<JobHistory> get(JobHistoriesCriteria jobHistoriesCriteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(jobHistoriesCriteria).run(new GenericType<List<JobHistory>>() {

        });
    }
}
