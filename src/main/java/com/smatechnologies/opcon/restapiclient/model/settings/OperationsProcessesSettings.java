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
@XmlRootElement(name = "operationsProcesses")
@XmlAccessorType(XmlAccessType.FIELD)
public class OperationsProcessesSettings implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String RESOURCE = "operationsProcesses";

    private static final long XML_VERSION = 1L;

    @XmlElement(name = "xml_version")
    private long xmlVersion = XML_VERSION;

    private static final SplitState DEFAULT_SPLIT_STATE = SplitState.VALUE;
    private static final float DEFAULT_SPLIT_POSITION = 33f;

    @XmlElement
    private SplitState splitState;

    @XmlElement
    private Float splitPosition;

    @XmlElement
    private Map<String, Boolean> scheduleColumnVisibility;

    @XmlElement
    private Map<String, Boolean> jobColumnVisibility;

    public long getXmlVersion() {
        return xmlVersion;
    }

    public SplitState getSplitState() {
        if (splitState == null) {
            splitState = DEFAULT_SPLIT_STATE;
        }
        return splitState;
    }

    public void setSplitState(SplitState splitState) {
        this.splitState = splitState;
    }

    public float getSplitPosition() {
        if (splitPosition == null) {
            splitPosition = DEFAULT_SPLIT_POSITION;
        }
        return splitPosition;
    }

    public void setSplitPosition(Float splitPosition) {
        this.splitPosition = splitPosition;
    }

    public boolean isScheduleColumnVisible(String id, boolean defaultValue) {
        Boolean isVisible = scheduleColumnVisibility == null ? null : scheduleColumnVisibility.get(id);
        return isVisible == null ? defaultValue : isVisible;
    }

    public void setScheduleColumnVisible(String id, boolean visible) {
        if (scheduleColumnVisibility == null) {
            scheduleColumnVisibility = new HashMap<>();
        }

        scheduleColumnVisibility.put(id, visible);
    }

    public boolean isJobColumnVisible(String id, boolean defaultValue) {
        Boolean isVisible = jobColumnVisibility == null ? null : jobColumnVisibility.get(id);
        return isVisible == null ? defaultValue : isVisible;
    }

    public void setJobColumnVisible(String id, boolean visible) {
        if (jobColumnVisibility == null) {
            jobColumnVisibility = new HashMap<>();
        }

        jobColumnVisibility.put(id, visible);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        OperationsProcessesSettings that = (OperationsProcessesSettings) o;
        return xmlVersion == that.xmlVersion &&
                splitState == that.splitState &&
                Objects.equals(splitPosition, that.splitPosition) &&
                Objects.equals(scheduleColumnVisibility, that.scheduleColumnVisibility) &&
                Objects.equals(jobColumnVisibility, that.jobColumnVisibility);
    }

    @Override
    public int hashCode() {

        return Objects.hash(xmlVersion, splitState, splitPosition, scheduleColumnVisibility, jobColumnVisibility);
    }

    public enum SplitState {
        UP,
        DOWN,
        VALUE
    }
}
