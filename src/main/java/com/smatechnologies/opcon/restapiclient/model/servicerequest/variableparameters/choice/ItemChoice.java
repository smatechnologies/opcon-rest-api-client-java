package com.smatechnologies.opcon.restapiclient.model.servicerequest.variableparameters.choice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;


@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemChoice implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String RESOURCE = "item";

    public static final String PROPERTY_CAPTION = "caption";
    public static final String PROPERTY_VALUE = "value";

    private String caption = "";
    private String value = "";

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        if (Objects.equals(caption, value)) {
            return caption;
        } else {
            return caption + " (value=" + value + ")";
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((caption == null) ? 0 : caption.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
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
        ItemChoice other = (ItemChoice) obj;
        if (caption == null) {
            if (other.caption != null)
                return false;
        } else if (!caption.equals(other.caption))
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
}
