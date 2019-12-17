package com.smatechnologies.opcon.restapiclient.model;

import java.util.List;
import java.util.Objects;


/**
 * @author Matthieu COELHO
 */
public class AssociatedFrequency {

    public static final String RESOURCE = "associatedFrequency";

    public static final String PROPERTY_VISION_FREQUENCY = "visionFrequency";
    public static final String PROPERTY_TRIGGER_CONDITIONS = "triggerConditions";
    public static final String PROPERTY_SLAS = "slas";

    private VisionFrequency visionFrequency;
    private List<TriggerCondition> triggerConditions;
    private List<Sla> slas;

    public VisionFrequency getVisionFrequency() {
        return visionFrequency;
    }

    public void setVisionFrequency(VisionFrequency visionFrequency) {
        this.visionFrequency = visionFrequency;
    }

    public List<TriggerCondition> getTriggerConditions() {
        return triggerConditions;
    }

    public void setTriggerConditions(List<TriggerCondition> triggerConditions) {
        this.triggerConditions = triggerConditions;
    }

    public List<Sla> getSlas() {
        return slas;
    }

    public void setSlas(List<Sla> slas) {
        this.slas = slas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof AssociatedFrequency))
            return false;
        AssociatedFrequency that = (AssociatedFrequency) o;
        return Objects.equals(getVisionFrequency(), that.getVisionFrequency()) &&
                Objects.equals(getTriggerConditions(), that.getTriggerConditions()) &&
                Objects.equals(getSlas(), that.getSlas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVisionFrequency(), getTriggerConditions(), getSlas());
    }
}
