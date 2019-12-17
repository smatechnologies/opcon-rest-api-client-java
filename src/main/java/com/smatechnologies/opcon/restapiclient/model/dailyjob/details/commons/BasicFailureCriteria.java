package com.smatechnologies.opcon.restapiclient.model.dailyjob.details.commons;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class BasicFailureCriteria {

    public static final String RESOURCE = "basicFailureCriteria";

    public static final String PROPERTY_OPERATOR = "operator";
    public static final String PROPERTY_EXIT_CODE = "exitCode";

    private Operator operator;
    private Integer exitCode;

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Integer getExitCode() {
        return exitCode;
    }

    public void setExitCode(Integer exitCode) {
        this.exitCode = exitCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        BasicFailureCriteria that = (BasicFailureCriteria) o;
        return operator == that.operator &&
                Objects.equals(exitCode, that.exitCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operator, exitCode);
    }

    public enum Operator {
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
}
