package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;


/**
 * @author Matthieu COELHO
 */
public class EventTrigger {

    public static final String RESOURCE = "eventTrigger";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_TYPE = "type";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_LSAM_FEEDBACK = "LSAMFeedBack";
    public static final String PROPERTY_LSAM_STRING_TO_MATCH = "LSAMStringToMatch";
    public static final String PROPERTY_EXIT_COMPARISON_OPERATOR = "exitComparisonOperator";
    public static final String PROPERTY_EXIT_VALUE = "exitValue";
    public static final String PROPERTY_EXIT_VALUE_RANGE_START = "exitValueRangeStart";
    public static final String PROPERTY_EXIT_VALUE_RANGE_END = "exitValueRangeEnd";
    public static final String PROPERTY_EXPRESSION = "expression";
    public static final String PROPERTY_EVENT = "event";
    public static final String PROPERTY_FREQUENCY_LEVEL = "frequencyLevel";

    private Integer id;
    private Type type;
    private TriggerStatus status;
    private LSAMFeedBack lsamFeedBack;
    private String lsamStringToMatch;
    private ComparisonOperator exitComparisonOperator;
    private String exitValue;
    private String exitValueStart;
    private String exitValueEnd;
    private String expression;
    private String event;
    private Boolean frequencyLevel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public TriggerStatus getStatus() {
        return status;
    }

    public void setStatus(TriggerStatus status) {
        this.status = status;
    }

    public LSAMFeedBack getLsamFeedBack() {
        return lsamFeedBack;
    }

    public void setLsamFeedBack(LSAMFeedBack lsamFeedBack) {
        this.lsamFeedBack = lsamFeedBack;
    }

    public String getLsamStringToMatch() {
        return lsamStringToMatch;
    }

    public void setLsamStringToMatch(String lsamStringToMatch) {
        this.lsamStringToMatch = lsamStringToMatch;
    }

    public ComparisonOperator getExitComparisonOperator() {
        return exitComparisonOperator;
    }

    public void setExitComparisonOperator(ComparisonOperator exitComparisonOperator) {
        this.exitComparisonOperator = exitComparisonOperator;
    }

    public String getExitValue() {
        return exitValue;
    }

    public void setExitValue(String exitValue) {
        this.exitValue = exitValue;
    }

    public String getExitValueStart() {
        return exitValueStart;
    }

    public void setExitValueStart(String exitValueStart) {
        this.exitValueStart = exitValueStart;
    }

    public String getExitValueEnd() {
        return exitValueEnd;
    }

    public void setExitValueEnd(String exitValueEnd) {
        this.exitValueEnd = exitValueEnd;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Boolean getFrequencyLevel() {
        return frequencyLevel;
    }

    public void setFrequencyLevel(Boolean frequencyLevel) {
        this.frequencyLevel = frequencyLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof EventTrigger))
            return false;
        EventTrigger that = (EventTrigger) o;
        return Objects.equals(getId(), that.getId()) &&
                getType() == that.getType() &&
                getStatus() == that.getStatus() &&
                Objects.equals(getLsamFeedBack(), that.getLsamFeedBack()) &&
                Objects.equals(getLsamStringToMatch(), that.getLsamStringToMatch()) &&
                getExitComparisonOperator() == that.getExitComparisonOperator() &&
                Objects.equals(getExitValue(), that.getExitValue()) &&
                Objects.equals(getExitValueStart(), that.getExitValueStart()) &&
                Objects.equals(getExitValueEnd(), that.getExitValueEnd()) &&
                Objects.equals(getExpression(), that.getExpression()) &&
                Objects.equals(getEvent(), that.getEvent()) &&
                Objects.equals(getFrequencyLevel(), that.getFrequencyLevel());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getType(), getStatus(), getLsamFeedBack(), getLsamStringToMatch(), getExitComparisonOperator(), getExitValue(), getExitValueStart(), getExitValueEnd(), getExpression(), getEvent(), getFrequencyLevel());
    }

    public enum Type {
        JOB_STATUS("jobStatus"),
        LSAM_FEEDBACK("LSAMFeedback"),
        EXIT_DESCRIPTION("exitDescription"),
        JOB_COMPLETION_COMPLEX_EXPRESSION("jobCompletionComplexExpression");

        private final String name;

        Type(String name) {
            this.name = name;
        }

        @JsonValue
        public String getName() {
            return name;
        }
    }

    public static class LSAMFeedBack {

        public static final String RESOURCE = "lsamFeedBack";
        public static final String PROPERTY_ID = "id";
        public static final String PROPERTY_NAME = "name";

        private Integer id;
        private String name;

        public LSAMFeedBack() {

        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof LSAMFeedBack))
                return false;
            LSAMFeedBack that = (LSAMFeedBack) o;
            return Objects.equals(getId(), that.getId()) &&
                    Objects.equals(getName(), that.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }

    public enum ComparisonOperator {
        EQUAL("EQ"),
        CONTAIN("IN"),
        GREATER_THAN("GT"),
        GREATER_THAN_OR_EQUAL("GE"),
        LESS_THAN("LT"),
        LESS_THAN_OR_EQUAL("LE"),
        NOT_EQUAL_TO("NE"),
        RANGE("RG");

        private final String value;

        ComparisonOperator(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }
    }
}
