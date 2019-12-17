package com.smatechnologies.opcon.restapiclient.api.visionstatistic;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.visionstatistic.VisionStatistic;

import javax.ws.rs.core.GenericType;


/**
 * @author Matthieu COELHO
 */
public class WsVisionStatistic {

    private final WsFactory wsFactory;

    public WsVisionStatistic(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("visionStatistic");
    }

    public VisionStatistic get(VisionStatisticCriteria criteria) throws WsException {
        return wsFactory
                .create(Ws.Type.GET)
                .criteria(criteria)
                .run(new GenericType<VisionStatistic>() {

                });
    }

    public int count(VisionStatisticCriteria criteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(criteria).count();
    }
}
