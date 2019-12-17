package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Objects;

import static com.smatechnologies.opcon.restapiclient.model.MasterVisionCard.PROPERTY_PARENT_MASTER_VISION_CARD;


/**
 * @author pierre PINON
 */
@JsonIgnoreProperties(value = { PROPERTY_PARENT_MASTER_VISION_CARD, MasterVisionGroupCard.PROPERTY_CHILDREN, MasterVisionTagCard.PROPERTY_TAG_PATTERN })
public abstract class MasterVisionCard {

    public static final String RESOURCE = "masterVisionCard";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_TRACK_ID = "trackId";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_OFFSET = "offset";
    public static final String PROPERTY_ASSOCIATED_FREQUENCIES = "associatedFrequencies";
    public static final String PROPERTY_ASSOCIATED_ROLES = "associatedRoles";
    public static final String PROPERTY_QOS_TOLERABLE_THRESHOLD = "qosTolerableThreshold";
    public static final String PROPERTY_QOS_CRITICAL_THRESHOLD = "qosCriticalThreshold";
    public static final String PROPERTY_SLA_TOLERABLE_THRESHOLD = "slaTolerableThreshold";
    public static final String PROPERTY_SLA_CRITICAL_THRESHOLD = "slaCriticalThreshold";

    protected static final String PROPERTY_PARENT_MASTER_VISION_CARD = "parentMasterVisionCard";

    public static final String NAME_VALID_CHARS = "*?'|:;%&<>()[]{},+=\"!";

    private Integer id;
    private String trackId;
    private String name;
    private String description;
    private Integer offset;
    private List<AssociatedFrequency> associatedFrequencies;
    private List<Role> associatedRoles;
    private Integer qosTolerableThreshold;
    private Integer qosCriticalThreshold;
    private Integer slaTolerableThreshold;
    private Integer slaCriticalThreshold;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public List<AssociatedFrequency> getAssociatedFrequencies() {
        return associatedFrequencies;
    }

    public void setAssociatedFrequencies(List<AssociatedFrequency> associatedFrequencies) {
        this.associatedFrequencies = associatedFrequencies;
    }

    public List<Role> getAssociatedRoles() {
        return associatedRoles;
    }

    public void setAssociatedRoles(List<Role> associatedRoles) {
        this.associatedRoles = associatedRoles;
    }

    public Integer getQosTolerableThreshold() {
        return qosTolerableThreshold;
    }

    public void setQosTolerableThreshold(Integer qosTolerableThreshold) {
        this.qosTolerableThreshold = qosTolerableThreshold;
    }

    public Integer getQosCriticalThreshold() {
        return qosCriticalThreshold;
    }

    public void setQosCriticalThreshold(Integer qosCriticalThreshold) {
        this.qosCriticalThreshold = qosCriticalThreshold;
    }

    public Integer getSlaTolerableThreshold() {
        return slaTolerableThreshold;
    }

    public void setSlaTolerableThreshold(Integer slaTolerableThreshold) {
        this.slaTolerableThreshold = slaTolerableThreshold;
    }

    public Integer getSlaCriticalThreshold() {
        return slaCriticalThreshold;
    }

    public void setSlaCriticalThreshold(Integer slaCriticalThreshold) {
        this.slaCriticalThreshold = slaCriticalThreshold;
    }

    @JsonIgnore
    public abstract Type getType();

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MasterVisionCard that = (MasterVisionCard) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(trackId, that.trackId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(offset, that.offset) &&
                Objects.equals(associatedFrequencies, that.associatedFrequencies) &&
                Objects.equals(associatedRoles, that.associatedRoles) &&
                Objects.equals(qosTolerableThreshold, that.qosTolerableThreshold) &&
                Objects.equals(qosCriticalThreshold, that.qosCriticalThreshold) &&
                Objects.equals(slaTolerableThreshold, that.slaTolerableThreshold) &&
                Objects.equals(slaCriticalThreshold, that.slaCriticalThreshold);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, trackId, name, description, offset, associatedFrequencies, associatedRoles, qosTolerableThreshold, qosCriticalThreshold, slaTolerableThreshold, slaCriticalThreshold);
    }

    public enum Type {
        GROUP,
        TAG
    }
}
