package com.smatechnologies.opcon.restapiclient.jackson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.smatechnologies.opcon.commons.serializer.LocalDateTimeSerializer;
import com.smatechnologies.opcon.commons.serializer.SerializeException;

import java.io.IOException;
import java.time.LocalDateTime;


/**
 * Jackson's json serializer for {@link LocalDateTime}
 *
 * @author Pierre PINON
 */
public class LocalDateTimeJsonSerializer extends JsonSerializer<LocalDateTime> {

    private final LocalDateTimeSerializer localDateTimeSerializer;

    public LocalDateTimeJsonSerializer() {
        localDateTimeSerializer = new LocalDateTimeSerializer();
    }

    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        try {
            gen.writeString(localDateTimeSerializer.serialize(value));
        } catch (SerializeException e) {
            throw new IOException(e);
        }
    }
}
