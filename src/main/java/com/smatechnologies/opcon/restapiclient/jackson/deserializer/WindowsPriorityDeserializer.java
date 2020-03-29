package com.smatechnologies.opcon.restapiclient.jackson.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.smatechnologies.opcon.commons.util.VersionComparator;
import com.smatechnologies.opcon.restapiclient.DefaultClientBuilder;
import com.smatechnologies.opcon.restapiclient.model.dailyjob.details.WindowsDetails;
import com.smatechnologies.opcon.restapiclient.model.dailyjob.details.WindowsDetails.Priority;

public class WindowsPriorityDeserializer extends JsonDeserializer<WindowsDetails.Priority> {

	@Override
	public Priority deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String apiVersion = (String) ctxt.getAttribute(DefaultClientBuilder.VERSION_ATTRIBUTE);

        JsonNode jsonNode = p.readValueAsTree();
        if (new VersionComparator().compare(apiVersion, "19.1.0") >= 0) {
            Integer iPriority = (Integer) jsonNode.get("id").numberValue();
            for (Priority e : Priority.values()) {
                if (iPriority.equals(e.getId())) 
                   return e;
            }
        } else { //Before 19.1.0
            Integer iPriority = Integer.parseInt(jsonNode.asText());
            for (Priority e : Priority.values()) {
                if (iPriority.equals(e.getId()))
                   return e;
            }
        }
        return null;
	}

}
