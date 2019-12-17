package com.smatechnologies.opcon.restapiclient.api.masterschedules;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.WsResult;
import com.smatechnologies.opcon.restapiclient.model.MasterSchedule;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;


/**
 * @author Pierre PINON
 */
public class WsMasterSchedules {

    private final WsFactory wsFactory;

    public WsMasterSchedules(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("masterschedules");
    }

    public List<MasterSchedule> get(MasterSchedulesCriteria masterSchedulesCriteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(masterSchedulesCriteria).run(new GenericType<List<MasterSchedule>>() {

        });
    }

    public WsResult<List<MasterSchedule>> getAndCount(MasterSchedulesCriteria masterSchedulesCriteria) throws WsException {
        //Need to specify IncludeCount Criterion
        if (masterSchedulesCriteria == null) {
            masterSchedulesCriteria = new MasterSchedulesCriteria();
        }
        masterSchedulesCriteria.setIncludeCount(true);

        Response response = wsFactory.create(Ws.Type.GET).criteria(masterSchedulesCriteria).run().getResponse();

        List<MasterSchedule> entity = response.readEntity(new GenericType<List<MasterSchedule>>() {

        });
        int totalCount = Integer.parseInt(response.getHeaderString(Ws.COUNT_HEADER_KEY));

        return new WsResult<>(entity, totalCount);
    }

    public int count(MasterSchedulesCriteria masterSchedulesCriteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(masterSchedulesCriteria).count();
    }
}
