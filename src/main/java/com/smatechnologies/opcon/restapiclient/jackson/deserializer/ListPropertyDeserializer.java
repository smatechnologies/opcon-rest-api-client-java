package com.smatechnologies.opcon.restapiclient.jackson.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.smatechnologies.opcon.commons.util.VersionComparator;
import com.smatechnologies.opcon.restapiclient.DefaultClientBuilder;
import com.smatechnologies.opcon.restapiclient.model.Property;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Jackson's json deserializer for {@link List<Property>}
 *
 * @author Pierre PINON
 */
public class ListPropertyDeserializer extends JsonDeserializer<List<Property>> {

    @Override
    public List<Property> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String apiVersion = (String) ctxt.getAttribute(DefaultClientBuilder.VERSION_ATTRIBUTE);

        List<Property> properties = new ArrayList<>();

        JsonNode jsonNode = p.readValueAsTree();

        if (!jsonNode.isArray()) {
            return null;
        }

        for (JsonNode node : jsonNode) {
            Property property = new Property();

            if (new VersionComparator().compare(apiVersion, "19.1.0") >= 0) {
                property.setKey(node.get("key").asText());
            } else { //Before 19.1.0
                property.setKey(node.get("name").asText());
            }
            property.setValue(node.get("value").asText());

            properties.add(property);
        }

        return properties;
    }
}
