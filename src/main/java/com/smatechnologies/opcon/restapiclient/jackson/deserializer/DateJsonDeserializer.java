package com.smatechnologies.opcon.restapiclient.jackson.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.smatechnologies.opcon.commons.deserializer.DateDeserializer;
import com.smatechnologies.opcon.commons.deserializer.DeserializeException;

import java.io.IOException;
import java.util.Date;


/**
 * Jackson's json deserializer for {@link Date}
 *
 * @author Pierre PINON
 * @author Francois EYL
 */
public class DateJsonDeserializer extends JsonDeserializer<Date> {

    private final DateDeserializer dateDeserializer;

    public DateJsonDeserializer() {
        dateDeserializer = new DateDeserializer();
    }

    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        try {
            return dateDeserializer.deserialize(p.getText());
        } catch (DeserializeException e) {
            throw new IOException(e);
        }
    }
}
