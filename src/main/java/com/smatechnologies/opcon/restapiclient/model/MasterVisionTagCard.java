package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;


/**
 * @author Pierre PINON
 */
@JsonIgnoreProperties(value = { MasterVisionCard.PROPERTY_PARENT_MASTER_VISION_CARD, MasterVisionGroupCard.PROPERTY_CHILDREN })
public class MasterVisionTagCard extends MasterVisionCard {

    public static final String RESOURCE = "masterVisionTagCard";
    public static final String PROPERTY_REMOTE_INSTANCE = "remoteInstance";
    public static final String PROPERTY_TAG_PATTERN = "tagPattern";

    private RemoteInstance remoteInstance;
    private String tagPattern;

    public RemoteInstance getRemoteInstance() {
        return remoteInstance;
    }

    public void setRemoteInstance(RemoteInstance remoteInstance) {
        this.remoteInstance = remoteInstance;
    }

    public String getTagPattern() {
        return tagPattern;
    }

    public void setTagPattern(String tagPattern) {
        this.tagPattern = tagPattern;
    }

    @Override
    public Type getType() {
        return Type.TAG;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof MasterVisionTagCard))
            return false;
        if (!super.equals(o))
            return false;
        MasterVisionTagCard that = (MasterVisionTagCard) o;
        return Objects.equals(getRemoteInstance(), that.getRemoteInstance()) &&
                Objects.equals(getTagPattern(), that.getTagPattern());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getRemoteInstance(), getTagPattern());
    }
}
