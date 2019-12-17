package com.smatechnologies.opcon.restapiclient.model.dailyjob.details.commons;

import com.smatechnologies.opcon.restapiclient.model.ScriptVersion;
import com.smatechnologies.opcon.restapiclient.model.script.ScriptRunner;

import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class EmbeddedScriptSettings {

    public static final String RESOURCE = "embeddedScriptSettings";

    public static final String PROPERTY_SCRIPT_VERSION = "scriptVersion";
    public static final String PROPERTY_RUNNER = "runner";
    public static final String PROPERTY_ARGUMENTS = "arguments";

    private ScriptVersion scriptVersion;
    private ScriptRunner runner;
    private String arguments;

    public ScriptVersion getScriptVersion() {
        return scriptVersion;
    }

    public void setScriptVersion(ScriptVersion scriptVersion) {
        this.scriptVersion = scriptVersion;
    }

    public ScriptRunner getRunner() {
        return runner;
    }

    public void setRunner(ScriptRunner runner) {
        this.runner = runner;
    }

    public String getArguments() {
        return arguments;
    }

    public void setArguments(String arguments) {
        this.arguments = arguments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        EmbeddedScriptSettings that = (EmbeddedScriptSettings) o;
        return Objects.equals(scriptVersion, that.scriptVersion) &&
                Objects.equals(runner, that.runner) &&
                Objects.equals(arguments, that.arguments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scriptVersion, runner, arguments);
    }
}
