package com.smatechnologies.opcon.restapiclient.api.visionactions;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.api.visionfrequencies.VisionFrequenciesCriteria;
import com.smatechnologies.opcon.restapiclient.model.VisionAction;

import javax.ws.rs.core.GenericType;
import java.util.List;
import java.util.Objects;


/**
 * @author Matthieu COELHO
 */
public class WsVisionActions {

    private final WsFactory wsFactory;

    public WsVisionActions(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("visionActions");
    }

    public List<VisionAction> get(VisionActionsCriteria criteria) throws WsException {
        return wsFactory
                .create(Ws.Type.GET)
                .criteria(criteria)
                .run(new GenericType<List<VisionAction>>() {

                });
    }

    public int count(VisionFrequenciesCriteria criteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(criteria).count();
    }

    public VisionAction post(VisionAction visionAction) throws WsException {
        Objects.requireNonNull(visionAction, "VisionAction cannot be null");
        return wsFactory.create(Ws.Type.POST, visionAction).run(VisionAction.class);
    }

    public VisionAction put(VisionAction visionAction) throws WsException {
        Objects.requireNonNull(visionAction, "VisionAction cannot be null");
        return wsFactory.create(Ws.Type.PUT, visionAction).path(String.valueOf(visionAction.getId())).run(VisionAction.class);
    }

    public void delete(VisionAction visionAction) throws WsException {
        Objects.requireNonNull(visionAction, "VisionAction cannot be null");
        wsFactory.create(Ws.Type.DELETE).path(String.valueOf(visionAction.getId())).run(VisionAction.class);
    }
}
