package com.smatechnologies.opcon.restapiclient.model.dailyjob;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import com.smatechnologies.opcon.restapiclient.jackson.NestedStdTypeResolverBuilder;
import com.smatechnologies.opcon.restapiclient.model.AccessCode;
import com.smatechnologies.opcon.restapiclient.model.ComputedDuration;
import com.smatechnologies.opcon.restapiclient.model.ComputedEndTime;
import com.smatechnologies.opcon.restapiclient.model.ComputedStartTime;
import com.smatechnologies.opcon.restapiclient.model.DailySchedule;
import com.smatechnologies.opcon.restapiclient.model.Department;
import com.smatechnologies.opcon.restapiclient.model.Dependency;
import com.smatechnologies.opcon.restapiclient.model.Event;
import com.smatechnologies.opcon.restapiclient.model.Frequency;
import com.smatechnologies.opcon.restapiclient.model.JobStatus;
import com.smatechnologies.opcon.restapiclient.model.JobType;
import com.smatechnologies.opcon.restapiclient.model.MachineGroup;
import com.smatechnologies.opcon.restapiclient.model.Property;
import com.smatechnologies.opcon.restapiclient.model.Resource;
import com.smatechnologies.opcon.restapiclient.model.Threshold;
import com.smatechnologies.opcon.restapiclient.model.TriggerStatus;
import com.smatechnologies.opcon.restapiclient.model.machine.Machine;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


