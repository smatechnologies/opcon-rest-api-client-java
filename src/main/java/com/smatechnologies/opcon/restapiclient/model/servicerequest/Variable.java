package com.smatechnologies.opcon.restapiclient.model.servicerequest;

import com.smatechnologies.opcon.commons.util.StringUtil;
import com.smatechnologies.opcon.restapiclient.model.servicerequest.variableparameters.ChoiceVariableParameters;
import com.smatechnologies.opcon.restapiclient.model.servicerequest.variableparameters.DateVariableParameters;
import com.smatechnologies.opcon.restapiclient.model.servicerequest.variableparameters.IVariableParameters;
import com.smatechnologies.opcon.restapiclient.model.servicerequest.variableparameters.MasterJobVariableParameters;
import com.smatechnologies.opcon.restapiclient.model.servicerequest.variableparameters.MasterScheduleVariableParameters;
import com.smatechnologies.opcon.restapiclient.model.servicerequest.variableparameters.NumberVariableParameters;
import com.smatechnologies.opcon.restapiclient.model.servicerequest.variableparameters.TextCollectionVariableParameters;
import com.smatechnologies.opcon.restapiclient.model.servicerequest.variableparameters.TextVariableParameters;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;


/**
 * Define rules for a Variable
 */
@XmlRootElement(name = "variable")
@XmlAccessorType(XmlAccessType.FIELD)
public class Variable implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String RESOURCE = "variable";

    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_LABEL = "label";
    public static final String PROPERTY_REQUIRED = "required";
    public static final String PROPERTY_VARIABLE_PARAMETERS = "variableParameters";

    @XmlElement(name = "name")
    private String name = "";

    @XmlElement(name = "label")
    private String label = "";

    @XmlElement(name = "required")
    private boolean required = true;

    @XmlElementRefs({
            @XmlElementRef(name = "text", type = TextVariableParameters.class),
            @XmlElementRef(name = "number", type = NumberVariableParameters.class),
            @XmlElementRef(name = "date", type = DateVariableParameters.class),
            @XmlElementRef(name = "choice", type = ChoiceVariableParameters.class),
            @XmlElementRef(name = "text-collection", type = TextCollectionVariableParameters.class),
            @XmlElementRef(name = "master-schedule", type = MasterScheduleVariableParameters.class),
            @XmlElementRef(name = "master-job", type = MasterJobVariableParameters.class)
    })
    private IVariableParameters variableParameters = new TextVariableParameters();

    public Variable() {
    }

    public Variable(String name, IVariableParameters variableParameters) {
        this.name = Objects.requireNonNull(name);
        this.variableParameters = Objects.requireNonNull(variableParameters);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String getName() {
        return name;
    }

    public String getDisplayLabel() {
        return getLabel().isEmpty() ? StringUtil.capitalizeFirstLetter(getName()) : getLabel();
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public IVariableParameters getVariableParameters() {
        return variableParameters;
    }

    public void setVariableParameters(IVariableParameters variableParameters) {
        this.variableParameters = Objects.requireNonNull(variableParameters);
    }

    @XmlAttribute(name = "type")
    public VariableType getType() {
        return Objects.requireNonNull(variableParameters).getType();
    }

    public enum VariableType {
        TEXT(TextVariableParameters.class),
        NUMBER(NumberVariableParameters.class),
        DATE(DateVariableParameters.class),
        CHOICE(ChoiceVariableParameters.class),
        TEXT_COLLECTION(TextCollectionVariableParameters.class),
        MASTER_SCHEDULE(MasterScheduleVariableParameters.class),
        MASTER_JOB(MasterJobVariableParameters.class);

        private final Class<? extends IVariableParameters> variableParametersClass;

        VariableType(Class<? extends IVariableParameters> variableParametersClass) {
            this.variableParametersClass = variableParametersClass;
        }

        public Class<? extends IVariableParameters> getVariableParametersClass() {
            return variableParametersClass;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((label == null) ? 0 : label.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((variableParameters == null) ? 0 : variableParameters.hashCode());
        result = prime * result + (required ? 1231 : 1237);
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
        Variable other = (Variable) obj;
        if (label == null) {
            if (other.label != null)
                return false;
        } else if (!label.equals(other.label))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (variableParameters == null) {
            if (other.variableParameters != null)
                return false;
        } else if (!variableParameters.equals(other.variableParameters))
            return false;
        if (required != other.required)
            return false;
        return true;
    }
}
