package com.smatechnologies.opcon.restapiclient.jackson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.smatechnologies.opcon.commons.util.XMLSerializer;

import javax.xml.bind.JAXBException;
import java.io.IOException;


/**
 * @author Pierre PINON
 */
public class XmlJsonSerializer extends JsonSerializer<Object> {

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        try {
            gen.writeString(XMLSerializer.serialize(value));
        } catch (JAXBException e) {
            throw new IOException(e);
        }
    }
}
