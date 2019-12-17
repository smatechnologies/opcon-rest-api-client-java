package com.smatechnologies.opcon.restapiclient.model;

/**
 * @author Francois EYL
 */
public class ComputedDuration {

    public static final String RESOURCE = "computedDuration";

    public static final String PROPERTY_DURATION = "duration";
    public static final String PROPERTY_IS_ESTIMATED = "isEstimated";

    private Long duration;
    private Boolean isEstimated;

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Boolean getIsEstimated() {
        return isEstimated;
    }

    public void setIsEstimated(Boolean estimated) {
        isEstimated = estimated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ComputedDuration that = (ComputedDuration) o;

        if (duration != null ? !duration.equals(that.duration) : that.duration != null)
            return false;
        return isEstimated != null ? isEstimated.equals(that.isEstimated) : that.isEstimated == null;

    }

    @Override
    public int hashCode() {
        int result = duration != null ? duration.hashCode() : 0;
        result = 31 * result + (isEstimated != null ? isEstimated.hashCode() : 0);
        return result;
    }
}
