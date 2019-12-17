package com.smatechnologies.opcon.restapiclient.model.servicerequest;

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
 * Model that represents a service request and can be serialized to XML
 */
@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
public class ServiceRequestDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String RESOURCE = "request";

    private static final long XML_VERSION = 1L;

    public static final String PROPERTY_CONFIRMATION = "confirmed";
    public static final String PROPERTY_SEND_AS_OCADM = "sendAsOCADM";
    public static final String PROPERTY_VARIABLES = "variables";
    public static final String PROPERTY_EVENTS = "events";
    public static final String PROPERTY_TRACK_EVENT_EXECUTIONS = "trackEventExecutions";

    @XmlElement(name = "xml_version")
    private long xmlVersion = XML_VERSION;

    @XmlElement(name = "confirmed")
    private boolean confirmed = true;

    @XmlElement(name = "send_as_ocadm")
    private boolean sendAsOCADM = false;

    @XmlElementWrapper(name = "events")
    @XmlElement(name = "event")
    private List<String> events = new ArrayList<>();

    @XmlElement(name = "track_event_executions")
    private boolean trackEventExecutions = false;

    @XmlElementWrapper(name = "variables")
    @XmlElement(name = "variable")
    private List<Variable> variables = new ArrayList<>();

    public long getXmlVersion() {
        return xmlVersion;
    }

    /**
     * @return <code>true</code> if the user need to confirm the request before executing it.
     */
    public boolean isConfirmed() {
        return confirmed;
    }

    /**
     * Set if the user should confirm the request before executing it.
     *
     * @param confirmed
     *         <code>true</code> to ask for confirmation, <code>false</code> otherwise.
     */
    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public boolean isSendAsOCADM() {
        return sendAsOCADM;
    }

    public void setSendAsOCADM(boolean sendAsOCADM) {
        this.sendAsOCADM = sendAsOCADM;
    }

    public List<String> getEvents() {
        return events;
    }

    public void setEvents(List<String> events) {
        this.events = Objects.requireNonNull(events);
    }

    public boolean isTrackEventExecutions() {
        return trackEventExecutions;
    }

    public void setTrackEventExecutions(boolean trackEventExecutions) {
        this.trackEventExecutions = trackEventExecutions;
    }

    public List<Variable> getVariables() {
        return variables;
    }

    public void setVariables(List<Variable> variables) {
        this.variables = Objects.requireNonNull(variables);
    }

    @Override
    public String toString() {
        return "ServiceRequestDetails{" +
                "xmlVersion=" + xmlVersion +
                ", confirmed=" + confirmed +
                ", sendAsOCADM=" + sendAsOCADM +
                ", events=" + events +
                ", trackEventExecutions=" + trackEventExecutions +
                ", variables=" + variables +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ServiceRequestDetails that = (ServiceRequestDetails) o;

        if (xmlVersion != that.xmlVersion)
            return false;
        if (confirmed != that.confirmed)
            return false;
        if (sendAsOCADM != that.sendAsOCADM)
            return false;
        if (trackEventExecutions != that.trackEventExecutions)
            return false;
        if (events != null ? !events.equals(that.events) : that.events != null)
            return false;
        return variables != null ? variables.equals(that.variables) : that.variables == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (xmlVersion ^ (xmlVersion >>> 32));
        result = 31 * result + (confirmed ? 1 : 0);
        result = 31 * result + (sendAsOCADM ? 1 : 0);
        result = 31 * result + (events != null ? events.hashCode() : 0);
        result = 31 * result + (trackEventExecutions ? 1 : 0);
        result = 31 * result + (variables != null ? variables.hashCode() : 0);
        return result;
    }
}
