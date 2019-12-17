package com.smatechnologies.opcon.restapiclient.api.machinegroups;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.MachineGroup;

import javax.ws.rs.core.GenericType;
import java.util.List;


/**
 * @author Pierre PINON
 */
public class WsMachineGroups {

    private final WsFactory wsFactory;

    public WsMachineGroups(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("machineGroups");
    }

    public List<MachineGroup> get(MachineGroupsCriteria criteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(criteria).run(new GenericType<List<MachineGroup>>() {

        });
    }
}
