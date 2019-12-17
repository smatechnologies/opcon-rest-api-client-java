package com.smatechnologies.opcon.restapiclient.api.scheduleactions;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.ScheduleAction;

import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class WsScheduleActions {

    private final WsFactory wsFactory;

    public WsScheduleActions(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("scheduleactions");
    }

    public ScheduleAction get(int scheduleActionId) throws WsException {
        return wsFactory.create(Ws.Type.GET).path(String.valueOf(scheduleActionId)).run(ScheduleAction.class);
    }

    public ScheduleAction post(ScheduleAction scheduleAction) throws WsException {
        Objects.requireNonNull(scheduleAction, "ScheduleAction cannot be null");

        return wsFactory.create(Ws.Type.POST, scheduleAction).run(ScheduleAction.class);
    }
}
