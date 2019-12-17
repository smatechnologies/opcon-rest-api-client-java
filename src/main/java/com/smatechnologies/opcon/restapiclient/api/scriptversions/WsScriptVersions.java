package com.smatechnologies.opcon.restapiclient.api.scriptversions;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.ScriptVersion;


/**
 * @author Pierre PINON
 */
public class WsScriptVersions {

    private final WsFactory wsFactory;

    public WsScriptVersions(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("scriptversions");
    }

    public ScriptVersion get(int ScriptVersionId) throws WsException {
        return wsFactory.create(Ws.Type.GET).path(String.valueOf(ScriptVersionId)).run(ScriptVersion.class);
    }
}
