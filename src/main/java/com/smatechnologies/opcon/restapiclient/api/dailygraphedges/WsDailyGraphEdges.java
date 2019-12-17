package com.smatechnologies.opcon.restapiclient.api.dailygraphedges;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.DailyGraphEdge;

import javax.ws.rs.core.GenericType;
import java.util.List;


/**
 * @author Pierre PINON
 */
public class WsDailyGraphEdges {

    private final WsFactory wsFactory;

    public WsDailyGraphEdges(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("dailygraphedges");
    }

    public List<DailyGraphEdge> get(DailyGraphEdgesCriteria criteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(criteria).run(new GenericType<List<DailyGraphEdge>>() {

        });
    }
}
