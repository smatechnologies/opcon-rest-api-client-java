package com.smatechnologies.opcon.restapiclient.api.dailyschedules;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.WsResult;
import com.smatechnologies.opcon.restapiclient.api.dailyschedules.dates.WsDates;
import com.smatechnologies.opcon.restapiclient.model.DailySchedule;
import com.smatechnologies.opcon.restapiclient.model.ScheduleDailyStatusCount;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;


/**
 * @author Francois EYL
 * @author Pierre PINON
 */
public class WsDailySchedules {

    private final WsFactory wsFactory;

    public WsDailySchedules(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("dailyschedules");
    }

    public WsDates dates() {
        return new WsDates(wsFactory);
    }

    public List<DailySchedule> get(DailySchedulesCriteria criteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(criteria).run(new GenericType<List<DailySchedule>>() {

        });
    }

    public WsResult<List<DailySchedule>> getAndCount(DailySchedulesCriteria criteria) throws WsException {
        //Need to specify IncludeCount Criterion
        if (criteria == null) {
            criteria = new DailySchedulesCriteria();
        }
        criteria.setIncludeCount(true);

        Response response = wsFactory.create(Ws.Type.GET).criteria(criteria).run().getResponse();

        List<DailySchedule> entity = response.readEntity(new GenericType<List<DailySchedule>>() {

        });
        int totalCount = Integer.parseInt(response.getHeaderString(Ws.COUNT_HEADER_KEY));

        return new WsResult<>(entity, totalCount);
    }

    public DailySchedule get(String dailyScheduleId) throws WsException {
        return wsFactory.create(Ws.Type.GET).path(dailyScheduleId).run(DailySchedule.class);
    }

    public ScheduleDailyStatusCount countByStatus(DailySchedulesCriteria criteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).path("count_by_status").criteria(criteria).run(ScheduleDailyStatusCount.class);
    }
}