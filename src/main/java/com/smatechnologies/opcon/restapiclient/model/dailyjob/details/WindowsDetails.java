package com.smatechnologies.opcon.restapiclient.model.dailyjob.details;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smatechnologies.opcon.restapiclient.model.BatchUser;
import com.smatechnologies.opcon.restapiclient.model.dailyjob.details.commons.AdvancedFailureCriteria;
import com.smatechnologies.opcon.restapiclient.model.dailyjob.details.commons.BasicFailureCriteria;
import com.smatechnologies.opcon.restapiclient.model.dailyjob.details.commons.EmbeddedScriptSettings;
import com.smatechnologies.opcon.restapiclient.model.dailyjob.details.commons.EnvironmentVariable;
import com.smatechnologies.opcon.restapiclient.model.dailyjob.details.commons.FileArrivalSettings;
import com.smatechnologies.opcon.restapiclient.model.dailyjob.details.commons.JobOutputParsing;

import java.util.List;
import java.util.Map;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class WindowsDetails {

    public static final String RESOURCE = "details";

    public static final String PROPERTY_BASIC_FAILURE_CRITERIA = "basicFailureCriteria";
    public static final String PROPERTY_PRE_RUN_FAILURE_CRITERIA = "preRunFailureCriteria";
    public static final String PROPERTY_PRIORITY = "priority";
    public static final String PROPERTY_COMMAND_LINE = "commandLine";
    public static final String PROPERTY_WORKING_DIRECTORY = "workingDirectory";
    public static final String PROPERTY_RUNIN_COMMAND_SHELL = "runinCommandShell";
    public static final String PROPERTY_BATCH_USER = "batchUser";
    public static final String PROPERTY_JOB_OUTPUT_PARSING = "jobOutputParsing";
    public static final String PROPERTY_ENVIRONMENT_VARIABLES = "environmentVariables";
    public static final String PROPERTY_ADVANCED_FAILURE_CRITERIA = "advancedFailureCriteria";
    public static final String PROPERTY_PRERUN_COMMAND_LINE = "prerunCommandLine";
    public static final String PROPERTY_PRERUN_WORKING_DIRECTORY = "prerunWorkingDirectory";
    public static final String PROPERTY_APPLICATION_LOG_PATH = "applicationLogPath";
    public static final String PROPERTY_FILE_ARRIVAL_SETTINGS = "fileArrivalSettings";
    public static final String PROPERTY_EMBEDDED_SCRIPT_SETTINGS = "embeddedScriptSettings";
    public static final String PROPERTY_ECOF = "ecof";

    public static final int MAX_CHARS_PRERUN_COMMAND_LINE = 4000;
    public static final int MAX_CHARS_WORKING_DIRECTORY = 255;
    public static final int MAX_CHARS_COMMAND_LINE = 4000;
    public static final int MAX_CHARS_PRERUN_WORKING_DIRECTORY = 255;
    public static final int MAX_CHARS_ECOF = 255;
    public static final int MAX_CHARS_APPLICATION_LOG_PATH = 255;

    private List<BasicFailureCriteria> basicFailureCriteria;
    private BasicFailureCriteria preRunFailureCriteria;
    private Priority jobPriority;
    private String commandLine;
    private String workingDirectory;
    private Boolean runinCommandShell;
    private BatchUser batchUser;
    private List<JobOutputParsing> jobOutputParsing;
    private List<EnvironmentVariable> environmentVariables;
    private List<AdvancedFailureCriteria> advancedFailureCriteria;
    private String prerunCommandLine;
    private String prerunWorkingDirectory;
    private String applicationLogPath;
    private FileArrivalSettings fileArrivalSettings;
    private EmbeddedScriptSettings embeddedScriptSettings;
    private String ecof;

    public List<BasicFailureCriteria> getBasicFailureCriteria() {
        return basicFailureCriteria;
    }

    public void setBasicFailureCriteria(List<BasicFailureCriteria> basicFailureCriteria) {
        this.basicFailureCriteria = basicFailureCriteria;
    }

    public BasicFailureCriteria getPreRunFailureCriteria() {
        return preRunFailureCriteria;
    }

    public void setPreRunFailureCriteria(BasicFailureCriteria preRunFailureCriteria) {
        this.preRunFailureCriteria = preRunFailureCriteria;
    }

    public Priority getJobPriority() {
        return jobPriority;
    }

    public void setJobPriority(Priority jobPriority) {
        this.jobPriority = jobPriority;
    }

    public String getCommandLine() {
        return commandLine;
    }

    public void setCommandLine(String commandLine) {
        this.commandLine = commandLine;
    }

    public String getWorkingDirectory() {
        return workingDirectory;
    }

    public void setWorkingDirectory(String workingDirectory) {
        this.workingDirectory = workingDirectory;
    }

    public Boolean getRuninCommandShell() {
        return runinCommandShell;
    }

    public void setRuninCommandShell(Boolean runinCommandShell) {
        this.runinCommandShell = runinCommandShell;
    }

    public BatchUser getBatchUser() {
        return batchUser;
    }

    public void setBatchUser(BatchUser batchUser) {
        this.batchUser = batchUser;
    }

    public List<JobOutputParsing> getJobOutputParsing() {
        return jobOutputParsing;
    }

    public void setJobOutputParsing(List<JobOutputParsing> jobOutputParsing) {
        this.jobOutputParsing = jobOutputParsing;
    }

    public List<EnvironmentVariable> getEnvironmentVariables() {
        return environmentVariables;
    }

    public void setEnvironmentVariables(List<EnvironmentVariable> environmentVariables) {
        this.environmentVariables = environmentVariables;
    }

    public List<AdvancedFailureCriteria> getAdvancedFailureCriteria() {
        return advancedFailureCriteria;
    }

    public void setAdvancedFailureCriteria(List<AdvancedFailureCriteria> advancedFailureCriteria) {
        this.advancedFailureCriteria = advancedFailureCriteria;
    }

    public String getPrerunCommandLine() {
        return prerunCommandLine;
    }

    public void setPrerunCommandLine(String prerunCommandLine) {
        this.prerunCommandLine = prerunCommandLine;
    }

    public String getPrerunWorkingDirectory() {
        return prerunWorkingDirectory;
    }

    public void setPrerunWorkingDirectory(String prerunWorkingDirectory) {
        this.prerunWorkingDirectory = prerunWorkingDirectory;
    }

    public String getApplicationLogPath() {
        return applicationLogPath;
    }

    public void setApplicationLogPath(String applicationLogPath) {
        this.applicationLogPath = applicationLogPath;
    }

    public FileArrivalSettings getFileArrivalSettings() {
        return fileArrivalSettings;
    }

    public void setFileArrivalSettings(FileArrivalSettings fileArrivalSettings) {
        this.fileArrivalSettings = fileArrivalSettings;
    }

    public EmbeddedScriptSettings getEmbeddedScriptSettings() {
        return embeddedScriptSettings;
    }

    public void setEmbeddedScriptSettings(EmbeddedScriptSettings embeddedScriptSettings) {
        this.embeddedScriptSettings = embeddedScriptSettings;
    }

    public String getEcof() {
        return ecof;
    }

    public void setEcof(String ecof) {
        this.ecof = ecof;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        WindowsDetails that = (WindowsDetails) o;
        return Objects.equals(basicFailureCriteria, that.basicFailureCriteria) &&
                Objects.equals(preRunFailureCriteria, that.preRunFailureCriteria) &&
                Objects.equals(jobPriority, that.jobPriority) &&
                Objects.equals(commandLine, that.commandLine) &&
                Objects.equals(workingDirectory, that.workingDirectory) &&
                Objects.equals(runinCommandShell, that.runinCommandShell) &&
                Objects.equals(batchUser, that.batchUser) &&
                Objects.equals(jobOutputParsing, that.jobOutputParsing) &&
                Objects.equals(environmentVariables, that.environmentVariables) &&
                Objects.equals(advancedFailureCriteria, that.advancedFailureCriteria) &&
                Objects.equals(prerunCommandLine, that.prerunCommandLine) &&
                Objects.equals(prerunWorkingDirectory, that.prerunWorkingDirectory) &&
                Objects.equals(applicationLogPath, that.applicationLogPath) &&
                Objects.equals(fileArrivalSettings, that.fileArrivalSettings) &&
                Objects.equals(embeddedScriptSettings, that.embeddedScriptSettings) &&
                Objects.equals(ecof, that.ecof);
    }

    @Override
    public int hashCode() {
        return Objects.hash(basicFailureCriteria, preRunFailureCriteria, jobPriority, commandLine, workingDirectory, runinCommandShell, batchUser, jobOutputParsing, environmentVariables, advancedFailureCriteria, prerunCommandLine, prerunWorkingDirectory, applicationLogPath, fileArrivalSettings, embeddedScriptSettings, ecof);
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    public enum Priority {
        IDLE(2, "Idle"),
        NORMAL(0, "Normal"),
        HIGH(1, "High"),
        REAL_TIME(3, "RealTime");

        public final static String RESOURCE = "priority";

        private final int id;
        @JsonIgnore
        private final String name;

        Priority(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @JsonCreator
        public static Priority fromObject(final Map<String, Object> obj) {
            if (obj != null && obj.containsKey("id")) {
                Integer id;
                if (obj.get("id") instanceof Integer) {
                    id = (Integer) obj.get("id");
                } else {
                    id = Integer.parseInt((String) obj.get("id"));
                }
                if (id != null) {
                    for (Priority e : Priority.values()) {
                        if (id.equals(e.getId()))
                            return e;
                    }
                }
                return null;
            }
            return null;
        }
    }
}
