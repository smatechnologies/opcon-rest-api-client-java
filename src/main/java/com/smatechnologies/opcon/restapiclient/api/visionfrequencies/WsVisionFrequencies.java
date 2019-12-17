package com.smatechnologies.opcon.restapiclient.api.visionfrequencies;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.VisionFrequency;

import javax.ws.rs.core.GenericType;
import java.util.List;
import java.util.Objects;


/**
 * @author Matthieu COELHO
 */
public class WsVisionFrequencies {

    private final WsFactory wsFactory;

    public WsVisionFrequencies(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("visionFrequencies");
    }

    public List<VisionFrequency> get(VisionFrequenciesCriteria criteria) throws WsException {
        return wsFactory
                .create(Ws.Type.GET)
                .criteria(criteria)
                .run(new GenericType<List<VisionFrequency>>() {

                });
    }

    public int count(VisionFrequenciesCriteria criteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(criteria).count();
    }

    public VisionFrequency post(VisionFrequency visionFrequency) throws WsException {
        Objects.requireNonNull(visionFrequency, "VisionFrequency cannot be null");
        return wsFactory.create(Ws.Type.POST, visionFrequency).run(VisionFrequency.class);
    }

    public VisionFrequency put(VisionFrequency visionFrequency) throws WsException {
        Objects.requireNonNull(visionFrequency, "VisionFrequency cannot be null");
        return wsFactory.create(Ws.Type.PUT, visionFrequency).path(String.valueOf(visionFrequency.getId())).run(VisionFrequency.class);
    }

    public void delete(VisionFrequency visionFrequency) throws WsException {
        Objects.requireNonNull(visionFrequency, "VisionFrequency cannot be null");
        wsFactory.create(Ws.Type.DELETE).path(String.valueOf(visionFrequency.getId())).run(VisionFrequency.class);
    }
}
