package com.smatechnologies.opcon.restapiclient.jackson.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.smatechnologies.opcon.commons.deserializer.DeserializeException;
import com.smatechnologies.opcon.commons.deserializer.ZonedDateTimeDeserializer;

import java.io.IOException;
import java.time.ZonedDateTime;


/**
 * Jackson's json deserializer for {@link ZonedDateTime}
 *
 * @author Pierre PINON
 */
public class ZonedDateTimeJsonDeserializer extends JsonDeserializer<ZonedDateTime> {

    private final ZonedDateTimeDeserializer zonedDateTimeDeserializer;

    public ZonedDateTimeJsonDeserializer() {
        zonedDateTimeDeserializer = new ZonedDateTimeDeserializer();
    }

    @Override
    public ZonedDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        try {
            return zonedDateTimeDeserializer.deserialize(p.getText());
        } catch (DeserializeException e) {
            throw new IOException(e);
        }
    }
}
