package com.smatechnologies.opcon.restapiclient.model.settings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


/**
 * @author Pierre PINON
 */
@XmlRootElement(name = "operationsFilterProfiles")
@XmlAccessorType(XmlAccessType.FIELD)
public class OperationsFilterProfilesSettings implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String RESOURCE = "operationsFilterProfiles";

    private static final long XML_VERSION = 1L;

    @XmlElement(name = "xml_version")
    private long xmlVersion = XML_VERSION;

    @XmlElementWrapper(name = "operationsFilterProfiles")
    @XmlElement(name = "operationsFilterProfile")
    private Set<OperationsFilterProfileSettings> operationsFilterProfilesSettings = new HashSet<>();

    public long getXmlVersion() {
        return xmlVersion;
    }

    public Set<OperationsFilterProfileSettings> getOperationsFilterProfilesSettings() {
        if (operationsFilterProfilesSettings == null) {
            operationsFilterProfilesSettings = new HashSet<>();
        }

        return operationsFilterProfilesSettings;
    }

    public void setOperationsFilterProfilesSettings(Set<OperationsFilterProfileSettings> operationsFilterProfilesSettings) {
        this.operationsFilterProfilesSettings = operationsFilterProfilesSettings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        OperationsFilterProfilesSettings that = (OperationsFilterProfilesSettings) o;
        return xmlVersion == that.xmlVersion &&
                Objects.equals(operationsFilterProfilesSettings, that.operationsFilterProfilesSettings);
    }

    @Override
    public int hashCode() {

        return Objects.hash(xmlVersion, operationsFilterProfilesSettings);
    }
}