/**
 * Resource describing a daily Job in OpCon.
 *
 * @author Francois EYL
 * @author Pierre PINON
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "jobType.description", defaultImpl = DefaultDailyJob.class)
@JsonTypeResolver(NestedStdTypeResolverBuilder.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = WindowsDailyJob.class, name = "Windows"),
        @JsonSubTypes.Type(value = UNIXDailyJob.class, name = "UNIX"),
        @JsonSubTypes.Type(value = ContainerDailyJob.class, name = "Container")
})
public abstract class DailyJob {

    public static final String RESOURCE = "dailyJob";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_UID = "uid";
    public static final String PROPERTY_SCHEDULE = "schedule";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_FREQUENCY = "frequency";
    public static final String PROPERTY_PRIORITY = "priority";
    public static final String PROPERTY_JOB_TYPE = "jobType";
    public static final String PROPERTY_DEPARTMENT = "department";
    public static final String PROPERTY_ACCESS_CODE = "accessCode";
    public static final String PROPERTY_MACHINE = "startMachine";
    public static final String PROPERTY_PRIMARY_MACHINE = "primaryMachine";
    public static final String PROPERTY_ALTERNATE_MACHINE = "alternateMachine";
    public static final String PROPERTY_ALTERNATE_MACHINE_2 = "alternateMachine2";
    public static final String PROPERTY_ALTERNATE_MACHINE_3 = "alternateMachine3";
    public static final String PROPERTY_MACHINE_GROUP = "machineGroup";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_COMPUTED_START_TIME = "computedStartTime";
    public static final String PROPERTY_COMPUTED_DURATION = "computedDuration";
    public static final String PROPERTY_COMPUTED_END_TIME = "computedEndTime";
    public static final String PROPERTY_TERMINATION_DESCRIPTION = "terminationDescription";
    public static final String PROPERTY_JOB_NUMBER = "jobNumber";
    public static final String PROPERTY_INCIDENT_TICKET_ID = "incidentTicketId";
    public static final String PROPERTY_INCIDENT_TICKET_URL = "incidentTicketURL";
    public static final String PROPERTY_JORS_REQUEST_PARAMETERS = "jorsRequestParameters";
    public static final String PROPERTY_STEPS = "steps";
    public static final String PROPERTY_DOCUMENTATION = "documentation";
    public static final String PROPERTY_RESOURCE_DEPENDENCIES = "resourceDependencies";
    public static final String PROPERTY_THRESHOLD_DEPENDENCIES = "thresholdDependencies";
    public static final String PROPERTY_RESOURCE_UPDATES = "resourceUpdates";
    public static final String PROPERTY_THRESHOLD_UPDATES = "thresholdUpdates";
    public static final String PROPERTY_DEPENDENCIES = "dependencies";
    public static final String PROPERTY_EXPRESSION_DEPENDENCIES = "expressionDependencies";
    public static final String PROPERTY_EVENTS_TRIGGERS = "eventTriggers";
    public static final String PROPERTY_FEEDBACK = "feedback";
    public static final String PROPERTY_TAGS = "tags";
    public static final String PROPERTY_PROPERTIES = "properties";
    public static final String PROPERTY_IS_RECURRENT = "isRecurrent";
    public static final String PROPERTY_DETAIL_MESSAGES = "detailMessages";
    public static final String PROPERTY_UNIQUE_JOB_ID = "uniqueJobId";

    private String id;
    private Integer uid;
    private DailySchedule schedule;
    private String name;
    private Frequency frequency;
    private Integer priority;
    private JobType jobType;
    private Department department;
    private AccessCode accessCode;
    private Machine startMachine;
    private Machine primaryMachine;
    private Machine alternateMachine;
    private Machine alternateMachine2;
    private Machine alternateMachine3;
    private MachineGroup machineGroup;
    private JobStatus status;
    private String terminationDescription;
    private ComputedStartTime computedStartTime;
    private ComputedEndTime computedEndTime;
    private ComputedDuration computedDuration;
    private Integer jobNumber;
    private String incidentTicketId;
    private String incidentTicketURL;
    private String jorsRequestParameters;
    private List<String> steps;
    private Documentation documentation;
    private List<ResourceDependency> resourceDependencies;
    private List<ThresholdDependency> thresholdDependencies;
    private List<ResourceUpdate> resourceUpdates;
    private List<ThresholdUpdate> thresholdUpdates;
    private List<Dependency> dependencies;
    private ExpressionDependencies expressionDependencies;
    private List<Event> events;
    private Feedback feedback;
    private List<String> tags;
    private List<Property> properties;
    private Boolean isRecurrent;
    private List<String> detailMessages;
    private String uniqueJobId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public AccessCode getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(AccessCode accessCode) {
        this.accessCode = accessCode;
    }

    public Machine getPrimaryMachine() {
        return primaryMachine;
    }

    public void setPrimaryMachine(Machine primaryMachine) {
        this.primaryMachine = primaryMachine;
    }

    public Machine getAlternateMachine() {
        return alternateMachine;
    }

    public void setAlternateMachine(Machine alternateMachine) {
        this.alternateMachine = alternateMachine;
    }

    public Machine getAlternateMachine2() {
        return alternateMachine2;
    }

    public void setAlternateMachine2(Machine alternateMachine2) {
        this.alternateMachine2 = alternateMachine2;
    }

    public Machine getAlternateMachine3() {
        return alternateMachine3;
    }

    public void setAlternateMachine3(Machine alternateMachine3) {
        this.alternateMachine3 = alternateMachine3;
    }

    public MachineGroup getMachineGroup() {
        return machineGroup;
    }

    public void setMachineGroup(MachineGroup machineGroup) {
        this.machineGroup = machineGroup;
    }

    public Machine getStartMachine() {
        return startMachine;
    }

    public void setStartMachine(Machine startMachine) {
        this.startMachine = startMachine;
    }

    public DailySchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(DailySchedule schedule) {
        this.schedule = schedule;
    }

    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }

    public String getTerminationDescription() {
        return terminationDescription;
    }

    public void setTerminationDescription(String terminationDescription) {
        this.terminationDescription = terminationDescription;
    }

    public ComputedStartTime getComputedStartTime() {
        return computedStartTime;
    }

    public void setComputedStartTime(ComputedStartTime computedStartTime) {
        this.computedStartTime = computedStartTime;
    }

    public ComputedEndTime getComputedEndTime() {
        return computedEndTime;
    }

    public void setComputedEndTime(ComputedEndTime computedEndTime) {
        this.computedEndTime = computedEndTime;
    }

    public ComputedDuration getComputedDuration() {
        return computedDuration;
    }

    public void setComputedDuration(ComputedDuration computedDuration) {
        this.computedDuration = computedDuration;
    }

    public Integer getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(Integer jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getIncidentTicketId() {
        return incidentTicketId;
    }

    public void setIncidentTicketId(String incidentTicketId) {
        this.incidentTicketId = incidentTicketId;
    }

    public String getIncidentTicketURL() {
        return incidentTicketURL;
    }

    public void setIncidentTicketURL(String incidentTicketURL) {
        this.incidentTicketURL = incidentTicketURL;
    }

    public String getJorsRequestParameters() {
        return jorsRequestParameters;
    }

    public void setJorsRequestParameters(String jorsRequestParameters) {
        this.jorsRequestParameters = jorsRequestParameters;
    }

    public boolean isStatusWaiting() {
        return Optional.ofNullable(getStatus())
                .map(JobStatus::getCategory)
                .map(JobStatus.JobStatusCategory::isWaiting)
                .orElse(false);
    }

    public boolean isStatusNeverRan() {
        return Optional.ofNullable(getStatus())
                .map(JobStatus::getCategory)
                .map(JobStatus.JobStatusCategory::isNeverRan)
                .orElse(false);
    }

    public boolean isStatusFinishedOk() {
        return Optional.ofNullable(getStatus())
                .map(JobStatus::getCategory)
                .map(JobStatus.JobStatusCategory::isFinishedOk)
                .orElse(false);
    }

    public boolean isStatusFailed() {
        return Optional.ofNullable(getStatus())
                .map(JobStatus::getCategory)
                .map(JobStatus.JobStatusCategory::isFailed)
                .orElse(false);
    }

    public boolean isStatusEnded() {
        return Optional.ofNullable(getStatus())
                .map(JobStatus::getCategory)
                .map(JobStatus.JobStatusCategory::isEnded)
                .orElse(false);
    }

    public boolean isStatusTerminated() {
        return Optional.ofNullable(getStatus())
                .map(JobStatus::getCategory)
                .map(JobStatus.JobStatusCategory::isTerminated)
                .orElse(false);
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    public Documentation getDocumentation() {
        return documentation;
    }

    public void setDocumentation(Documentation documentation) {
        this.documentation = documentation;
    }

    public List<ResourceDependency> getResourceDependencies() {
        return resourceDependencies;
    }

    public void setResourceDependencies(List<ResourceDependency> resourceDependencies) {
        this.resourceDependencies = resourceDependencies;
    }

    public List<ThresholdDependency> getThresholdDependencies() {
        return thresholdDependencies;
    }

    public void setThresholdDependencies(List<ThresholdDependency> thresholdDependencies) {
        this.thresholdDependencies = thresholdDependencies;
    }

    public List<ResourceUpdate> getResourceUpdates() {
        return resourceUpdates;
    }

    public void setResourceUpdates(List<ResourceUpdate> resourceUpdates) {
        this.resourceUpdates = resourceUpdates;
    }

    public List<ThresholdUpdate> getThresholdUpdates() {
        return thresholdUpdates;
    }

    public void setThresholdUpdates(List<ThresholdUpdate> thresholdUpdates) {
        this.thresholdUpdates = thresholdUpdates;
    }

    public List<Dependency> getDependencies() {
		return dependencies;
	}

	public void setDependencies(List<Dependency> dependencies) {
		this.dependencies = dependencies;
	}

	public ExpressionDependencies getExpressionDependencies() {
        return expressionDependencies;
    }

    public void setExpressionDependencies(ExpressionDependencies expressionDependencies) {
        this.expressionDependencies = expressionDependencies;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public Boolean getIsRecurrent() {
        return isRecurrent;
    }

    public void setIsRecurrent(Boolean isRecurrent) {
        this.isRecurrent = isRecurrent;
    }

    public Boolean getRecurrent() {
        return isRecurrent;
    }

    public void setRecurrent(Boolean recurrent) {
        isRecurrent = recurrent;
    }

    public List<String> getDetailMessages() {
        return detailMessages;
    }

    public void setDetailMessages(List<String> detailMessages) {
        this.detailMessages = detailMessages;
    }

    public String getUniqueJobId() {
        return uniqueJobId;
    }

    public void setUniqueJobId(String uniqueJobId) {
        this.uniqueJobId = uniqueJobId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DailyJob dailyJob = (DailyJob) o;
        return Objects.equals(id, dailyJob.id) &&
                Objects.equals(uid, dailyJob.uid) &&
                Objects.equals(schedule, dailyJob.schedule) &&
                Objects.equals(name, dailyJob.name) &&
                Objects.equals(frequency, dailyJob.frequency) &&
                Objects.equals(priority, dailyJob.priority) &&
                jobType == dailyJob.jobType &&
                Objects.equals(department, dailyJob.department) &&
                Objects.equals(accessCode, dailyJob.accessCode) &&
                Objects.equals(startMachine, dailyJob.startMachine) &&
                Objects.equals(primaryMachine, dailyJob.primaryMachine) &&
                Objects.equals(alternateMachine, dailyJob.alternateMachine) &&
                Objects.equals(alternateMachine2, dailyJob.alternateMachine2) &&
                Objects.equals(alternateMachine3, dailyJob.alternateMachine3) &&
                Objects.equals(machineGroup, dailyJob.machineGroup) &&
                Objects.equals(status, dailyJob.status) &&
                Objects.equals(terminationDescription, dailyJob.terminationDescription) &&
                Objects.equals(computedStartTime, dailyJob.computedStartTime) &&
                Objects.equals(computedEndTime, dailyJob.computedEndTime) &&
                Objects.equals(computedDuration, dailyJob.computedDuration) &&
                Objects.equals(jobNumber, dailyJob.jobNumber) &&
                Objects.equals(incidentTicketId, dailyJob.incidentTicketId) &&
                Objects.equals(incidentTicketURL, dailyJob.incidentTicketURL) &&
                Objects.equals(jorsRequestParameters, dailyJob.jorsRequestParameters) &&
                Objects.equals(steps, dailyJob.steps) &&
                Objects.equals(documentation, dailyJob.documentation) &&
                Objects.equals(resourceDependencies, dailyJob.resourceDependencies) &&
                Objects.equals(thresholdDependencies, dailyJob.thresholdDependencies) &&
                Objects.equals(resourceUpdates, dailyJob.resourceUpdates) &&
                Objects.equals(thresholdUpdates, dailyJob.thresholdUpdates) &&
                Objects.equals(expressionDependencies, dailyJob.expressionDependencies) &&
                Objects.equals(events, dailyJob.events) &&
                Objects.equals(feedback, dailyJob.feedback) &&
                Objects.equals(tags, dailyJob.tags) &&
                Objects.equals(properties, dailyJob.properties) &&
                Objects.equals(isRecurrent, dailyJob.isRecurrent) &&
                Objects.equals(detailMessages, dailyJob.detailMessages) &&
                Objects.equals(uniqueJobId, dailyJob.uniqueJobId);
    }

    @Override
    public int hashCode() {
        return Objects
                .hash(id, uid, schedule, name, frequency, priority, jobType, department, accessCode, startMachine, primaryMachine, alternateMachine, alternateMachine2, alternateMachine3, machineGroup, status, terminationDescription, computedStartTime, computedEndTime, computedDuration, jobNumber, incidentTicketId, incidentTicketURL, jorsRequestParameters, steps, documentation, resourceDependencies, thresholdDependencies, resourceUpdates, thresholdUpdates, expressionDependencies, events, feedback,
                        tags,
                        properties, isRecurrent, detailMessages, uniqueJobId);
    }

    public static class Documentation {

        public static final String RESOURCE = "documentation";

        public static final String PROPERTY_ID = "id";
        public static final String PROPERTY_JOB = "job";
        public static final String PROPERTY_FREQUENCY = "frequency";

        private Integer id;
        private String job;
        private String frequency;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public String getFrequency() {
            return frequency;
        }

        public void setFrequency(String frequency) {
            this.frequency = frequency;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Documentation that = (Documentation) o;
            return Objects.equals(id, that.id) &&
                    Objects.equals(job, that.job) &&
                    Objects.equals(frequency, that.frequency);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, job, frequency);
        }
    }

    public static class ResourceDependency {

        public static final String RESOURCE = "resourceDependency";

        public static final String PROPERTY_ID = "id";
        public static final String PROPERTY_RESOURCE = "resource";
        public static final String PROPERTY_REQUIRES = "requires";
        public static final String PROPERTY_REQUIRES_ALL = "requiresAll";

        private Integer id;
        private Resource resource;
        private Integer requires;
        private Boolean requiresAll;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Resource getResource() {
            return resource;
        }

        public void setResource(Resource resource) {
            this.resource = resource;
        }

        public Integer getRequires() {
            return requires;
        }

        public void setRequires(Integer requires) {
            this.requires = requires;
        }

        public Boolean getRequiresAll() {
            return requiresAll;
        }

        public void setRequiresAll(Boolean requiresAll) {
            this.requiresAll = requiresAll;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof ResourceDependency))
                return false;

            ResourceDependency that = (ResourceDependency) o;

            if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null)
                return false;
            if (getResource() != null ? !getResource().equals(that.getResource()) : that.getResource() != null)
                return false;
            if (getRequires() != null ? !getRequires().equals(that.getRequires()) : that.getRequires() != null)
                return false;
            return getRequiresAll() != null ? getRequiresAll().equals(that.getRequiresAll()) : that.getRequiresAll() == null;
        }

        @Override
        public int hashCode() {
            int result = getId() != null ? getId().hashCode() : 0;
            result = 31 * result + (getResource() != null ? getResource().hashCode() : 0);
            result = 31 * result + (getRequires() != null ? getRequires().hashCode() : 0);
            result = 31 * result + (getRequiresAll() != null ? getRequiresAll().hashCode() : 0);
            return result;
        }
    }

    public static class ThresholdDependency {

        public static final String RESOURCE = "thresholdDependency";

        public static final String PROPERTY_ID = "id";
        public static final String PROPERTY_THRESHOLD = "threshold";
        public static final String PROPERTY_VALUE = "value";
        public static final String PROPERTY_OPERATOR = "operator";

        private Integer id;
        private Threshold threshold;
        private Integer value;
        private Operator operator;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Threshold getThreshold() {
            return threshold;
        }

        public void setThreshold(Threshold threshold) {
            this.threshold = threshold;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Operator getOperator() {
            return operator;
        }

        public void setOperator(Operator operator) {
            this.operator = operator;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof ThresholdDependency))
                return false;

            ThresholdDependency that = (ThresholdDependency) o;

            if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null)
                return false;
            if (getThreshold() != null ? !getThreshold().equals(that.getThreshold()) : that.getThreshold() != null)
                return false;
            if (getValue() != null ? !getValue().equals(that.getValue()) : that.getValue() != null)
                return false;
            return getOperator() == that.getOperator();
        }

        @Override
        public int hashCode() {
            int result = getId() != null ? getId().hashCode() : 0;
            result = 31 * result + (getThreshold() != null ? getThreshold().hashCode() : 0);
            result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
            result = 31 * result + (getOperator() != null ? getOperator().hashCode() : 0);
            return result;
        }
    }

    public enum Operator {
        GREATER_THAN(">"),
        LESS_THAN("<"),
        EQUAL("="),
        NOT_EQUAL("!=", "≠"),
        GREATER_THAN_OR_EQUAL(">=", "≥"),
        LESS_THAN_OR_EQUAL("<=", "≤");

        private final String value;
        private final String representation;

        Operator(String value) {
            this.value = value;
            this.representation = null;
        }

        Operator(String value, String representation) {
            this.value = value;
            this.representation = representation;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return representation != null ? representation : value;
        }
    }

    public static class ThresholdUpdate {

        public static final String RESOURCE = "thresholdUpdate";
        public static final String PROPERTY_STATUS = "status";
        public static final String PROPERTY_THRESHOLD = "threshold";
        public static final String PROPERTY_VALUE = "value";
        public static final String PROPERTY_FREQUENCY_LEVEL = "frequencyLevel";

        private Threshold threshold;
        private Integer value;
        private Boolean frequencyLevel;
        private TriggerStatus status;

        public ThresholdUpdate() {

        }

        public Threshold getThreshold() {
            return threshold;
        }

        public void setThreshold(Threshold threshold) {
            this.threshold = threshold;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Boolean getFrequencyLevel() {
            return frequencyLevel;
        }

        public void setFrequencyLevel(Boolean frequencyLevel) {
            this.frequencyLevel = frequencyLevel;
        }

        public TriggerStatus getStatus() {
            return status;
        }

        public void setStatus(TriggerStatus status) {
            this.status = status;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof ThresholdUpdate))
                return false;

            ThresholdUpdate that = (ThresholdUpdate) o;

            if (getThreshold() != null ? !getThreshold().equals(that.getThreshold()) : that.getThreshold() != null)
                return false;
            if (getValue() != null ? !getValue().equals(that.getValue()) : that.getValue() != null)
                return false;
            if (getFrequencyLevel() != null ? !getFrequencyLevel().equals(that.getFrequencyLevel()) : that.getFrequencyLevel() != null)
                return false;
            return getStatus() != null ? getStatus().equals(that.getStatus()) : that.getStatus() == null;
        }

        @Override
        public int hashCode() {
            int result = getThreshold() != null ? getThreshold().hashCode() : 0;
            result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
            result = 31 * result + (getFrequencyLevel() != null ? getFrequencyLevel().hashCode() : 0);
            result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
            return result;
        }
    }

    public static class ResourceUpdate {

        public static final String RESOURCE = "resourceUpdate";

        public static final String PROPERTY_STATUS = "status";
        public static final String PROPERTY_RESOURCE = "resource";
        public static final String PROPERTY_VALUE = "value";
        public static final String PROPERTY_FREQUENCY_LEVEL = "frequencyLevel";

        private Resource resource;
        private Integer value;
        private Boolean frequencyLevel;
        private TriggerStatus status;

        public ResourceUpdate() {

        }

        public Resource getResource() {
            return resource;
        }

        public void setResource(Resource resource) {
            this.resource = resource;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Boolean getFrequencyLevel() {
            return frequencyLevel;
        }

        public void setFrequencyLevel(Boolean frequencyLevel) {
            this.frequencyLevel = frequencyLevel;
        }

        public TriggerStatus getStatus() {
            return status;
        }

        public void setStatus(TriggerStatus status) {
            this.status = status;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof ResourceUpdate))
                return false;

            ResourceUpdate that = (ResourceUpdate) o;

            if (getResource() != null ? !getResource().equals(that.getResource()) : that.getResource() != null)
                return false;
            if (getValue() != null ? !getValue().equals(that.getValue()) : that.getValue() != null)
                return false;
            if (getFrequencyLevel() != null ? !getFrequencyLevel().equals(that.getFrequencyLevel()) : that.getFrequencyLevel() != null)
                return false;
            return getStatus() != null ? getStatus().equals(that.getStatus()) : that.getStatus() == null;
        }

        @Override
        public int hashCode() {
            int result = getResource() != null ? getResource().hashCode() : 0;
            result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
            result = 31 * result + (getFrequencyLevel() != null ? getFrequencyLevel().hashCode() : 0);
            result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
            return result;
        }
    }

    public static class Feedback {

        public static final String RESOURCE = "feedback";

        public static final String PROPERTY_JOB_STATUS_DESCRIPTION = "jobStatusDescription";
        public static final String PROPERTY_TOTAL_PROCESSOR_TIME = "totalProcessorTime";
        public static final String PROPERTY_USER_PROCESSOR_TIME = "userProcessorTime";
        public static final String PROPERTY_VIRTUAL_MEMORY_SIZE = "virtualMemorySize";
        public static final String PROPERTY_PHYSICAL_MEMORY_SIZE = "physicalMemorySize";
        public static final String PROPERTY_JOB_END_TIME = "jobEndTime";
        public static final String PROPERTY_PROCESSOR_USAGE = "processorUsage";
        public static final String PROPERTY_IO_DATA_OPERATIONS_PER_SEC = "ioDataOperationsPerSec";
        public static final String PROPERTY_IO_OTHER_BYTES_PER_SEC = "ioOtherBytesPerSec";
        public static final String PROPERTY_IO_DATA_BYTES_PER_SEC = "ioDataBytesPerSec";
        public static final String PROPERTY_IO_OTHER_OPERATIONS_PER_SEC = "ioOtherOperationsPerSec";
        public static final String PROPERTY_IO_READ_BYTES_PER_SEC = "ioReadBytesPerSec";
        public static final String PROPERTY_IO_READ_OPERATIONS_PER_SEC = "ioReadOperationsPerSec";
        public static final String PROPERTY_IO_WRITE_BYTES_PER_SEC = "ioWriteBytesPerSec";
        public static final String PROPERTY_IO_WRITE_OPERATIONS_PER_SEC = "ioWriteOperationsPerSec";

        private List<String> jobStatusDescription;
        private String totalProcessorTime;
        private String userProcessorTime;
        private String virtualMemorySize;
        private String physicalMemorySize;
        private String jobEndTime;
        private String processorUsage;
        private String ioDataBytesPerSec;
        private String ioDataOperationsPerSec;
        private String ioOtherBytesPerSec;
        private String ioOtherOperationsPerSec;
        private String ioReadBytesPerSec;
        private String ioReadOperationsPerSec;
        private String ioWriteBytesPerSec;
        private String ioWriteOperationsPerSec;

        public List<String> getJobStatusDescription() {
            return jobStatusDescription;
        }

        public void setJobStatusDescription(List<String> jobStatusDescription) {
            this.jobStatusDescription = jobStatusDescription;
        }

        public String getTotalProcessorTime() {
            return totalProcessorTime;
        }

        public void setTotalProcessorTime(String totalProcessorTime) {
            this.totalProcessorTime = totalProcessorTime;
        }

        public String getUserProcessorTime() {
            return userProcessorTime;
        }

        public void setUserProcessorTime(String userProcessorTime) {
            this.userProcessorTime = userProcessorTime;
        }

        public String getVirtualMemorySize() {
            return virtualMemorySize;
        }

        public void setVirtualMemorySize(String virtualMemorySize) {
            this.virtualMemorySize = virtualMemorySize;
        }

        public String getPhysicalMemorySize() {
            return physicalMemorySize;
        }

        public void setPhysicalMemorySize(String physicalMemorySize) {
            this.physicalMemorySize = physicalMemorySize;
        }

        public String getJobEndTime() {
            return jobEndTime;
        }

        public void setJobEndTime(String jobEndTime) {
            this.jobEndTime = jobEndTime;
        }

        public String getProcessorUsage() {
            return processorUsage;
        }

        public void setProcessorUsage(String processorUsage) {
            this.processorUsage = processorUsage;
        }

        public String getIoDataBytesPerSec() {
            return ioDataBytesPerSec;
        }

        public void setIoDataBytesPerSec(String ioDataBytesPerSec) {
            this.ioDataBytesPerSec = ioDataBytesPerSec;
        }

        public String getIoDataOperationsPerSec() {
            return ioDataOperationsPerSec;
        }

        public void setIoDataOperationsPerSec(String ioDataOperationsPerSec) {
            this.ioDataOperationsPerSec = ioDataOperationsPerSec;
        }

        public String getIoOtherBytesPerSec() {
            return ioOtherBytesPerSec;
        }

        public void setIoOtherBytesPerSec(String ioOtherBytesPerSec) {
            this.ioOtherBytesPerSec = ioOtherBytesPerSec;
        }

        public String getIoOtherOperationsPerSec() {
            return ioOtherOperationsPerSec;
        }

        public void setIoOtherOperationsPerSec(String ioOtherOperationsPerSec) {
            this.ioOtherOperationsPerSec = ioOtherOperationsPerSec;
        }

        public String getIoReadBytesPerSec() {
            return ioReadBytesPerSec;
        }

        public void setIoReadBytesPerSec(String ioReadBytesPerSec) {
            this.ioReadBytesPerSec = ioReadBytesPerSec;
        }

        public String getIoReadOperationsPerSec() {
            return ioReadOperationsPerSec;
        }

        public void setIoReadOperationsPerSec(String ioReadOperationsPerSec) {
            this.ioReadOperationsPerSec = ioReadOperationsPerSec;
        }

        public String getIoWriteBytesPerSec() {
            return ioWriteBytesPerSec;
        }

        public void setIoWriteBytesPerSec(String ioWriteBytesPerSec) {
            this.ioWriteBytesPerSec = ioWriteBytesPerSec;
        }

        public String getIoWriteOperationsPerSec() {
            return ioWriteOperationsPerSec;
        }

        public void setIoWriteOperationsPerSec(String ioWriteOperationsPerSec) {
            this.ioWriteOperationsPerSec = ioWriteOperationsPerSec;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Feedback feedback = (Feedback) o;
            return Objects.equals(jobStatusDescription, feedback.jobStatusDescription) &&
                    Objects.equals(totalProcessorTime, feedback.totalProcessorTime) &&
                    Objects.equals(userProcessorTime, feedback.userProcessorTime) &&
                    Objects.equals(virtualMemorySize, feedback.virtualMemorySize) &&
                    Objects.equals(physicalMemorySize, feedback.physicalMemorySize) &&
                    Objects.equals(jobEndTime, feedback.jobEndTime) &&
                    Objects.equals(processorUsage, feedback.processorUsage) &&
                    Objects.equals(ioDataBytesPerSec, feedback.ioDataBytesPerSec) &&
                    Objects.equals(ioDataOperationsPerSec, feedback.ioDataOperationsPerSec) &&
                    Objects.equals(ioOtherBytesPerSec, feedback.ioOtherBytesPerSec) &&
                    Objects.equals(ioOtherOperationsPerSec, feedback.ioOtherOperationsPerSec) &&
                    Objects.equals(ioReadBytesPerSec, feedback.ioReadBytesPerSec) &&
                    Objects.equals(ioReadOperationsPerSec, feedback.ioReadOperationsPerSec) &&
                    Objects.equals(ioWriteBytesPerSec, feedback.ioWriteBytesPerSec) &&
                    Objects.equals(ioWriteOperationsPerSec, feedback.ioWriteOperationsPerSec);
        }

        @Override
        public int hashCode() {
            return Objects.hash(jobStatusDescription, totalProcessorTime, userProcessorTime, virtualMemorySize, physicalMemorySize, jobEndTime, processorUsage, ioDataBytesPerSec, ioDataOperationsPerSec, ioOtherBytesPerSec, ioOtherOperationsPerSec, ioReadBytesPerSec, ioReadOperationsPerSec, ioWriteBytesPerSec, ioWriteOperationsPerSec);
        }
    }

    public static class ExpressionDependencies {

        public static final String RESOURCE = "expressionDependencies";

        public static final String PROPERTY_ID = "id";
        public static final String PROPERTY_EXPRESSION1 = "expression1";
        public static final String PROPERTY_EXPRESSION2 = "expression2";

        private Integer id;
        private String expression1;
        private String expression2;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getExpression1() {
            return expression1;
        }

        public void setExpression1(String expression1) {
            this.expression1 = expression1;
        }

        public String getExpression2() {
            return expression2;
        }

        public void setExpression2(String expression2) {
            this.expression2 = expression2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            ExpressionDependencies that = (ExpressionDependencies) o;
            return Objects.equals(id, that.id) &&
                    Objects.equals(expression1, that.expression1) &&
                    Objects.equals(expression2, that.expression2);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, expression1, expression2);
        }
    }
}
