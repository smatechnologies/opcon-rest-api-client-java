package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.smatechnologies.opcon.commons.constants.SystemConstants;

import java.util.Arrays;


/**
 * @author Matthieu COELHO
 * Special status based on JobStatus, it is used to trigger event.
 */

public enum TriggerStatus {
    FINISHED_OK("Finished Ok"),
    FAILED("Failed"),
    EXCEEDED_MAX_RUN_TIME("Exceeded Max Run Time"),
    STILL_ATTEMPTING_START("Still Attempting Start"),
    START_ATTEMPTED("Start Attempted"),
    LATE_TO_FINISH("Late To Finish"),
    LATE_TO_START("Late To Start"),
    MISSED_START_TIME("Missed Start Time"),
    SKIPPED("Skipped");

    private String name;

    TriggerStatus(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @JsonCreator
    public static TriggerStatus fromValue(String value) {
        String valueWithoutUnderscore = value.replace(SystemConstants.UNDERSCORE, SystemConstants.SPACE);
        return Arrays.stream(TriggerStatus.values())
                .filter(status1 -> status1.getName().equalsIgnoreCase(valueWithoutUnderscore))
                .findFirst().orElse(null);
    }
}