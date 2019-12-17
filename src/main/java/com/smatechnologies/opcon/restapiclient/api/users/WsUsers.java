package com.smatechnologies.opcon.restapiclient.api.users;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.User;

import javax.ws.rs.core.GenericType;
import java.util.List;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class WsUsers {

    public final static int API_ERROR_PASSWORD_IN_HISTORY = 1009;
    public final static int API_ERROR_PASSWORD_CHANGED_FOR_CURRENT = 1010;

    private final WsFactory wsFactory;

    public WsUsers(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("users");
    }

    public List<User> get(UsersCriteria usersCriteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(usersCriteria).run(new GenericType<List<User>>() {

        });
    }

    public User get(int userId) throws WsException {
        return wsFactory.create(Ws.Type.GET).path(String.valueOf(userId)).run(User.class);
    }

    public User put(User user) throws WsException {
        Objects.requireNonNull(user, "User cannot be null");
        int id = Objects.requireNonNull(user.getId(), "Id cannot be null");

        return wsFactory.create(Ws.Type.PUT, user).path(String.valueOf(id)).run(User.class);
    }
}
