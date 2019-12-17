package com.smatechnologies.opcon.restapiclient.api.jobinstanceactions;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.JobInstanceAction;

import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class WsJobInstanceActions {

    private final WsFactory wsFactory;

    public WsJobInstanceActions(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("jobinstanceactions");
    }

    public JobInstanceAction get(int jobInstanceActionId) throws WsException {
        return wsFactory.create(Ws.Type.GET).path(String.valueOf(jobInstanceActionId)).run(JobInstanceAction.class);
    }

    public JobInstanceAction post(JobInstanceAction jobInstanceAction) throws WsException {
        Objects.requireNonNull(jobInstanceAction, "JobInstanceAction cannot be null");

        return wsFactory.create(Ws.Type.POST, jobInstanceAction).run(JobInstanceAction.class);
    }
}
