package com.smatechnologies.opcon.restapiclient.jackson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.smatechnologies.opcon.commons.serializer.LocalDateSerializer;
import com.smatechnologies.opcon.commons.serializer.SerializeException;

import java.io.IOException;
import java.time.LocalDate;


/**
 * Jackson's json serializer for {@link LocalDate} *
 *
 * @author Pierre PINON
 */
public class LocalDateJsonSerializer extends JsonSerializer<LocalDate> {

    private final LocalDateSerializer localDateSerializer;

    public LocalDateJsonSerializer() {
        localDateSerializer = new LocalDateSerializer();
    }

    @Override
    public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        try {
            gen.writeString(localDateSerializer.serialize(value));
        } catch (SerializeException e) {
            throw new IOException(e);
        }
    }
}
