package com.smatechnologies.opcon.restapiclient.model.settings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
@XmlRootElement(name = "operationsAgents")
@XmlAccessorType(XmlAccessType.FIELD)
public class OperationsAgentsSettings implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String RESOURCE = "operationsAgents";

    private static final long XML_VERSION = 1L;

    @XmlElement(name = "xml_version")
    private long xmlVersion = XML_VERSION;

    @XmlElement
    private Map<String, Boolean> agentColumnVisibility;

    public long getXmlVersion() {
        return xmlVersion;
    }

    public boolean isAgentColumnVisible(String id, boolean defaultValue) {
        Boolean isVisible = agentColumnVisibility == null ? null : agentColumnVisibility.get(id);
        return isVisible == null ? defaultValue : isVisible;
    }

    public void setAgentColumnVisible(String id, boolean visible) {
        if (agentColumnVisibility == null) {
            agentColumnVisibility = new HashMap<>();
        }

        agentColumnVisibility.put(id, visible);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        OperationsAgentsSettings that = (OperationsAgentsSettings) o;
        return xmlVersion == that.xmlVersion &&
                Objects.equals(agentColumnVisibility, that.agentColumnVisibility);
    }

    @Override
    public int hashCode() {

        return Objects.hash(xmlVersion, agentColumnVisibility);
    }
}
