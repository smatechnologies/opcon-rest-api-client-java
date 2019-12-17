package com.smatechnologies.opcon.restapiclient.jackson.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.smatechnologies.opcon.commons.deserializer.DeserializeException;
import com.smatechnologies.opcon.commons.deserializer.LocalDateTimeDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;


/**
 * Jackson's json deserializer for {@link LocalDateTime}
 *
 * @author Pierre PINON
 */
public class LocalDateTimeJsonDeserializer extends JsonDeserializer<LocalDateTime> {

    private final LocalDateTimeDeserializer localDateTimeDeserializer;

    public LocalDateTimeJsonDeserializer() {
        localDateTimeDeserializer = new LocalDateTimeDeserializer();
    }

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        try {
            return localDateTimeDeserializer.deserialize(p.getText());
        } catch (DeserializeException e) {
            throw new IOException(e);
        }
    }
}
