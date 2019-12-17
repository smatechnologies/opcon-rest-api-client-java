package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.smatechnologies.opcon.restapiclient.jackson.deserializer.DailyVisionCardJsonDeserializer;
import com.smatechnologies.opcon.restapiclient.model.dailyvisioncard.DailyVisionCard;
import com.smatechnologies.opcon.restapiclient.model.dailyvisioncard.DailyVisionGroupCard;
import com.smatechnologies.opcon.restapiclient.model.dailyvisioncard.DailyVisionTagCard;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * @author Matthieu COELHO
 */
public class DailyVisionWorkspace {

    public static final String RESOURCE = "dailyVisionWorkspace";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DAILY_VISION_CARDS = "dailyVisionCards";

    private Integer id;
    private String name;
    @JsonDeserialize(contentUsing = DailyVisionCardJsonDeserializer.class)
    private List<DailyVisionCard> dailyVisionCards;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DailyVisionCard> getDailyVisionCards() {
        return dailyVisionCards;
    }

    public void setDailyVisionCards(List<DailyVisionCard> dailyVisionCards) {
        this.dailyVisionCards = dailyVisionCards;
    }

    public List<DailyVisionGroupCard> getDailyVisionGroupCards() {
        return Optional.ofNullable(dailyVisionCards)
                .map(dailyVisionCards ->
                        dailyVisionCards.stream()
                                .filter(dailyVisionCard -> dailyVisionCard.getType() == DailyVisionCard.TYPE.GROUP)
                                .map(DailyVisionGroupCard.class::cast)
                                .collect(Collectors.toList())
                )
                .orElse(null);
    }

    public List<DailyVisionTagCard> getDailyVisionTagCards() {
        return Optional.ofNullable(dailyVisionCards)
                .map(dailyVisionCards ->
                        dailyVisionCards.stream()
                                .filter(dailyVisionCard -> dailyVisionCard.getType() == DailyVisionCard.TYPE.TAG)
                                .map(DailyVisionTagCard.class::cast)
                                .collect(Collectors.toList())
                )
                .orElse(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof DailyVisionWorkspace))
            return false;
        DailyVisionWorkspace that = (DailyVisionWorkspace) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getDailyVisionCards(), that.getDailyVisionCards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDailyVisionCards());
    }
}
