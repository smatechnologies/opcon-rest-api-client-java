package com.smatechnologies.opcon.restapiclient.model.servicerequest.variableparameters;

import com.smatechnologies.opcon.restapiclient.model.servicerequest.Variable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;


@XmlRootElement(name = "number")
@XmlAccessorType(XmlAccessType.FIELD)
public class NumberVariableParameters implements IVariableParameters {

    private static final long serialVersionUID = 1L;

    public static final String RESOURCE = "number";

    public static final String PROPERTY_TYPE = "type";
    public static final String PROPERTY_VARIABLE_REFERENCES = "variableReferences";

    public static final String PROPERTY_MAXIMUM = "maximum";
    public static final String PROPERTY_MINIMUM = "minimum";

    public static final int DEFAULT_MINIMUM = Integer.MIN_VALUE;
    public static final int DEFAULT_MAXIMUM = Integer.MAX_VALUE;

    private int minimum = DEFAULT_MINIMUM;
    private int maximum = DEFAULT_MAXIMUM;

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    @Override
    public Variable.VariableType getType() {
        return Variable.VariableType.NUMBER;
    }

    @Override
    public Set<String> getVariableReferences() {
        return null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + maximum;
        result = prime * result + minimum;
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
        NumberVariableParameters other = (NumberVariableParameters) obj;
        if (maximum != other.maximum)
            return false;
        if (minimum != other.minimum)
            return false;
        return true;
    }
}
