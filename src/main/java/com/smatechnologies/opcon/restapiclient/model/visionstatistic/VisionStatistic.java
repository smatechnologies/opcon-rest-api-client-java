package com.smatechnologies.opcon.restapiclient.model.visionstatistic;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


/**
 * @author Matthieu COELHO
 */
public class VisionStatistic {

    public static final String RESOURCE = "visionStatistic";

    public static final String PROPERTY_CARD_ID = "cardId";
    public static final String PROPERTY_QOS = "qos";
    public static final String PROPERTY_SLA = "sla";
    public static final String PROPERTY_QOS_STATUS = "qosStatus";
    public static final String PROPERTY_SLA_STATUS = "slaStatus";
    public static final String PROPERTY_VISION_DAY_STATISTICS = "visionDayStatistics";

    private Integer cardId;
    private Integer qos;
    private Integer sla;
    private ThresholdStatus qosStatus;
    private ThresholdStatus slaStatus;
    private List<VisionDayStatistic> visionDayStatistics;

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
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

    public List<VisionDayStatistic> getVisionDayStatistics() {
        return visionDayStatistics;
    }

    public void setVisionDayStatistics(List<VisionDayStatistic> visionDayStatistics) {
        this.visionDayStatistics = visionDayStatistics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof VisionStatistic))
            return false;
        VisionStatistic that = (VisionStatistic) o;
        return Objects.equals(getCardId(), that.getCardId()) &&
                Objects.equals(getQos(), that.getQos()) &&
                Objects.equals(getSla(), that.getSla()) &&
                Objects.equals(getQosStatus(), that.getQosStatus()) &&
                Objects.equals(getSlaStatus(), that.getSlaStatus()) &&
                Objects.equals(getVisionDayStatistics(), that.getVisionDayStatistics());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCardId(), getQos(), getSla(), getQosStatus(), getSlaStatus(), getVisionDayStatistics());
    }

    public static class VisionDayStatistic {

        public static final String PROPERTY_VISION_DATE = "visionDate";
        public static final String PROPERTY_QOS = "qos";
        public static final String PROPERTY_SLA = "sla";
        public static final String PROPERTY_QOS_STATUS = "qosStatus";
        public static final String PROPERTY_SLA_STATUS = "slaStatus";

        private LocalDate visionDate;
        private Integer cardId;
        private Integer qos;
        private Integer sla;
        private ThresholdStatus qosStatus;
        private ThresholdStatus slaStatus;

        public LocalDate getVisionDate() {
            return visionDate;
        }

        public void setVisionDate(LocalDate visionDate) {
            this.visionDate = visionDate;
        }

        public Integer getCardId() {
            return cardId;
        }

        public void setCardId(Integer cardId) {
            this.cardId = cardId;
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

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof VisionDayStatistic))
                return false;
            VisionDayStatistic that = (VisionDayStatistic) o;
            return Objects.equals(getVisionDate(), that.getVisionDate()) &&
                    Objects.equals(getCardId(), that.getCardId()) &&
                    Objects.equals(getQos(), that.getQos()) &&
                    Objects.equals(getSla(), that.getSla()) &&
                    Objects.equals(getQosStatus(), that.getQosStatus()) &&
                    Objects.equals(getSlaStatus(), that.getSlaStatus());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getVisionDate(), getCardId(), getQos(), getSla(), getQosStatus(), getSlaStatus());
        }
    }

}
