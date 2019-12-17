package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Map;


/**
 * @author Pierre PINON
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum VisionCardCondition {
    UNKNOWN(3, "Unknown", true),
    CALCULATING(4, "Calculating", true),
    FAILED(100, "Failed", true),
    PARTIAL_FAILED(101, "Partial Failed", true),
    WAITING(102, "Waiting", false),
    RUNNING(103, "Running", false),
    FINISHED_OK(104, "Finished Ok", true),
    LATE_TO_START(1000, "Started Late", true, Sla.Requirement.EXPECTED_START_TIME),
    LATE_TO_FINISH(1001, "Finished Late", true, Sla.Requirement.EXPECTED_END_TIME),
    ESTIMATED_LATE_TO_START(1002, "Estimated Late to Start", true, Sla.Requirement.EXPECTED_START_TIME),
    ESTIMATED_LATE_TO_FINISH(1003, "Estimated Late to Finish", true, Sla.Requirement.EXPECTED_END_TIME);

    public final static String RESOURCE = "condition";

    public final static String PROPERTY_ID = "id";
    public final static String PROPERTY_NAME = "name";

    private final int id;
    @JsonIgnore
    private final String name;
    @JsonIgnore
    private final boolean canBeTriggered;
    @JsonIgnore
    private final Sla.Requirement requiredRequirement;

    VisionCardCondition(int id, String name, boolean canBeTriggered) {
        this(id, name, canBeTriggered, null);
    }

    VisionCardCondition(int id, String name, boolean canBeTriggered, Sla.Requirement requiredRequirement) {
        this.id = id;
        this.name = name;
        this.canBeTriggered = canBeTriggered;
        this.requiredRequirement = requiredRequirement;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isCanBeTriggered() {
        return canBeTriggered;
    }

    public Sla.Requirement getRequiredRequirement() {
        return requiredRequirement;
    }

    @JsonCreator
    public static VisionCardCondition forValues(Map<String, Object> properties) {
        Object idProperty = properties.get(PROPERTY_ID);

        if (idProperty instanceof Integer) {
            Integer id = (Integer) idProperty;

            for (VisionCardCondition value : VisionCardCondition.values()) {
                if (value.getId() == id) {
                    return value;
                }
            }
        }
        return null;
    }
}
