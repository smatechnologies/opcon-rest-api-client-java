package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.smatechnologies.opcon.restapiclient.jackson.deserializer.MasterVisionCardJsonDeserializer;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * @author Matthieu COELHO
 */
public class MasterVisionWorkspace {

    public static final String RESOURCE = "masterVisionWorkspace";

    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_MASTER_VISION_CARDS = "masterVisionCards";

    private Integer id;
    private String name;
    @JsonDeserialize(contentUsing = MasterVisionCardJsonDeserializer.class)
    private List<MasterVisionCard> masterVisionCards;

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

    public List<MasterVisionCard> getMasterVisionCards() {
        return masterVisionCards;
    }

    public void setMasterVisionCards(List<MasterVisionCard> masterVisionCards) {
        this.masterVisionCards = masterVisionCards;
    }

    @JsonIgnore
    public List<MasterVisionGroupCard> getMasterVisionGroupCards() {
        return Optional.ofNullable(masterVisionCards)
                .map(masterVisionCards ->
                        masterVisionCards.stream()
                                .filter(masterVisionCard -> masterVisionCard.getType() == MasterVisionCard.Type.GROUP)
                                .map(MasterVisionGroupCard.class::cast)
                                .collect(Collectors.toList())
                )
                .orElse(null);
    }

    @JsonIgnore
    public List<MasterVisionTagCard> getMasterVisionTagCards() {
        return Optional.ofNullable(masterVisionCards)
                .map(masterVisionCards ->
                        masterVisionCards.stream()
                                .filter(masterVisionCard -> masterVisionCard.getType() == MasterVisionCard.Type.TAG)
                                .map(MasterVisionTagCard.class::cast)
                                .collect(Collectors.toList())
                )
                .orElse(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof MasterVisionWorkspace))
            return false;
        MasterVisionWorkspace that = (MasterVisionWorkspace) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getMasterVisionCards(), that.getMasterVisionCards());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getName(), getMasterVisionCards());
    }
}
