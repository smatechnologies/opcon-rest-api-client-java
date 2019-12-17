package com.smatechnologies.opcon.restapiclient.model.servicerequest.variableparameters;

import com.smatechnologies.opcon.commons.opcon.util.VariableResolver;
import com.smatechnologies.opcon.restapiclient.model.servicerequest.Variable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement(name = "master-job")
@XmlAccessorType(XmlAccessType.FIELD)
public class MasterJobVariableParameters implements IVariableParameters {

    private static final long serialVersionUID = 1L;

    public static final String RESOURCE = "master-job";

    public static final String PROPERTY_TYPE = "type";
    public static final String PROPERTY_VARIABLE_REFERENCES = "variableReferences";

    public static final Object PROPERTY_SCHEDULE_NAME = "scheduleName";

    private String scheduleName;

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    @Override
    public Variable.VariableType getType() {
        return Variable.VariableType.MASTER_JOB;
    }

    @Override
    public Set<String> getVariableReferences() {
        return scheduleName == null ? null : VariableResolver.getVariableNames(scheduleName);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((scheduleName == null) ? 0 : scheduleName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MasterJobVariableParameters other = (MasterJobVariableParameters) obj;
        if (scheduleName == null) {
            if (other.scheduleName != null)
                return false;
        } else if (!scheduleName.equals(other.scheduleName))
            return false;
        return true;
    }
}
