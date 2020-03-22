package com.smatechnologies.opcon.restapiclient.api.machines;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.WsResult;
import com.smatechnologies.opcon.restapiclient.model.Calendar;
import com.smatechnologies.opcon.restapiclient.model.MachineStatusCount;
import com.smatechnologies.opcon.restapiclient.model.machine.Machine;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;


/**
 * @author Francois EYL
 */
public class WsMachines {

    private final WsFactory wsFactory;

    public WsMachines(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("machines");
    }

    public List<Machine> get(MachinesCriteria criteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(criteria).run(new GenericType<List<Machine>>() {

        });
    }

    public WsResult<List<Machine>> getAndCount(MachinesCriteria criteria) throws WsException {
        //Need to specify IncludeCount Criterion
        if (criteria == null) {
            criteria = new MachinesCriteria();
        }
        criteria.setIncludeCount(true);

        Response response = wsFactory.create(Ws.Type.GET).criteria(criteria).run().getResponse();

        List<Machine> entity = response.readEntity(new GenericType<List<Machine>>() {

        });
        int totalCount = Integer.parseInt(response.getHeaderString(Ws.COUNT_HEADER_KEY));

        return new WsResult<>(entity, totalCount);
    }

    public int count(MachinesCriteria criteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(criteria).count();
    }

    public MachineStatusCount countByStatus(MachinesCriteria criteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).path("count_by_status").criteria(criteria).run(MachineStatusCount.class);
    }
    
    public Machine put(Machine machine) throws WsException {
        Objects.requireNonNull(machine, "Machine cannot be null");
        return wsFactory.create(Ws.Type.PUT, machine).path(String.valueOf(machine.getId())).run(Machine.class);
    }

}
