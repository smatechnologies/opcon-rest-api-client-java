package com.smatechnologies.opcon.restapiclient.api.calendars;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.Calendar;

import javax.ws.rs.core.GenericType;
import java.util.List;
import java.util.Objects;


/**
 * @author Matthieu COELHO
 */
public class WsCalendars {

    private final WsFactory wsFactory;

    public WsCalendars(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("calendars");
    }

    public List<Calendar> get(CalendarsCriteria criteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(criteria).run(new GenericType<List<Calendar>>() {

        });
    }

    public int count(CalendarsCriteria criteria) throws WsException {
        if (criteria == null) {
            criteria = new CalendarsCriteria();
        }
        criteria.setIncludeCount(true);
        criteria.setLimit(0);
        Ws.Result run = wsFactory.create(Ws.Type.GET).criteria(criteria).run();
        return Integer.parseInt(run.getResponse().getHeaderString(Ws.COUNT_HEADER_KEY));
    }

    public Calendar post(Calendar calendar) throws WsException {
        Objects.requireNonNull(calendar, "Calendar cannot be null");
        return wsFactory.create(Ws.Type.POST, calendar).run(Calendar.class);
    }

    public Calendar put(Calendar calendar) throws WsException {
        Objects.requireNonNull(calendar, "Calendar cannot be null");
        return wsFactory.create(Ws.Type.PUT, calendar).path(String.valueOf(calendar.getId())).run(Calendar.class);
    }

    public void delete(String calendarId) throws WsException {
        wsFactory.create(Ws.Type.DELETE).path(String.valueOf(calendarId)).run();
    }
}
