package com.smatechnologies.opcon.restapiclient.api.visionjobanomalies;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.VisionJobAnomaly;

import javax.ws.rs.core.GenericType;
import java.util.List;


/**
 * @author Matthieu COELHO
 */
public class WsVisionJobAnomalies {

    private final WsFactory wsFactory;

    public WsVisionJobAnomalies(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("visionJobAnomalies");
    }

    public List<VisionJobAnomaly> get(VisionJobAnomaliesCriteria criteria) throws WsException {
        return wsFactory
                .create(Ws.Type.GET)
                .criteria(criteria)
                .run(new GenericType<List<VisionJobAnomaly>>() {

                });
    }

    public int count(VisionJobAnomaliesCriteria criteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(criteria).count();
    }
}
