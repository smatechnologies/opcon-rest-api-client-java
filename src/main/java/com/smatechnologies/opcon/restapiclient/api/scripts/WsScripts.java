package com.smatechnologies.opcon.restapiclient.api.scripts;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.Script;

import javax.ws.rs.core.GenericType;
import java.util.List;


/**
 * @author Pierre PINON
 */
public class WsScripts {

    private final WsFactory wsFactory;

    public WsScripts(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("scripts");
    }

    public List<Script> get(ScriptsCriteria scriptsCriteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(scriptsCriteria).run(new GenericType<List<Script>>() {

        });
    }

    public Script get(int scriptId) throws WsException {
        return wsFactory.create(Ws.Type.GET).path(String.valueOf(scriptId)).run(Script.class);
    }
}
