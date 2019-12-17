package com.smatechnologies.opcon.restapiclient.model.agentcapability;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class DefaultAgentCapability implements AgentCapability {

    private final String name;

    DefaultAgentCapability(String name) {
        this.name = name;
    }

    @Override
    @JsonValue
    public String getValue() {
        return name;
    }

    @JsonCreator
    public static DefaultAgentCapability fromValue(String value) {
        return new DefaultAgentCapability(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DefaultAgentCapability that = (DefaultAgentCapability) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
