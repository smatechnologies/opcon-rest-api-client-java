package com.smatechnologies.opcon.restapiclient.api.solutionmanagersettings;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.SolutionManagerSettings;

import javax.ws.rs.core.GenericType;
import java.util.List;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class WsSolutionManagerSettings {

    private final WsFactory wsFactory;

    public WsSolutionManagerSettings(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("solutionManagerSettings");
    }

    public List<SolutionManagerSettings> get(SolutionManagerSettingsCriteria criteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(criteria).run(new GenericType<List<SolutionManagerSettings>>() {

        });
    }

    public SolutionManagerSettings get(int solutionManagerSettingsId) throws WsException {
        return wsFactory.create(Ws.Type.GET).path(String.valueOf(solutionManagerSettingsId)).run(SolutionManagerSettings.class);
    }

    public SolutionManagerSettings post(SolutionManagerSettings solutionManagerSettings) throws WsException {
        Objects.requireNonNull(solutionManagerSettings, "SolutionManagerSettings cannot be null");
        return wsFactory.create(Ws.Type.POST, solutionManagerSettings).run(SolutionManagerSettings.class);
    }

    public SolutionManagerSettings put(SolutionManagerSettings solutionManagerSettings) throws WsException {
        Objects.requireNonNull(solutionManagerSettings, "SolutionManagerSettings cannot be null");
        return wsFactory.create(Ws.Type.PUT, solutionManagerSettings).path(String.valueOf(solutionManagerSettings.getId())).run(SolutionManagerSettings.class);
    }

    public void delete(SolutionManagerSettingsCriteria criteria) throws WsException {
        wsFactory.create(Ws.Type.DELETE).criteria(criteria).run();
    }
}
