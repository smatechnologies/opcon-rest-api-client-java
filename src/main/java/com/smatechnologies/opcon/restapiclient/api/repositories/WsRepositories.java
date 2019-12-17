package com.smatechnologies.opcon.restapiclient.api.repositories;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.Repository;

import javax.ws.rs.core.GenericType;
import java.util.List;
import java.util.Objects;


/**
 * @author Matthieu COELHO
 */
//TODO API does not exist yet
public class WsRepositories {

    private final WsFactory wsFactory;

    public WsRepositories(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("repositories");
    }

    public List<Repository> get(RepositoriesCriteria criteria) throws WsException {
        return wsFactory.create(Ws.Type.GET)
                .criteria(criteria)
                .run(new GenericType<List<Repository>>() {

                });
    }

    public int count(RepositoriesCriteria criteria) throws WsException {
        if (criteria == null) {
            criteria = new RepositoriesCriteria();
        }
        criteria.setIncludeCount(true);
        criteria.setLimit(0);
        Ws.Result run = wsFactory.create(Ws.Type.GET).criteria(criteria).run();
        return Integer.parseInt(run.getResponse().getHeaderString(Ws.COUNT_HEADER_KEY));
    }

    public Repository post(Repository repository) throws WsException {
        Objects.requireNonNull(repository, "Repository cannot be null");
        return wsFactory.create(Ws.Type.POST, repository).run(Repository.class);
    }

    public Repository put(Repository repository) throws WsException {
        Objects.requireNonNull(repository, "Repository cannot be null");
        return wsFactory.create(Ws.Type.PUT, repository).path(String.valueOf(repository.getId())).run(Repository.class);
    }

    public void delete(String repositoryId) throws WsException {
        wsFactory.create(Ws.Type.DELETE).path(String.valueOf(repositoryId)).run();
    }
}
