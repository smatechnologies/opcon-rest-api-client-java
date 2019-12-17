package com.smatechnologies.opcon.restapiclient.api.scheduleactionsbydate;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.ScheduleActionsByDate;

import java.util.Objects;


public class WsScheduleActionsByDate {

    private final WsFactory wsFactory;

    public WsScheduleActionsByDate(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("scheduleActionsByDate");
    }

    public ScheduleActionsByDate get(int scheduleActionsByDateId) throws WsException {
        return wsFactory.create(Ws.Type.GET).path(String.valueOf(scheduleActionsByDateId)).run(ScheduleActionsByDate.class);
    }

    public ScheduleActionsByDate post(ScheduleActionsByDate scheduleActionsByDate) throws WsException {
        Objects.requireNonNull(scheduleActionsByDate, "ScheduleAction cannot be null");

        return wsFactory.create(Ws.Type.POST, scheduleActionsByDate).run(ScheduleActionsByDate.class);
    }
}
