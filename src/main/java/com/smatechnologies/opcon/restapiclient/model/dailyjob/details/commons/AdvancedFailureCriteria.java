package com.smatechnologies.opcon.restapiclient.model.dailyjob.details.commons;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class AdvancedFailureCriteria {

    public static final String RESOURCE = "advancedFailureCriteria";

    public static final String PROPERTY_OPERATOR = "operator";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_END_VALUE = "endValue";
    public static final String PROPERTY_RESULT = "result";
    public static final String PROPERTY_BOOLEAN_OPERATOR = "booleanOperator";

    private Operator operator;
    private Integer value;
    private Integer endValue;
    private Result result;
    private BooleanOperator booleanOperator;

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getEndValue() {
        return endValue;
    }

    public void setEndValue(Integer endValue) {
        this.endValue = endValue;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public BooleanOperator getBooleanOperator() {
        return booleanOperator;
    }

    public void setBooleanOperator(BooleanOperator booleanOperator) {
        this.booleanOperator = booleanOperator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        AdvancedFailureCriteria that = (AdvancedFailureCriteria) o;
        return operator == that.operator &&
                Objects.equals(value, that.value) &&
                Objects.equals(endValue, that.endValue) &&
                result == that.result &&
                booleanOperator == that.booleanOperator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(operator, value, endValue, result, booleanOperator);
    }

    public enum Result {
        FAIL("Fail"),
        FINISH_OK("Finish OK");

        private final String value;

        Result(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public enum Operator {
        RANGE("RG", "↔"),
        EQUAL("EQ", "="),
        NOT_EQUAL("NE", "≠"),
        GREATER_THAN("GT", ">"),
        LESS_THAN("LT", "<"),
        GREATER_THAN_OR_EQUAL("GE", "≥"),
        LESS_THAN_OR_EQUAL("LE", "≤");

        private final String value;
        private final String sign;

        Operator(String value, String sign) {
            this.value = value;
            this.sign = sign;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        public String getSign() {
            return sign;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public enum BooleanOperator {
        AND("AND"),
        OR("OR");

        private final String value;

        BooleanOperator(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
