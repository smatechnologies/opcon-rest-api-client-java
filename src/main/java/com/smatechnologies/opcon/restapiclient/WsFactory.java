package com.smatechnologies.opcon.restapiclient;

import com.smatechnologies.opcon.commons.util.VersionComparator;
import com.smatechnologies.opcon.restapiclient.api.OpconApiProfile;

import javax.ws.rs.client.Client;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class WsFactory {

    private final Client client;
    private final OpconApiProfile profile;
    private final Ws.WsListener wsListener;

    private List<String> paths;

    public WsFactory(final Client client, final OpconApiProfile profile, final Ws.WsListener wsListener) {
        this.client = client;
        this.profile = profile;
        this.wsListener = wsListener;
    }

    /**
     * Throw an exception when the endpoint is not compatible with the current version
     *
     * @param minimumVersion
     * @param maximumVersion
     * @return the initial WsFactory
     * @throws WsVersionException
     */
    public WsFactory checkVersion(String minimumVersion, String maximumVersion) throws WsVersionException {
        String actualVersion = wsListener.getVersion().getOpConRestApiProductVersion();

        VersionComparator versionComparator = new VersionComparator();

        if (minimumVersion != null && versionComparator.compare(wsListener.getVersion().getOpConRestApiProductVersion(), minimumVersion) < 0) {
            throw new WsVersionException("Incompatible Version Rest API Endpoint (Minimum=[" + minimumVersion + "] Actual=[" + actualVersion + "])", minimumVersion, actualVersion);
        }

        if (maximumVersion != null && versionComparator.compare(wsListener.getVersion().getOpConRestApiProductVersion(), maximumVersion) > 0) {
            throw new WsVersionException("Incompatible Version Rest API Endpoint (Maximum=[" + maximumVersion + "] Actual=[" + actualVersion + "])", maximumVersion, actualVersion);
        }

        return this;
    }

    public WsFactory path(String... path) {
        Objects.requireNonNull(path, "Path cannot be null");
        if (path.length == 0) {
            throw new IllegalArgumentException("Path cannot be empty");
        }

        WsFactory wsFactory = new WsFactory(client, profile, wsListener);
        if (paths == null) {
            wsFactory.paths = new ArrayList<>();
        } else {
            wsFactory.paths = paths;
        }
        wsFactory.paths.addAll(Arrays.asList(path));

        return wsFactory;
    }

    public Ws create() {
        Ws ws = new Ws(client, wsListener)
                .target(profile.getUrl());
        if (paths != null) {
            ws.path(paths.toArray(new String[paths.size()]));
        }

        return ws;
    }

    public Ws create(Ws.Type type) {
        return create().type(type);
    }

    public Ws create(Ws.Type type, Object payload) {
        return create().type(type).payload(payload);
    }
}
