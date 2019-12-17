package com.smatechnologies.opcon.restapiclient.api.schedulebuildrequests;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.ScheduleBuildRequest;

import javax.ws.rs.core.GenericType;
import java.util.List;
import java.util.Objects;


public class WsScheduleBuildRequests {

    private final WsFactory wsFactory;

    public WsScheduleBuildRequests(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("scheduleBuildRequests");
    }

    public List<ScheduleBuildRequest> get() throws WsException {
        return wsFactory.checkVersion("19.1.0", null).create(Ws.Type.GET).run(new GenericType<List<ScheduleBuildRequest>>() {

        });
    }

    public ScheduleBuildRequest get(int scheduleBuildRequestId) throws WsException {
        return wsFactory.checkVersion("19.1.0", null).create(Ws.Type.GET).path(String.valueOf(scheduleBuildRequestId)).run(ScheduleBuildRequest.class);
    }

    public ScheduleBuildRequest post(ScheduleBuildRequest scheduleBuildRequest) throws WsException {
        Objects.requireNonNull(scheduleBuildRequest, "ScheduleAction cannot be null");

        return wsFactory.checkVersion("19.1.0", null).create(Ws.Type.POST, scheduleBuildRequest).run(ScheduleBuildRequest.class);
    }
}
