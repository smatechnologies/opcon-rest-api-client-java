package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;


/**
 * @author Matthieu COELHO
 */
public class TriggerCondition {

    public static final String RESOURCE = "triggerCondition";

    public static final String PROPERTY_CONDITION = "condition";
    public static final String PROPERTY_RUNNABLES = "runnables";

    private VisionCardCondition condition;
    @JsonProperty("runnables")
    private List<VisionRunnable> visionRunnables;

    public VisionCardCondition getCondition() {
        return condition;
    }

    public void setCondition(VisionCardCondition condition) {
        this.condition = condition;
    }

    public List<VisionRunnable> getVisionRunnables() {
        return visionRunnables;
    }

    public void setVisionRunnables(List<VisionRunnable> visionRunnables) {
        this.visionRunnables = visionRunnables;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof TriggerCondition))
            return false;
        TriggerCondition that = (TriggerCondition) o;
        return getCondition() == that.getCondition() &&
                Objects.equals(getVisionRunnables(), that.getVisionRunnables());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCondition(), getVisionRunnables());
    }
}
