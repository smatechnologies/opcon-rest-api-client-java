package com.smatechnologies.opcon.restapiclient.jackson.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.smatechnologies.opcon.commons.util.XMLSerializer;

import javax.xml.bind.JAXBException;
import java.io.IOException;


/**
 * @author Pierre PINON
 */
public class XmlJsonDeserializer extends JsonDeserializer<Object> {

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String value = p.getText();

        if (value.isEmpty()) {
            return null;
        }

        Object parent = p.getParsingContext().getCurrentValue();
        String fieldName = p.getParsingContext().getCurrentName();

        try {
            Class clazz = parent.getClass().getDeclaredField(fieldName).getType();

            return XMLSerializer.deserialize(clazz, value);
        } catch (NoSuchFieldException | JAXBException e) {
            throw new IOException(e);
        }
    }
}
