package com.smatechnologies.opcon.restapiclient.api.remoteinstances;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.RemoteInstance;

import javax.ws.rs.core.GenericType;
import java.util.List;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class WsRemoteInstances {

    public final static int API_ERROR_REMOTE_INSTANCE_DUPLICATE_NAME = 101;
    public final static int API_ERROR_REMOTE_INSTANCE_INVALID_BASE_URL = 102;
    public final static int API_ERROR_REMOTE_INSTANCE_INVALID_API_CREDENTIALS = 104;
    public final static int API_ERROR_REMOTE_INSTANCE_INVALID_VISION_USERS = 105;

    private final WsFactory wsFactory;

    public WsRemoteInstances(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("remoteinstances");
    }

    public List<RemoteInstance> get(RemoteInstanceCriteria criteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(criteria).run(new GenericType<List<RemoteInstance>>() {

        });
    }

    public RemoteInstance get(int remoteInstanceId) throws WsException {
        return wsFactory.create(Ws.Type.GET).path(String.valueOf(remoteInstanceId)).run(RemoteInstance.class);
    }

    public RemoteInstance post(RemoteInstance remoteInstance) throws WsException {
        Objects.requireNonNull(remoteInstance, "RemoteInstance cannot be null");
        return wsFactory.create(Ws.Type.POST, remoteInstance).run(RemoteInstance.class);
    }

    public RemoteInstance put(RemoteInstance remoteInstance) throws WsException {
        Objects.requireNonNull(remoteInstance, "RemoteInstance cannot be null");
        return wsFactory.create(Ws.Type.PUT, remoteInstance).path(String.valueOf(remoteInstance.getId())).run(RemoteInstance.class);
    }

    public void delete(RemoteInstance remoteInstance) throws WsException {
        Objects.requireNonNull(remoteInstance, "RemoteInstance cannot be null");
        wsFactory.create(Ws.Type.DELETE).path(String.valueOf(remoteInstance.getId())).run(RemoteInstance.class);
    }
}
