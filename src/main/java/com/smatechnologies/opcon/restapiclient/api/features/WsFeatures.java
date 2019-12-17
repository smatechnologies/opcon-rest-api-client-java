package com.smatechnologies.opcon.restapiclient.api.features;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.Feature;

import javax.ws.rs.core.GenericType;
import java.util.List;


/**
 * Web Services proxy for Features.
 *
 * @author Francois EYL
 */
public class WsFeatures {

    private final WsFactory wsFactory;

    public WsFeatures(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("features");
    }

    public List<Feature> get() throws WsException {
        return wsFactory.create(Ws.Type.GET).run(new GenericType<List<Feature>>() {

        });
    }
}
