package com.smatechnologies.opcon.restapiclient.api.jobactions;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.JobAction;

import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class WsJobActions {

    private final WsFactory wsFactory;

    public WsJobActions(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("jobactions");
    }

    public JobAction get(int jobActionId) throws WsException {
        return wsFactory.create(Ws.Type.GET).path(String.valueOf(jobActionId)).run(JobAction.class);
    }

    public JobAction post(JobAction jobAction) throws WsException {
        Objects.requireNonNull(jobAction, "JobAction cannot be null");

        return wsFactory.create(Ws.Type.POST, jobAction).run(JobAction.class);
    }
}
