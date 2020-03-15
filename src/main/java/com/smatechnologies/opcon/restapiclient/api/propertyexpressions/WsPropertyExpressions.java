package com.smatechnologies.opcon.restapiclient.api.propertyexpressions;

import java.util.Objects;

import com.smatechnologies.opcon.restapiclient.Ws;
import com.smatechnologies.opcon.restapiclient.WsException;
import com.smatechnologies.opcon.restapiclient.WsFactory;
import com.smatechnologies.opcon.restapiclient.model.PropertyExpression;

public class WsPropertyExpressions {

    private final WsFactory wsFactory;

    public WsPropertyExpressions(WsFactory wsFactory) {
        this.wsFactory = wsFactory.path("PropertyExpression");
    }

    public PropertyExpression post(PropertyExpression propertyExpression) throws WsException {
        Objects.requireNonNull(propertyExpression, "PropertyExpression cannot be null");
        return wsFactory.create(Ws.Type.POST, propertyExpression).run(PropertyExpression.class);
    }

}
