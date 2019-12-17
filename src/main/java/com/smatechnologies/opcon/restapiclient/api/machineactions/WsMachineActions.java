package com.smatechnologies.opcon.restapiclient.api.machineactions;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.MachineAction;

import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class WsMachineActions {

    private final WsFactory wsFactory;

    public WsMachineActions(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("machineactions");
    }

    public MachineAction get(int machineActionId) throws WsException {
        return wsFactory.create(Ws.Type.GET).path(String.valueOf(machineActionId)).run(MachineAction.class);
    }

    public MachineAction post(MachineAction machineAction) throws WsException {
        Objects.requireNonNull(machineAction, "machineAction cannot be null");

        return wsFactory.create(Ws.Type.POST, machineAction).run(MachineAction.class);
    }
}
