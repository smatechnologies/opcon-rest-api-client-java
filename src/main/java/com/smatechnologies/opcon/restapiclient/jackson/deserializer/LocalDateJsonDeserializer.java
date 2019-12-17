package com.smatechnologies.opcon.restapiclient.jackson.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.smatechnologies.opcon.commons.deserializer.DeserializeException;
import com.smatechnologies.opcon.commons.deserializer.LocalDateDeserializer;

import java.io.IOException;
import java.time.LocalDate;


/**
 * Jackson's json deserializer for {@link LocalDate}
 *
 * @author Pierre PINON
 */
public class LocalDateJsonDeserializer extends JsonDeserializer<LocalDate> {

    private final LocalDateDeserializer localDateDeserializer;

    public LocalDateJsonDeserializer() {
        localDateDeserializer = new LocalDateDeserializer();
    }

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        try {
            return localDateDeserializer.deserialize(p.getText());
        } catch (DeserializeException e) {
            throw new IOException(e);
        }
    }
}
