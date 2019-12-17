package com.smatechnologies.opcon.restapiclient.api.dailyschedules.dates;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;

import javax.ws.rs.core.GenericType;
import java.time.LocalDate;
import java.util.List;


/**
 * @author Pierre PINON
 */
public class WsDates {

    private final WsFactory wsFactory;

    public WsDates(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("dates");
    }

    public List<LocalDate> get() throws WsException {
        return wsFactory.create(Ws.Type.GET).run(new GenericType<List<LocalDate>>() {

        });
    }
}