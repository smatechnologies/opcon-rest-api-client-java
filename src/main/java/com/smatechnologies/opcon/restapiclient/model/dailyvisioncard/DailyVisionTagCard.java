package com.smatechnologies.opcon.restapiclient.model.dailyvisioncard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;


/**
 * @author Matthieu COELHO
 */
@JsonIgnoreProperties(value = { DailyVisionCard.PROPERTY_PARENT_DAILY_VISION_CARD, DailyVisionGroupCard.PROPERTY_CHILDREN })
public class DailyVisionTagCard extends DailyVisionCard {

    public static final String RESOURCE = "dailyVisionTagCard";

    public static final String PROPERTY_TAG_PATTERN = "tagPattern";

    private String tagPattern;

    public String getTagPattern() {
        return tagPattern;
    }

    public void setTagPattern(String tagPattern) {
        this.tagPattern = tagPattern;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        DailyVisionTagCard that = (DailyVisionTagCard) o;
        return Objects.equals(tagPattern, that.tagPattern);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tagPattern);
    }

    @Override
    public TYPE getType() {
        return TYPE.TAG;
    }
}
