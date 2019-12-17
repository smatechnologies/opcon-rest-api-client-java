package com.smatechnologies.opcon.restapiclient.api.visioncardanomalies;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.VisionCardAnomaly;

import javax.ws.rs.core.GenericType;
import java.util.List;


/**
 * @author Matthieu COELHO
 */
public class WsVisionCardAnomalies {

    private final WsFactory wsFactory;

    public WsVisionCardAnomalies(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("visionCardAnomalies");
    }

    public List<VisionCardAnomaly> get(VisionCardAnomaliesCriteria criteria) throws WsException {
        return wsFactory
                .create(Ws.Type.GET)
                .criteria(criteria)
                .run(new GenericType<List<VisionCardAnomaly>>() {

                });
    }

    public int count(VisionCardAnomaliesCriteria criteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(criteria).count();
    }
}
