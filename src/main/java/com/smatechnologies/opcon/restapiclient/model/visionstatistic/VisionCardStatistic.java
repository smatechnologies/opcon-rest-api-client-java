package com.smatechnologies.opcon.restapiclient.model.visionstatistic;

import com.smatechnologies.opcon.restapiclient.model.RemoteInstance;

import java.util.Objects;


/**
 * @author Matthieu COELHO
 */
public class VisionCardStatistic {

    public static final String RESOURCE = "visionCardStatistics";

    public static final String PROPERTY_CARD_ID = "cardId";
    public static final String PROPERTY_CARD_PATH = "cardPath";
    public static final String PROPERTY_QOS = "qos";
    public static final String PROPERTY_SLA = "sla";
    public static final String PROPERTY_REMOTE_INSTANCE = "remoteInstance";
    public static final String PROPERTY_QOS_STATUS = "qosStatus";
    public static final String PROPERTY_SLA_STATUS = "slaStatus";

    private Integer cardId;
    private String cardPath;
    private Integer qos;
    private Integer sla;
    private RemoteInstance remoteInstance;
    private ThresholdStatus qosStatus;
    private ThresholdStatus slaStatus;

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getCardPath() {
        return cardPath;
    }

    public void setCardPath(String cardPath) {
        this.cardPath = cardPath;
    }

    public Integer getQos() {
        return qos;
    }

    public void setQos(Integer qos) {
        this.qos = qos;
    }

    public Integer getSla() {
        return sla;
    }

    public void setSla(Integer sla) {
        this.sla = sla;
    }

    public ThresholdStatus getQosStatus() {
        return qosStatus;
    }

    public void setQosStatus(ThresholdStatus qosStatus) {
        this.qosStatus = qosStatus;
    }

    public ThresholdStatus getSlaStatus() {
        return slaStatus;
    }

    public void setSlaStatus(ThresholdStatus slaStatus) {
        this.slaStatus = slaStatus;
    }

    public RemoteInstance getRemoteInstance() {
        return remoteInstance;
    }

    public void setRemoteInstance(RemoteInstance remoteInstance) {
        this.remoteInstance = remoteInstance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof VisionCardStatistic))
            return false;
        VisionCardStatistic that = (VisionCardStatistic) o;
        return Objects.equals(getCardId(), that.getCardId()) &&
                Objects.equals(getCardPath(), that.getCardPath()) &&
                Objects.equals(getQos(), that.getQos()) &&
                Objects.equals(getSla(), that.getSla()) &&
                Objects.equals(getRemoteInstance(), that.getRemoteInstance()) &&
                Objects.equals(getQosStatus(), that.getQosStatus()) &&
                Objects.equals(getSlaStatus(), that.getSlaStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCardId(), getCardPath(), getQos(), getSla(), getRemoteInstance(), getQosStatus(), getSlaStatus());
    }
}
