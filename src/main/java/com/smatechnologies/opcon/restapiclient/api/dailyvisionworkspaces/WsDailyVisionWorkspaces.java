package com.smatechnologies.opcon.restapiclient.api.dailyvisionworkspaces;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.api.mastervisionworkspaces.MasterVisionWorkspaceCriteria;
import com.smatechnologies.opcon.restapiclient.model.DailyVisionWorkspace;

import javax.ws.rs.core.GenericType;
import java.util.List;


/**
 * @author Matthieu COELHO
 */
public class WsDailyVisionWorkspaces {

    private final WsFactory wsFactory;

    public WsDailyVisionWorkspaces(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("dailyVisionWorkspaces");
    }

    public List<DailyVisionWorkspace> get(DailyVisionWorkspacesCriteria dailyVisionWorkspacesCriteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(dailyVisionWorkspacesCriteria).run(new GenericType<List<DailyVisionWorkspace>>() {

        });
    }

    public int count(MasterVisionWorkspaceCriteria d) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(d).count();
    }
}