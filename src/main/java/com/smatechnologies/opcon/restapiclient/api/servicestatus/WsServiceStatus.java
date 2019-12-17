package com.smatechnologies.opcon.restapiclient.api.servicestatus;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.ServiceStatus;


/**
 * @author Pierre PINON
 */
public class WsServiceStatus {

    private final WsFactory wsFactory;

    public WsServiceStatus(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("servicestatus");
    }

    public ServiceStatus get() throws WsException {
        return wsFactory.create(Ws.Type.GET).run(ServiceStatus.class);
    }
}
