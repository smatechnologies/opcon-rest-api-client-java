package com.smatechnologies.opcon.restapiclient.api.thresholds;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.Threshold;

import javax.ws.rs.core.GenericType;
import java.util.List;
import java.util.Objects;


/**
 * @author Matthieu COELHO
 */
public class WsThresholds {

    private final WsFactory wsFactory;

    public WsThresholds(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("thresholds");
    }

    public List<Threshold> get(ThresholdsCriteria criteria) throws WsException {
        return wsFactory
                .create(Ws.Type.GET)
                .criteria(criteria)
                .run(new GenericType<List<Threshold>>() {

                });
    }

    public int count(ThresholdsCriteria criteria) throws WsException {
        if (criteria == null) {
            criteria = new ThresholdsCriteria();
        }
        criteria.setIncludeCount(true);
        criteria.setLimit(0);
        Ws.Result run = wsFactory.create(Ws.Type.GET).criteria(criteria).run();
        return Integer.parseInt(run.getResponse().getHeaderString(Ws.COUNT_HEADER_KEY));
    }

    public Threshold post(Threshold threshold) throws WsException {
        Objects.requireNonNull(threshold, "Threshold cannot be null");
        return wsFactory.create(Ws.Type.POST, threshold).run(Threshold.class);
    }

    public Threshold put(Threshold threshold) throws WsException {
        Objects.requireNonNull(threshold, "Threshold cannot be null");
        return wsFactory.create(Ws.Type.PUT, threshold).path(String.valueOf(threshold.getId())).run(Threshold.class);
    }

    public void delete(String thresholdId) throws WsException {
        wsFactory.create(Ws.Type.DELETE).path(String.valueOf(thresholdId)).run();
    }
}
