package com.smatechnologies.opcon.restapiclient.jackson.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.smatechnologies.opcon.restapiclient.model.MasterVisionCard;
import com.smatechnologies.opcon.restapiclient.model.MasterVisionGroupCard;
import com.smatechnologies.opcon.restapiclient.model.MasterVisionTagCard;

import java.io.IOException;


/**
 * @author Pierre PINON
 */
public class MasterVisionCardJsonDeserializer extends JsonDeserializer<MasterVisionCard> {

    @Override
    public MasterVisionCard deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec codec = p.getCodec();
        JsonNode jsonNode = codec.readTree(p);

        if (!jsonNode.has(MasterVisionTagCard.PROPERTY_TAG_PATTERN) || jsonNode.get(MasterVisionTagCard.PROPERTY_TAG_PATTERN).asText() == null) {
            return codec.treeToValue(jsonNode, MasterVisionGroupCard.class);
        } else {
            return codec.treeToValue(jsonNode, MasterVisionTagCard.class);
        }
    }
}
