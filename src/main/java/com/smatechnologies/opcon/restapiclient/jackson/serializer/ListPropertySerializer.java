package com.smatechnologies.opcon.restapiclient.jackson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.smatechnologies.opcon.commons.util.VersionComparator;
import com.smatechnologies.opcon.restapiclient.api.OpconApi;
import com.smatechnologies.opcon.restapiclient.model.Property;

import java.io.IOException;
import java.util.List;


/**
 * Jackson's json serializer for {@link List<Property>}
 *
 * @author Pierre PINON
 */
public class ListPropertySerializer extends JsonSerializer<List<Property>> {

    @Override
    public void serialize(List<Property> value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        String apiVersion = (String) serializers.getAttribute(OpconApi.VERSION_ATTRIBUTE);

        if (value == null) {
            return;
        }

        gen.writeStartArray();
        for (Property property : value) {
            gen.writeStartObject();
            if (new VersionComparator().compare(apiVersion, "19.1.0") >= 0) {
                gen.writeStringField(Property.PROPERTY_KEY, property.getKey());
            } else { //Before 19.1.0
                gen.writeStringField(Property.OLD_PROPERTY_NAME, property.getKey());
            }
            gen.writeStringField(Property.PROPERTY_VALUE, property.getValue());
            gen.writeEndObject();
        }
        gen.writeEndArray();
    }
}
