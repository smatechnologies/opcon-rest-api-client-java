package com.smatechnologies.opcon.restapiclient.jackson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.smatechnologies.opcon.restapiclient.model.TokenisableInteger;

import java.io.IOException;


public class TokenisableIntegerSerializer extends JsonSerializer<TokenisableInteger> {

    @Override
    public void serialize(TokenisableInteger value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        if (value == null) {
            gen.writeNull();
        } else if (!value.isToken()) {
            gen.writeNumber(value.getT());
        } else {
            gen.writeString(value.getToken());
        }
    }
}
