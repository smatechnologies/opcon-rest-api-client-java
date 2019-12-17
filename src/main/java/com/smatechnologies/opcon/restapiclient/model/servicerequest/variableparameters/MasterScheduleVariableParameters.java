package com.smatechnologies.opcon.restapiclient.model.servicerequest.variableparameters;

import com.smatechnologies.opcon.restapiclient.model.servicerequest.Variable.VariableType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement(name = "master-schedule")
@XmlAccessorType(XmlAccessType.FIELD)
public class MasterScheduleVariableParameters implements IVariableParameters {

    private static final long serialVersionUID = 1L;

    public static final String RESOURCE = "master-schedule";

    public static final String PROPERTY_TYPE = "type";
    public static final String PROPERTY_VARIABLE_REFERENCES = "variableReferences";

    @Override
    public VariableType getType() {
        return VariableType.MASTER_SCHEDULE;
    }

    @Override
    public Set<String> getVariableReferences() {
        return null;
    }

    @Override
    public int hashCode() {
        return 45;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        return true;
    }
}
