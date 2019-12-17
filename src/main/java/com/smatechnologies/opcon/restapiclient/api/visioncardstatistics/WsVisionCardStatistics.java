package com.smatechnologies.opcon.restapiclient.api.visioncardstatistics;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.visionstatistic.VisionCardStatistic;

import javax.ws.rs.core.GenericType;
import java.util.List;


/**
 * @author Matthieu COELHO
 */
public class WsVisionCardStatistics {

    private final WsFactory wsFactory;

    public WsVisionCardStatistics(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("visionCardStatistics");
    }

    public List<VisionCardStatistic> get(VisionCardStatisticsCriteria criteria) throws WsException {
        return wsFactory
                .create(Ws.Type.GET)
                .criteria(criteria)
                .run(new GenericType<List<VisionCardStatistic>>() {

                });
    }

    public int count(VisionCardStatisticsCriteria criteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(criteria).count();
    }
}
