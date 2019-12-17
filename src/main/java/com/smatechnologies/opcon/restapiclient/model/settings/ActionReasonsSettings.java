package com.smatechnologies.opcon.restapiclient.model.settings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
@XmlRootElement(name = "actionReasons")
@XmlAccessorType(XmlAccessType.FIELD)
public class ActionReasonsSettings implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String RESOURCE = "actionReasons";

    private static final long XML_VERSION = 1L;

    @XmlElement(name = "xml_version")
    private long xmlVersion = XML_VERSION;

    @XmlElementWrapper(name = "operationsActionReasons")
    @XmlElement(name = "operationsActionReason")
    private List<String> operationsActionReasons = new ArrayList<>();

    public long getXmlVersion() {
        return xmlVersion;
    }

    public List<String> getOperationsActionReasons() {
        if (operationsActionReasons == null) {
            operationsActionReasons = new ArrayList<>();
        }

        return operationsActionReasons;
    }

    public void setOperationsActionReasons(List<String> operationsActionReasons) {
        this.operationsActionReasons = operationsActionReasons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ActionReasonsSettings that = (ActionReasonsSettings) o;
        return xmlVersion == that.xmlVersion &&
                Objects.equals(operationsActionReasons, that.operationsActionReasons);
    }

    @Override
    public int hashCode() {

        return Objects.hash(xmlVersion, operationsActionReasons);
    }
}
