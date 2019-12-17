package com.smatechnologies.opcon.restapiclient.model.dailyjob.details;

import com.smatechnologies.opcon.restapiclient.model.BatchUser;
import com.smatechnologies.opcon.restapiclient.model.dailyjob.details.commons.AdvancedFailureCriteria;
import com.smatechnologies.opcon.restapiclient.model.dailyjob.details.commons.BasicFailureCriteria;
import com.smatechnologies.opcon.restapiclient.model.dailyjob.details.commons.EmbeddedScriptSettings;
import com.smatechnologies.opcon.restapiclient.model.dailyjob.details.commons.EnvironmentVariable;
import com.smatechnologies.opcon.restapiclient.model.dailyjob.details.commons.FileArrivalSettings;
import com.smatechnologies.opcon.restapiclient.model.dailyjob.details.commons.JobOutputParsing;

import java.util.List;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class UNIXDetails {

    public static final String RESOURCE = "details";

    public static final String PROPERTY_BASIC_FAILURE_CRITERIA = "basicFailureCriteria";
    public static final String PROPERTY_SIGNAL = "signals";
    public static final String PROPERTY_START_IMAGE = "startImage";
    public static final String PROPERTY_BATCH_USER = "batchUser";
    public static final String PROPERTY_ADVANCED_FAILURE_CRITERIA = "advancedFailureCriteria";
    public static final String PROPERTY_JOB_OUTPUT_PARSING = "jobOutputParsing";
    public static final String PROPERTY_ENVIRONMENT_VARIABLES = "environmentVariables";
    public static final String PROPERTY_PRERUN = "prerun";
    public static final String PROPERTY_PARAMETERS = "parameters";
    public static final String PROPERTY_NICE_VALUE = "niceValue";
    public static final String PROPERTY_FILE_ARRIVAL_SETTINGS = "fileArrivalSettings";
    public static final String PROPERTY_EMBEDDED_SCRIPT_SETTINGS = "embeddedScriptSettings";
    public static final String PROPERTY_CORE_DUMP = "coreDump";

    private List<BasicFailureCriteria> basicFailureCriteria;
    private List<BasicFailureCriteria> signals;
    private String startImage;
    private BatchUser batchUser;
    private List<AdvancedFailureCriteria> advancedFailureCriteria;
    private List<JobOutputParsing> jobOutputParsing;
    private List<EnvironmentVariable> environmentVariables;
    private String prerun;
    private String parameters;
    private Integer niceValue;
    private FileArrivalSettings fileArrivalSettings;
    private EmbeddedScriptSettings embeddedScriptSettings;
    private Boolean coreDump;

    public List<BasicFailureCriteria> getBasicFailureCriteria() {
        return basicFailureCriteria;
    }

    public void setBasicFailureCriteria(List<BasicFailureCriteria> basicFailureCriteria) {
        this.basicFailureCriteria = basicFailureCriteria;
    }

    public List<BasicFailureCriteria> getSignals() {
        return signals;
    }

    public void setSignals(List<BasicFailureCriteria> signals) {
        this.signals = signals;
    }

    public String getStartImage() {
        return startImage;
    }

    public void setStartImage(String startImage) {
        this.startImage = startImage;
    }

    public BatchUser getBatchUser() {
        return batchUser;
    }

    public void setBatchUser(BatchUser batchUser) {
        this.batchUser = batchUser;
    }

    public List<AdvancedFailureCriteria> getAdvancedFailureCriteria() {
        return advancedFailureCriteria;
    }

    public void setAdvancedFailureCriteria(List<AdvancedFailureCriteria> advancedFailureCriteria) {
        this.advancedFailureCriteria = advancedFailureCriteria;
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

    public String getPrerun() {
        return prerun;
    }

    public void setPrerun(String prerun) {
        this.prerun = prerun;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public Integer getNiceValue() {
        return niceValue;
    }

    public void setNiceValue(Integer niceValue) {
        this.niceValue = niceValue;
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

    public Boolean getCoreDump() {
        return coreDump;
    }

    public void setCoreDump(Boolean coreDump) {
        this.coreDump = coreDump;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UNIXDetails that = (UNIXDetails) o;
        return Objects.equals(basicFailureCriteria, that.basicFailureCriteria) &&
                Objects.equals(signals, that.signals) &&
                Objects.equals(startImage, that.startImage) &&
                Objects.equals(batchUser, that.batchUser) &&
                Objects.equals(advancedFailureCriteria, that.advancedFailureCriteria) &&
                Objects.equals(jobOutputParsing, that.jobOutputParsing) &&
                Objects.equals(environmentVariables, that.environmentVariables) &&
                Objects.equals(prerun, that.prerun) &&
                Objects.equals(parameters, that.parameters) &&
                Objects.equals(niceValue, that.niceValue) &&
                Objects.equals(fileArrivalSettings, that.fileArrivalSettings) &&
                Objects.equals(embeddedScriptSettings, that.embeddedScriptSettings) &&
                Objects.equals(coreDump, that.coreDump);
    }

    @Override
    public int hashCode() {
        return Objects.hash(basicFailureCriteria, signals, startImage, batchUser, advancedFailureCriteria, jobOutputParsing, environmentVariables, prerun, parameters, niceValue, fileArrivalSettings, embeddedScriptSettings, coreDump);
    }
}
