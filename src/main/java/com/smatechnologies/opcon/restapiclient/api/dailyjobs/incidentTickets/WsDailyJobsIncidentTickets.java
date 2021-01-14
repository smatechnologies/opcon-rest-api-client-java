package com.smatechnologies.opcon.restapiclient.api.dailyjobs.incidentTickets;

import java.util.List;
import java.util.Objects;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.dailyjob.IncidentTicketDailyJob;

import javax.ws.rs.core.GenericType;

public class WsDailyJobsIncidentTickets {

    private final WsFactory wsFactory;

    public WsDailyJobsIncidentTickets(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("incidentTickets");
    }

    public List<IncidentTicketDailyJob> get() throws WsException {
        return wsFactory.create(Ws.Type.GET).run(new GenericType<List<IncidentTicketDailyJob>>() {
        });
    }

    public IncidentTicketDailyJob put(IncidentTicketDailyJob incidentTicketDailyJob) throws WsException {
        Objects.requireNonNull(incidentTicketDailyJob, "IncidentTicketDailyJob cannot be null");
        String id = Objects.requireNonNull(incidentTicketDailyJob.getId(), "Id cannot be null");

        return wsFactory.create(Ws.Type.PUT, incidentTicketDailyJob).path(id).run(IncidentTicketDailyJob.class);
    }

    public IncidentTicketDailyJob post(IncidentTicketDailyJob incidentTicketDailyJob) throws WsException {
        Objects.requireNonNull(incidentTicketDailyJob, "IncidentTicketDailyJob cannot be null");

        return wsFactory.create(Ws.Type.POST, incidentTicketDailyJob).run(IncidentTicketDailyJob.class);
    }

}
