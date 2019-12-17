package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.smatechnologies.opcon.restapiclient.jackson.deserializer.MasterVisionCardJsonDeserializer;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * @author Pierre PINON
 */
@JsonIgnoreProperties(value = { MasterVisionCard.PROPERTY_PARENT_MASTER_VISION_CARD, MasterVisionTagCard.PROPERTY_TAG_PATTERN })
public class MasterVisionGroupCard extends MasterVisionCard {

    public static final String RESOURCE = "masterVisionGroupCard";

    public static final String PROPERTY_CHILDREN = "children";

    @JsonDeserialize(contentUsing = MasterVisionCardJsonDeserializer.class)
    private List<MasterVisionCard> children;

    public List<MasterVisionCard> getChildren() {
        return children;
    }

    public void setChildren(List<MasterVisionCard> children) {
        this.children = children;
    }

    @JsonIgnore
    public List<MasterVisionGroupCard> getGroupChildren() {
        return Optional.ofNullable(children)
                .map(children ->
                        children.stream()
                                .filter(child -> child.getType() == Type.GROUP)
                                .map(MasterVisionGroupCard.class::cast)
                                .collect(Collectors.toList())
                )
                .orElse(null);
    }

    @JsonIgnore
    public List<MasterVisionTagCard> getTagChildren() {
        return Optional.ofNullable(children)
                .map(children ->
                        children.stream()
                                .filter(child -> child.getType() == Type.TAG)
                                .map(MasterVisionTagCard.class::cast)
                                .collect(Collectors.toList())
                )
                .orElse(null);
    }

    @Override
    public Type getType() {
        return Type.GROUP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        MasterVisionGroupCard that = (MasterVisionGroupCard) o;
        return Objects.equals(children, that.children);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), children);
    }
}
