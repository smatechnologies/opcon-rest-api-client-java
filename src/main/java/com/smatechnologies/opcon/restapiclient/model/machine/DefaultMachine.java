package com.smatechnologies.opcon.restapiclient.model.machine;

import com.smatechnologies.opcon.restapiclient.model.MachineType;
import com.smatechnologies.opcon.restapiclient.model.agentcapability.DefaultAgentCapability;

import java.util.List;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class DefaultMachine extends Machine {

    private MachineType machineType;
    private List<DefaultAgentCapability> supportedAgentCapability;

    @Override
    public MachineType getType() {
        return machineType;
    }

    public void setType(MachineType machineType) {
        this.machineType = machineType;
    }

    @Override
    public List<DefaultAgentCapability> getSupportedAgentCapability() {
        return supportedAgentCapability;
    }

    public void setSupportedAgentCapability(List<DefaultAgentCapability> supportedAgentCapability) {
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
        DefaultMachine that = (DefaultMachine) o;
        return Objects.equals(supportedAgentCapability, that.supportedAgentCapability);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), supportedAgentCapability);
    }
}
