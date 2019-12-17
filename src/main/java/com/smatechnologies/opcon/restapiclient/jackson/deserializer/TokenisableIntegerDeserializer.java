package com.smatechnologies.opcon.restapiclient.jackson.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.smatechnologies.opcon.restapiclient.model.TokenisableInteger;

import java.io.IOException;


/**
 * @author Pierre PINON
 */
public class TokenisableIntegerDeserializer extends JsonDeserializer<TokenisableInteger> {

    @Override
    public TokenisableInteger deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        if (p.getCurrentToken() == JsonToken.VALUE_NULL) {
            return null;
        } else if (p.getCurrentToken() == JsonToken.VALUE_NUMBER_INT) {
            return new TokenisableInteger(p.getIntValue());
        } else if (p.getCurrentToken() == JsonToken.VALUE_STRING) {
            return new TokenisableInteger(p.getText());
        } else {
            throw new IOException("Field should be an Integer or a String");
        }
    }
}
