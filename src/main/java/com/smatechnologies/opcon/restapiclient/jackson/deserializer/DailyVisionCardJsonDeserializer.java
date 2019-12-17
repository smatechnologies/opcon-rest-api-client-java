package com.smatechnologies.opcon.restapiclient.jackson.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.smatechnologies.opcon.restapiclient.model.MasterVisionTagCard;
import com.smatechnologies.opcon.restapiclient.model.dailyvisioncard.DailyVisionCard;
import com.smatechnologies.opcon.restapiclient.model.dailyvisioncard.DailyVisionGroupCard;
import com.smatechnologies.opcon.restapiclient.model.dailyvisioncard.DailyVisionTagCard;

import java.io.IOException;


/**
 * @author Pierre PINON
 */
public class DailyVisionCardJsonDeserializer extends JsonDeserializer<DailyVisionCard> {

    @Override
    public DailyVisionCard deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec codec = p.getCodec();
        JsonNode jsonNode = codec.readTree(p);

        if ((!jsonNode.has(MasterVisionTagCard.PROPERTY_TAG_PATTERN) || jsonNode.get(MasterVisionTagCard.PROPERTY_TAG_PATTERN).asText() == null)
                || (jsonNode.has(DailyVisionGroupCard.PROPERTY_CHILDREN) && jsonNode.get(DailyVisionGroupCard.PROPERTY_CHILDREN).asText() != null)) {
            return codec.treeToValue(jsonNode, DailyVisionGroupCard.class);
        } else {
            return codec.treeToValue(jsonNode, DailyVisionTagCard.class);
        }
    }
}
