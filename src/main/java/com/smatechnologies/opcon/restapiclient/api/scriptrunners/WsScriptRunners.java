package com.smatechnologies.opcon.restapiclient.api.scriptrunners;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.script.ScriptRunner;

import javax.ws.rs.core.GenericType;
import java.util.List;


/**
 * @author Pierre PINON
 */
public class WsScriptRunners {

    private final WsFactory wsFactory;

    public WsScriptRunners(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("scriptRunners");
    }

    public List<ScriptRunner> get(ScriptRunnersCriteria scriptRunnersCriteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(scriptRunnersCriteria).run(new GenericType<List<ScriptRunner>>() {

        });
    }
}
