package com.smatechnologies.opcon.restapiclient.api.dailyjobs;

import com.smatechnologies.opcon.commons.util.HtmlUtil;
import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.WsResult;
import com.smatechnologies.opcon.restapiclient.model.JobDailyStatusCount;
import com.smatechnologies.opcon.restapiclient.model.dailyjob.DailyJob;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;


/**
 * @author Francois EYL
 */
public class WsDailyJobs {

    private final WsFactory wsFactory;

    public WsDailyJobs(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("dailyjobs");
    }

    public List<DailyJob> get(DailyJobsCriteria criteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).criteria(criteria).run(new GenericType<List<DailyJob>>() {

        });
    }

    public WsResult<List<DailyJob>> getAndCount(DailyJobsCriteria criteria) throws WsException {
        //Need to specify IncludeCount Criterion
        if (criteria == null) {
            criteria = new DailyJobsCriteria();
        }
        criteria.setIncludeCount(true);

        Response response = wsFactory.create(Ws.Type.GET).criteria(criteria).run().getResponse();

        List<DailyJob> entity = response.readEntity(new GenericType<List<DailyJob>>() {

        });
        int totalCount = Integer.parseInt(response.getHeaderString(Ws.COUNT_HEADER_KEY));

        return new WsResult<>(entity, totalCount);
    }

    public DailyJob get(String dailyJobId) throws WsException {
        return wsFactory.create(Ws.Type.GET).path(HtmlUtil.doubleUrlEncodeSlash(dailyJobId)).run(DailyJob.class);
    }

    public JobDailyStatusCount countByStatus(DailyJobsCriteria criteria) throws WsException {
        return wsFactory.create(Ws.Type.GET).path("count_by_status").criteria(criteria).run(JobDailyStatusCount.class);
    }

    public DailyJob put(DailyJob dailyJob) throws WsException {
        Objects.requireNonNull(dailyJob, "DailyJob cannot be null");
        String id = Objects.requireNonNull(dailyJob.getId(), "Id cannot be null");

        return wsFactory.create(Ws.Type.PUT, dailyJob).path(id).run(DailyJob.class);
    }
}
