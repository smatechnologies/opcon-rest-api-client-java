package com.smatechnologies.opcon.restapiclient.model.agentcapability;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;


/**
 * @author Pierre PINON
 */
public enum WindowsAgentCapability implements AgentCapability {
    FILE_WATCHER_V1("fileWatcher.v1"),
    FILE_WATCHER_V2("fileWatcher.v2"),
    CENTRALIZED_SCRIPTS_V1("centralizedScripts.v1"),
    SHELL_EXECUTION_V1("shellExecution.v1"),
    JOB_OUTPUT_PARSING_V1("jobOutputParsing.v1"),
    JOB_OUTPUT_PARSING_V2("jobOutputParsing.v2"),
    ENCRYPTED_TOKENS_V1("encryptedTokens.v1"),
    ENVIRONMENT_VARIABLES_V1("environmentVariables.v1");

    private final String name;

    WindowsAgentCapability(String name) {
        this.name = name;
    }

    @Override
    @JsonValue
    public String getValue() {
        return name;
    }

    @JsonCreator
    public static WindowsAgentCapability fromValue(String value) {
        return Arrays.stream(values())
                .filter(windowsAgentCapability -> windowsAgentCapability.getValue().equals(value))
                .findFirst()
                .orElse(null);
    }
}
