package com.smatechnologies.opcon.restapiclient.jackson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.smatechnologies.opcon.commons.serializer.SerializeException;
import com.smatechnologies.opcon.commons.serializer.ZonedDateTimeSerializer;

import java.io.IOException;
import java.time.ZonedDateTime;


/**
 * Jackson's json serializer for {@link ZonedDateTime}
 *
 * @author Pierre PINON
 */
public class ZonedDateTimeJsonSerializer extends JsonSerializer<ZonedDateTime> {

    private final ZonedDateTimeSerializer zonedDateTimeSerializer;

    public ZonedDateTimeJsonSerializer() {
        zonedDateTimeSerializer = new ZonedDateTimeSerializer();
    }

    @Override
    public void serialize(ZonedDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        try {
            gen.writeString(zonedDateTimeSerializer.serialize(value));
        } catch (SerializeException e) {
            throw new IOException(e);
        }
    }
}
