package com.smatechnologies.opcon.restapiclient.api.departments;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.Department;

import javax.ws.rs.core.GenericType;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author Francois EYL
 */
public class WsDepartments {

    private final WsFactory wsFactory;

    public WsDepartments(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("departments");
    }

    public List<Department> get() throws WsException {
        return wsFactory.create(Ws.Type.GET).run(new GenericType<List<Department>>() {

        }).stream().filter(d -> (d.getId() > 0)).collect(Collectors.toList()); //TODO: ask to remove "All Departments" from result
    }
}
