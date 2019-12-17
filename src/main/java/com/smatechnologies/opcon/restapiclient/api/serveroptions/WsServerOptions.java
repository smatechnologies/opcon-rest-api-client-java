package com.smatechnologies.opcon.restapiclient.api.serveroptions;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.ServerOptions;

import java.util.Objects;


/**
 * Web Services proxy for Server Options.
 *
 * @author Francois EYL
 */
public class WsServerOptions {

    private final WsFactory wsFactory;

    public WsServerOptions(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("serveroptions");
    }

    public ServerOptions get() throws WsException {
        return wsFactory.create(Ws.Type.GET).run(ServerOptions.class);
    }

    public ServerOptions put(ServerOptions serverOptions) throws WsException {
        Objects.requireNonNull(serverOptions, "Server Options cannot be null");
        return wsFactory.create(Ws.Type.PUT, serverOptions).run(ServerOptions.class);
    }
}
