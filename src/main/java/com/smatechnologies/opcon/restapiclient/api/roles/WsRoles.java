package com.smatechnologies.opcon.restapiclient.api.roles;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.Role;

import javax.ws.rs.core.GenericType;
import java.util.List;
import java.util.Objects;


/**
 * @author Francois EYL
 */
public class WsRoles {

    private final WsFactory wsFactory;

    public WsRoles(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("roles");
    }

    public List<Role> get(RolesCriteria rolesCriteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(rolesCriteria).run(new GenericType<List<Role>>() {

        });
    }

    public Role get(int roleId) throws WsException {
        return wsFactory.create(Ws.Type.GET).path(String.valueOf(roleId)).run(Role.class);
    }

    public int count(RolesCriteria criteria) throws WsException {
        if (criteria == null) {
            criteria = new RolesCriteria();
        }
        criteria.setIncludeCount(true);
        criteria.setLimit(0);
        Ws.Result run = wsFactory.create(Ws.Type.GET).criteria(criteria).run();
        return Integer.parseInt(run.getResponse().getHeaderString(Ws.COUNT_HEADER_KEY));
    }

    public Role post(Role role) throws WsException {
        Objects.requireNonNull(role, "Role cannot be null");
        return wsFactory.create(Ws.Type.POST, role).run(Role.class);
    }

    public Role put(Role role) throws WsException {
        Objects.requireNonNull(role, "Role cannot be null");
        return wsFactory.create(Ws.Type.PUT, role).path(String.valueOf(role.getId())).run(Role.class);
    }

    public void delete(String roleId) throws WsException {
        wsFactory.create(Ws.Type.DELETE).path(String.valueOf(roleId)).run();
    }
}
