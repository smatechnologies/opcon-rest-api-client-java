package com.smatechnologies.opcon.restapiclient.model.machine;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smatechnologies.opcon.restapiclient.model.MachineType;
import com.smatechnologies.opcon.restapiclient.model.agentcapability.WindowsAgentCapability;

import java.util.List;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
@JsonIgnoreProperties("type")
public class WindowsMachine extends Machine {

    private List<WindowsAgentCapability> supportedAgentCapability;

    @Override
    public MachineType getType() {
        return MachineType.WINDOWS;
    }

    @Override
    public List<WindowsAgentCapability> getSupportedAgentCapability() {
        return supportedAgentCapability;
    }

    public void setSupportedAgentCapability(List<WindowsAgentCapability> supportedAgentCapability) {
        this.supportedAgentCapability = supportedAgentCapability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        WindowsMachine that = (WindowsMachine) o;
        return Objects.equals(supportedAgentCapability, that.supportedAgentCapability);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), supportedAgentCapability);
    }
}
