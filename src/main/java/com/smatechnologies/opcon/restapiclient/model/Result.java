package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonValue;


/**
 * @author Pierre PINON
 */
public enum Result {
    SUBMITTED("submitted"),
    SUCCESS("success"),
    FAILED("failed");

    private final String value;

    Result(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }
}
