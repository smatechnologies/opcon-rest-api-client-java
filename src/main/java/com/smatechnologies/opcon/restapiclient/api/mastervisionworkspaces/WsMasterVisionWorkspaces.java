package com.smatechnologies.opcon.restapiclient.api.mastervisionworkspaces;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.MasterVisionWorkspace;

import javax.ws.rs.core.GenericType;
import java.util.List;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class WsMasterVisionWorkspaces {

    private final WsFactory wsFactory;

    public WsMasterVisionWorkspaces(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("masterVisionWorkspaces");
    }

    public List<MasterVisionWorkspace> get(MasterVisionWorkspaceCriteria masterVisionWorkspaceCriteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(masterVisionWorkspaceCriteria).run(new GenericType<List<MasterVisionWorkspace>>() {

        });
    }

    public int count(MasterVisionWorkspaceCriteria masterVisionWorkspaceCriteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(masterVisionWorkspaceCriteria).count();
    }

    public MasterVisionWorkspace post(MasterVisionWorkspace masterVisionWorkspace) throws WsException {
        Objects.requireNonNull(masterVisionWorkspace, "MasterVisionWorkspace cannot be null");
        return wsFactory.create(Ws.Type.POST, masterVisionWorkspace).run(MasterVisionWorkspace.class);
    }
}
