package com.smatechnologies.opcon.restapiclient.jackson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.smatechnologies.opcon.commons.util.VersionComparator;
import com.smatechnologies.opcon.restapiclient.api.OpconApi;
import com.smatechnologies.opcon.restapiclient.model.dailyjob.details.WindowsDetails;
import com.smatechnologies.opcon.restapiclient.model.dailyjob.details.WindowsDetails.Priority;

import java.io.IOException;


public class WindowsPrioritySerializer extends JsonSerializer<WindowsDetails.Priority> {

    @Override
    public void serialize(Priority value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        String apiVersion = (String) serializers.getAttribute(OpconApi.VERSION_ATTRIBUTE);

        if (value == null) {
            return;
        }
        if (new VersionComparator().compare(apiVersion, "19.1.0") >= 0) {
            gen.writeStartObject();
            gen.writeNumberField(Priority.PRIORITY_ID, value.getId());
            gen.writeStringField(Priority.PRIORITY_NAME, value.getName());
            gen.writeEndObject();
        } else { //Before 19.1.0
            gen.writeNumber(value.getId());
        }
    }
}
