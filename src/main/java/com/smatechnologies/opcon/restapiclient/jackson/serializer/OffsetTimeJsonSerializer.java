package com.smatechnologies.opcon.restapiclient.jackson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.smatechnologies.opcon.commons.serializer.OffsetTimeSerializer;
import com.smatechnologies.opcon.commons.serializer.SerializeException;

import java.io.IOException;
import java.time.OffsetTime;


/**
 * Jackson's json serializer for {@link OffsetTime}
 *
 * @author Pierre PINON
 */
public class OffsetTimeJsonSerializer extends JsonSerializer<OffsetTime> {

    private final OffsetTimeSerializer offsetTimeSerializer;

    public OffsetTimeJsonSerializer() {
        offsetTimeSerializer = new OffsetTimeSerializer();
    }

    @Override
    public void serialize(OffsetTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        try {
            gen.writeString(offsetTimeSerializer.serialize(value));
        } catch (SerializeException e) {
            throw new IOException(e);
        }
    }
}
