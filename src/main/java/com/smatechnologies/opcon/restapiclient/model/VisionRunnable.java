package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


/**
 * @author Matthieu COELHO
 */
public class VisionRunnable {

    public static final String RESOURCE = "trigger";

    public static final String PROPERTY_REMOTE_INSTANCE = "remoteInstance";
    public static final String PROPERTY_VISION_ACTIONS = "action";
    public static final String PROPERTY_REPEAT_AFTER_MINUTES = "repeatAfterMinutes";

    private RemoteInstance remoteInstance;
    @JsonProperty("action")
    private VisionAction visionAction;
    private Integer repeatAfterMinutes;

    public RemoteInstance getRemoteInstance() {
        return remoteInstance;
    }

    public void setRemoteInstance(RemoteInstance remoteInstance) {
        this.remoteInstance = remoteInstance;
    }

    public VisionAction getVisionAction() {
        return visionAction;
    }

    public void setVisionAction(VisionAction visionAction) {
        this.visionAction = visionAction;
    }

    public Integer getRepeatAfterMinutes() {
        return repeatAfterMinutes;
    }

    public void setRepeatAfterMinutes(Integer repeatAfterMinutes) {
        this.repeatAfterMinutes = repeatAfterMinutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof VisionRunnable))
            return false;
        VisionRunnable that = (VisionRunnable) o;
        return Objects.equals(getRemoteInstance(), that.getRemoteInstance()) &&
                Objects.equals(getVisionAction(), that.getVisionAction()) &&
                Objects.equals(getRepeatAfterMinutes(), that.getRepeatAfterMinutes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRemoteInstance(), getVisionAction(), getRepeatAfterMinutes());
    }
}
