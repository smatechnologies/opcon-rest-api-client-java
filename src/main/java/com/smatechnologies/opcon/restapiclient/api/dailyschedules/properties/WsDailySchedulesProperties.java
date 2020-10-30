package com.smatechnologies.opcon.restapiclient.api.dailyschedules.properties;

import com.smatechnologies.opcon.commons.util.HtmlUtil;
import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.Property;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class WsDailySchedulesProperties {

    private final WsFactory wsFactory;

    public WsDailySchedulesProperties(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("properties");
    }

    public List<Property> get() throws WsException {
        return wsFactory.create(Ws.Type.GET).run(new GenericType<List<Property>>() {

        });
    }

    public Property get(String name) throws WsException {
        return wsFactory.create(Ws.Type.GET).path(HtmlUtil.doubleUrlEncodeSlash(name)).run(Property.class);
    }

}
