package com.smatechnologies.opcon.restapiclient.jackson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.smatechnologies.opcon.commons.serializer.DateSerializer;
import com.smatechnologies.opcon.commons.serializer.SerializeException;

import java.io.IOException;
import java.util.Date;


/**
 * Jackson's json serializer for {@link Date}
 *
 * @author Pierre PINON
 * @author Francois EYL
 */
public class DateJsonSerializer extends JsonSerializer<Date> {

    private final DateSerializer dateSerializer;

    public DateJsonSerializer() {
        dateSerializer = new DateSerializer();
    }

    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        try {
            gen.writeString(dateSerializer.serialize(value));
        } catch (SerializeException e) {
            throw new IOException(e);
        }
    }
}
