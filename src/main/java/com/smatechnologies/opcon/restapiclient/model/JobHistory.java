package com.smatechnologies.opcon.restapiclient.model;

import com.smatechnologies.opcon.restapiclient.model.machine.Machine;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;


/**
 * @author Matthieu COELHO
 */
public class JobHistory {

    public static final String RESOURCE = "jobHistory";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_JOB_NAME = "jobName";
    public static final String PROPERTY_JOB_NUMBER = "jobNumber";
    public static final String PROPERTY_SCHEDULE_HISTORY = "scheduleHistory";
    public static final String PROPERTY_JOB_START_TIME = "jobStartTime";
    public static final String PROPERTY_JOB_STATUS = "jobStatus";
    public static final String PROPERTY_JOB_TERMINATION = "jobTermination";
    public static final String PROPERTY_DURATION = "duration";
    public static final String PROPERTY_MACHINE = "machine";
    public static final String PROPERTY_EXIT_CODE = "exitCode";
    public static final String PROPERTY_DEPARTMENT = "department";
    public static final String PROPERTY_JORS_REQUEST_PARAMETERS = "jorsRequestParameters";
    public static final String PROPERTY_FREQUENCY = "frequency";
    public static final String PROPERTY_TOKEN_REPLACEMENT_VALUES = "tokenReplacementValues";
    public static final String PROPERTY_TAGS = "tags";
    public static final String PROPERTY_JOB_TYPE = "jobType";
    public static final String PROPERTY_AGENT_START_COMMAND = "agentStartCommand";
    public static final String PROPERTY_DETAILS_MESSAGES = "detailsMessages";
    public static final String PROPERTY_JOB_HISTORY_NOTES = "jobHistoryNotes";

    private String id;
    private String jobName;
    private Integer jobNumber;
    private DailySchedule scheduleHistory;
    private ZonedDateTime jobStartTime;
    private JobStatus jobStatus;
    private ZonedDateTime jobTermination;
    private Long duration;
    private Machine machine;
    private String exitCode;
    private Department department;
    private String jorsRequestParameters;
    private Frequency frequency;
    private List<TokenReplacementValue> tokenReplacementValues;
    private List<String> tags;
    private JobType jobType;
    private String agentStartCommand;
    private List<String> detailsMessages;
    private List<String> jobHistoryNotes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Integer getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(Integer jobNumber) {
        this.jobNumber = jobNumber;
    }

    public DailySchedule getScheduleHistory() {
        return scheduleHistory;
    }

    public void setScheduleHistory(DailySchedule scheduleHistory) {
        this.scheduleHistory = scheduleHistory;
    }

    public ZonedDateTime getJobStartTime() {
        return jobStartTime;
    }

    public void setJobStartTime(ZonedDateTime jobStartTime) {
        this.jobStartTime = jobStartTime;
    }

    public JobStatus getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(JobStatus jobStatus) {
        this.jobStatus = jobStatus;
    }

    public ZonedDateTime getJobTermination() {
        return jobTermination;
    }

    public void setJobTermination(ZonedDateTime jobTermination) {
        this.jobTermination = jobTermination;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public String getExitCode() {
        return exitCode;
    }

    public void setExitCode(String exitCode) {
        this.exitCode = exitCode;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getJorsRequestParameters() {
        return jorsRequestParameters;
    }

    public void setJorsRequestParameters(String jorsRequestParameters) {
        this.jorsRequestParameters = jorsRequestParameters;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public List<TokenReplacementValue> getTokenReplacementValues() {
        return tokenReplacementValues;
    }

    public void setTokenReplacementValues(List<TokenReplacementValue> tokenReplacementValues) {
        this.tokenReplacementValues = tokenReplacementValues;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public String getAgentStartCommand() {
        return agentStartCommand;
    }

    public void setAgentStartCommand(String agentStartCommand) {
        this.agentStartCommand = agentStartCommand;
    }

    public List<String> getDetailsMessages() {
        return detailsMessages;
    }

    public void setDetailsMessages(List<String> detailsMessages) {
        this.detailsMessages = detailsMessages;
    }

    public List<String> getJobHistoryNotes() {
        return jobHistoryNotes;
    }

    public void setJobHistoryNotes(List<String> jobHistoryNotes) {
        this.jobHistoryNotes = jobHistoryNotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        JobHistory that = (JobHistory) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(jobName, that.jobName) &&
                Objects.equals(jobNumber, that.jobNumber) &&
                Objects.equals(scheduleHistory, that.scheduleHistory) &&
                Objects.equals(jobStartTime, that.jobStartTime) &&
                Objects.equals(jobStatus, that.jobStatus) &&
                Objects.equals(jobTermination, that.jobTermination) &&
                Objects.equals(duration, that.duration) &&
                Objects.equals(machine, that.machine) &&
                Objects.equals(exitCode, that.exitCode) &&
                Objects.equals(department, that.department) &&
                Objects.equals(jorsRequestParameters, that.jorsRequestParameters) &&
                Objects.equals(frequency, that.frequency) &&
                Objects.equals(tokenReplacementValues, that.tokenReplacementValues) &&
                Objects.equals(tags, that.tags) &&
                jobType == that.jobType &&
                Objects.equals(agentStartCommand, that.agentStartCommand) &&
                Objects.equals(detailsMessages, that.detailsMessages) &&
                Objects.equals(jobHistoryNotes, that.jobHistoryNotes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, jobName, jobNumber, scheduleHistory, jobStartTime, jobStatus, jobTermination, duration, machine, exitCode, department, jorsRequestParameters, frequency, tokenReplacementValues, tags, jobType, agentStartCommand, detailsMessages, jobHistoryNotes);
    }

    public static class TokenReplacementValue {

        public static final String RESOURCE = "tokenReplacementValue";

        public static final String PROPERTY_TOKEN = "token";
        public static final String PROPERTY_VALUE = "value";
        private String token;
        private String value;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            TokenReplacementValue that = (TokenReplacementValue) o;
            return Objects.equals(token, that.token) &&
                    Objects.equals(value, that.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(token, value);
        }
    }
}
