package com.smatechnologies.opcon.restapiclient.model.servicerequest.variableparameters;

import com.smatechnologies.opcon.restapiclient.model.servicerequest.Variable.VariableType;
import com.smatechnologies.opcon.restapiclient.model.servicerequest.variableparameters.choice.ItemChoice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@XmlRootElement(name = "choice")
@XmlAccessorType(XmlAccessType.FIELD)
public class ChoiceVariableParameters implements IVariableParameters {

    private static final long serialVersionUID = 1L;

    public static final String RESOURCE = "choice";

    public static final String PROPERTY_TYPE = "type";
    public static final String PROPERTY_VARIABLE_REFERENCES = "variableReferences";
    public static final String PROPERTY_ITEMS = "items";

    @XmlElementWrapper(name = "items")
    @XmlElement(name = "item")
    private List<ItemChoice> items = new ArrayList<>();

    public List<ItemChoice> getItems() {
        return items;
    }

    public void setItems(List<ItemChoice> items) {
        this.items = items;
    }

    @Override
    public VariableType getType() {
        return VariableType.CHOICE;
    }

    @Override
    public Set<String> getVariableReferences() {
        return null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((items == null) ? 0 : items.hashCode());
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
        ChoiceVariableParameters other = (ChoiceVariableParameters) obj;
        if (items == null) {
            if (other.items != null)
                return false;
        } else if (!items.equals(other.items))
            return false;
        return true;
    }
}
