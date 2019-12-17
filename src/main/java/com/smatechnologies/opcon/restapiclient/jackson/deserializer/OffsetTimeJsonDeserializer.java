package com.smatechnologies.opcon.restapiclient.jackson.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.smatechnologies.opcon.commons.deserializer.DeserializeException;
import com.smatechnologies.opcon.commons.deserializer.OffsetTimeDeserializer;

import java.io.IOException;
import java.time.OffsetTime;


/**
 * Jackson's json deserializer for {@link OffsetTime}
 *
 * @author Pierre PINON
 */
public class OffsetTimeJsonDeserializer extends JsonDeserializer<OffsetTime> {

    private final OffsetTimeDeserializer offsetTimeDeserializer;

    public OffsetTimeJsonDeserializer() {
        offsetTimeDeserializer = new OffsetTimeDeserializer();
    }

    @Override
    public OffsetTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        try {
            return offsetTimeDeserializer.deserialize(p.getText());
        } catch (DeserializeException e) {
            throw new IOException(e);
        }
    }
}
