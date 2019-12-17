package com.smatechnologies.opcon.restapiclient.api.schedulebuildrequestlogs;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.ScheduleBuildRequestLog;

import javax.ws.rs.core.GenericType;
import java.util.List;


public class WsScheduleBuildRequestLogs {

    private final WsFactory wsFactory;

    public WsScheduleBuildRequestLogs(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("scheduleBuildRequestLogs");
    }

    public List<ScheduleBuildRequestLog> get() throws WsException {
        return wsFactory.create(Ws.Type.GET).run(new GenericType<List<ScheduleBuildRequestLog>>() {

        });
    }

    public ScheduleBuildRequestLog get(int scheduleBuildRequestLogId) throws WsException {
        return wsFactory.create(Ws.Type.GET).path(String.valueOf(scheduleBuildRequestLogId)).run(ScheduleBuildRequestLog.class);
    }

}
