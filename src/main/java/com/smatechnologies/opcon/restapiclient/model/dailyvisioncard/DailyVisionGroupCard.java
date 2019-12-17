package com.smatechnologies.opcon.restapiclient.model.dailyvisioncard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.smatechnologies.opcon.restapiclient.jackson.deserializer.DailyVisionCardJsonDeserializer;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * @author Pierre PINON
 */
@JsonIgnoreProperties(value = { DailyVisionCard.PROPERTY_PARENT_DAILY_VISION_CARD, DailyVisionTagCard.PROPERTY_TAG_PATTERN })
public class DailyVisionGroupCard extends DailyVisionCard {

    public static final String RESOURCE = "dailyVisionGroupCard";

    public static final String PROPERTY_CHILDREN = "children";

    @JsonDeserialize(contentUsing = DailyVisionCardJsonDeserializer.class)
    private List<DailyVisionCard> children;

    public List<DailyVisionCard> getChildren() {
        return children;
    }

    public void setChildren(List<DailyVisionCard> children) {
        this.children = children;
    }

    public List<DailyVisionGroupCard> getGroupChildren() {
        return Optional.ofNullable(children)
                .map(children ->
                        children.stream()
                                .filter(child -> child.getType() == TYPE.GROUP)
                                .map(DailyVisionGroupCard.class::cast)
                                .collect(Collectors.toList())
                )
                .orElse(null);
    }

    public List<DailyVisionTagCard> getTagChildren() {
        return Optional.ofNullable(children)
                .map(children ->
                        children.stream()
                                .filter(child -> child.getType() == TYPE.TAG)
                                .map(DailyVisionTagCard.class::cast)
                                .collect(Collectors.toList())
                )
                .orElse(null);
    }

    @Override
    public TYPE getType() {
        return TYPE.GROUP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        DailyVisionGroupCard that = (DailyVisionGroupCard) o;
        return Objects.equals(children, that.children);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), children);
    }
}
