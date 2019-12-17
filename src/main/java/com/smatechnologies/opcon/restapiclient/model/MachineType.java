package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smatechnologies.opcon.restapiclient.model.agentcapability.AgentCapability;
import com.smatechnologies.opcon.restapiclient.model.agentcapability.WindowsAgentCapability;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;


/**
 * @author Pierre PINON
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MachineType {
    NULL_MACHINE(0, "Null Machine", null),
    FILE_TRANSFER(1, "File Transfer", null),
    HP_NONSTOP(2, "HP NonStop", null),
    WINDOWS(3, "Windows", WindowsAgentCapability.class),
    OPEN_VMS(4, "OpenVMS", null),
    IBM_I(5, "IBM i", null),
    UNIX(6, "UNIX", null),
    OS_2200(7, "OS 2200", null),
    VSE(8, "VSE", null),
    MCP(9, "MCP", null),
    BIS(11, "BIS", null),
    ZOS(12, "z/OS", null),
    SAP_R3_AND_CRM(13, "SAP R/3 and CRM", null),
    SAP_BW(14, "SAP BW", null),
    JEE(16, "JEE", null),
    JAVA(17, "Java", null),
    TUXEDO_ART(18, "Tuxedo ART (Beta)", null),
    EASE(19, "EASE", null),
    ASYSCO_AMT(20, "Asysco AMT", null),
    SQL(21, "SQL", null);

    public static final String RESOURCE = "machineType";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_DESCRIPTION = "description";

    private final int id;
    @JsonIgnore
    private final String description;
    @JsonIgnore
    private final List<? extends AgentCapability> agentCapability;

    MachineType(int id, String description, Class<? extends AgentCapability> agentCapabilityClass) {
        this.id = id;
        this.description = description;

        this.agentCapability = Optional.ofNullable(agentCapabilityClass)
                .map(Class::getEnumConstants)
                .map(Arrays::asList)
                .orElse(null);
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public List<? extends AgentCapability> getAgentCapability() {
        return agentCapability;
    }

    @JsonCreator
    public static MachineType fromObject(final Map<String, Object> obj) {
        if (obj != null && obj.containsKey("id")) {
            Integer id;
            if (obj.get("id") instanceof Integer) {
                id = (Integer) obj.get("id");
            } else {
                id = Integer.parseInt((String) obj.get("id"));
            }
            if (id != null) {
                for (MachineType e : MachineType.values()) {
                    if (id.equals(e.getId()))
                        return e;
                }
            }
            return null;
        }
        return null;
    }
}
