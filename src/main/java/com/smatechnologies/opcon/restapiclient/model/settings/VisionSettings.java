package com.smatechnologies.opcon.restapiclient.model.settings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
@XmlRootElement(name = "actionVision")
@XmlAccessorType(XmlAccessType.FIELD)
public class VisionSettings implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String RESOURCE = "actionVision";

    private static final long XML_VERSION = 1L;

    @XmlElement(name = "xml_version")
    private long xmlVersion = XML_VERSION;

    @XmlElement
    private Boolean disableWarnings = false;

    public long getXmlVersion() {
        return xmlVersion;
    }

    public Boolean isDisableWarnings() {
        return disableWarnings;
    }

    public void setDisableWarnings(Boolean disableWarnings) {
        this.disableWarnings = disableWarnings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        VisionSettings that = (VisionSettings) o;
        return xmlVersion == that.xmlVersion &&
                Objects.equals(disableWarnings, that.disableWarnings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xmlVersion, disableWarnings);
    }
}
