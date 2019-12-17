package com.smatechnologies.opcon.restapiclient.api.version;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.Version;


/**
 * @author Pierre PINON
 */
public class WsVersion {

    private final WsFactory wsFactory;

    public WsVersion(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("version");
    }

    public Version get() throws WsException {
        return wsFactory.create(Ws.Type.GET).token(false).run(Version.class);
    }
}
