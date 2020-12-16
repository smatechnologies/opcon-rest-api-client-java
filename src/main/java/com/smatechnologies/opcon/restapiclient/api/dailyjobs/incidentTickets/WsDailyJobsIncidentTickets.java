package com.smatechnologies.opcon.restapiclient.api.dailyjobs.incidentTickets;

import java.util.List;
import java.util.Objects;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.dailyjob.details.IncidentTicketDetails;

import javax.ws.rs.core.GenericType;

public class WsDailyJobsIncidentTickets {

    private final WsFactory wsFactory;

    public WsDailyJobsIncidentTickets(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("incidentTickets");
    }

    public List<IncidentTicketDetails> get() throws WsException {
        return wsFactory.create(Ws.Type.GET).run(new GenericType<List<IncidentTicketDetails>>() {
        });
    }

    public IncidentTicketDetails put(IncidentTicketDetails incidentTicketDetails) throws WsException {
        Objects.requireNonNull(incidentTicketDetails, "IncidentTicketDetails cannot be null");
        String id = Objects.requireNonNull(incidentTicketDetails.getId(), "Id cannot be null");

        return wsFactory.create(Ws.Type.PUT, incidentTicketDetails).path(id).run(IncidentTicketDetails.class);
    }

}
