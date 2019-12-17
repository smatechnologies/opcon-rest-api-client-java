package com.smatechnologies.opcon.restapiclient.api.schedulebuilds;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.ScheduleBuild;

import java.util.Objects;


public class WsScheduleBuilds {

    private final WsFactory wsFactory;

    public WsScheduleBuilds(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("scheduleBuilds");
    }

    public ScheduleBuild post(ScheduleBuild scheduleBuild) throws WsException {
        Objects.requireNonNull(scheduleBuild, "ScheduleBuild cannot be null");

        return wsFactory.checkVersion("18.1", null).create(Ws.Type.POST, scheduleBuild).run(ScheduleBuild.class);
    }
}
