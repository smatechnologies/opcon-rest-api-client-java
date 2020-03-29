package com.smatechnologies.opcon.restapiclient.jackson.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.smatechnologies.opcon.commons.util.VersionComparator;
import com.smatechnologies.opcon.restapiclient.DefaultClientBuilder;
import com.smatechnologies.opcon.restapiclient.model.dailyjob.details.WindowsDetails;
import com.smatechnologies.opcon.restapiclient.model.dailyjob.details.WindowsDetails.Priority;

public class WindowsPrioritySerializer extends JsonSerializer<WindowsDetails.Priority> {

	@Override
	public void serialize(Priority value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        String apiVersion = (String) serializers.getAttribute(DefaultClientBuilder.VERSION_ATTRIBUTE);
		
        System.out.println("apiVersion (" + apiVersion + ")");
        if (value == null) {
           return;
        }
        if (new VersionComparator().compare(apiVersion, "19.1.0") >= 0) {
            gen.writeStartObject();
            gen.writeNumberField("id", value.getId());
            gen.writeStringField("name", value.getName());
            gen.writeEndObject();
        } else { //Before 19.1.0
            gen.writeNumber(value.getId());
        }
	}

}
