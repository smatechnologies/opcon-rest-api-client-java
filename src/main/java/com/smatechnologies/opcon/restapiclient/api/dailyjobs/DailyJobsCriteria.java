package com.smatechnologies.opcon.restapiclient.api.dailyjobs;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.restapiclient.criteria.AbstractResourcesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.SortedColumn;

import java.time.LocalDate;
import java.util.Collection;


/**
 * @author Francois EYL
 */
public class DailyJobsCriteria extends AbstractResourcesCriteria<DailyJobsCriteria.DailyJobColumns> {

    @ObjMapperField
    private Collection<String> ids;

    @ObjMapperField
    private Collection<String> uids;

    @ObjMapperField
    private Collection<String> scheduleIds;

    @ObjMapperField
    private String name;

    @ObjMapperField
    private String machine;

    @ObjMapperField
    private Collection<Integer> accessCodeIds;

    @ObjMapperField
    private Collection<LocalDate> dates;

    @ObjMapperField
    private Collection<Integer> departmentIds;

    @ObjMapperField
    private Collection<String> categories;

    @ObjMapperField
    private String jobType;

    @ObjMapperField
    private Integer priority;

    @ObjMapperField
    private String path;

    @ObjMapperField
    private String scheduleStatus;

    @ObjMapperField
    private String jobStatus;

    @ObjMapperField
    private Collection<String> tags;

    @ObjMapperField
    private String terminationDescription;

    @ObjMapperField
    private Boolean includeCount;

    @ObjMapperField
    private Boolean includeDocumentation;

    @ObjMapperField
    private Boolean includeThresholdResourceDependencies;

    @ObjMapperField
    private Boolean includeThresholdResourceUpdates;

    @ObjMapperField
    private Boolean includeSubSchedule;

    @ObjMapperField
    private Boolean includeExpressionDependencies;

    @ObjMapperField
    private Boolean includeEventTriggers;

    @ObjMapperField
    private Boolean includeDetails;

    public Collection<String> getIds() {
        return ids;
    }

    public void setIds(Collection<String> ids) {
        this.ids = ids;
    }

    public Collection<String> getUids() {
        return uids;
    }

    public void setUids(Collection<String> uids) {
        this.uids = uids;
    }

    public Collection<String> getScheduleIds() {
        return scheduleIds;
    }

    public void setScheduleIds(Collection<String> scheduleIds) {
        this.scheduleIds = scheduleIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    public Collection<Integer> getAccessCodeIds() {
        return accessCodeIds;
    }

    public void setAccessCodeIds(Collection<Integer> accessCodeIds) {
        this.accessCodeIds = accessCodeIds;
    }

    public Collection<LocalDate> getDates() {
        return dates;
    }

    public void setDates(Collection<LocalDate> dates) {
        this.dates = dates;
    }

    public Collection<Integer> getDepartmentIds() {
        return departmentIds;
    }

    public void setDepartmentIds(Collection<Integer> departmentIds) {
        this.departmentIds = departmentIds;
    }

    public Collection<String> getCategories() {
        return categories;
    }

    public void setCategories(Collection<String> categories) {
        this.categories = categories;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getScheduleStatus() {
        return scheduleStatus;
    }

    public void setScheduleStatus(String scheduleStatus) {
        this.scheduleStatus = scheduleStatus;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public Collection<String> getTags() {
        return tags;
    }

    public void setTags(Collection<String> tags) {
        this.tags = tags;
    }

    public String getTerminationDescription() {
        return terminationDescription;
    }

    public void setTerminationDescription(String terminationDescription) {
        this.terminationDescription = terminationDescription;
    }

    public Boolean getIncludeCount() {
        return includeCount;
    }

    public void setIncludeCount(Boolean includeCount) {
        this.includeCount = includeCount;
    }

    public Boolean getIncludeDocumentation() {
        return includeDocumentation;
    }

    public void setIncludeDocumentation(Boolean includeDocumentation) {
        this.includeDocumentation = includeDocumentation;
    }

    public Boolean getIncludeThresholdResourceDependencies() {
        return includeThresholdResourceDependencies;
    }

    public void setIncludeThresholdResourceDependencies(Boolean includeThresholdResourceDependencies) {
        this.includeThresholdResourceDependencies = includeThresholdResourceDependencies;
    }

    public Boolean getIncludeThresholdResourceUpdates() {
        return includeThresholdResourceUpdates;
    }

    public void setIncludeThresholdResourceUpdates(Boolean includeThresholdResourceUpdates) {
        this.includeThresholdResourceUpdates = includeThresholdResourceUpdates;
    }

    public Boolean getIncludeSubSchedule() {
        return includeSubSchedule;
    }

    public void setIncludeSubSchedule(Boolean includeSubSchedule) {
        this.includeSubSchedule = includeSubSchedule;
    }

    public Boolean getIncludeExpressionDependencies() {
        return includeExpressionDependencies;
    }

    public void setIncludeExpressionDependencies(Boolean includeExpressionDependencies) {
        this.includeExpressionDependencies = includeExpressionDependencies;
    }

    public Boolean getIncludeEventTriggers() {
        return includeEventTriggers;
    }

    public void setIncludeEventTriggers(Boolean includeEventTriggers) {
        this.includeEventTriggers = includeEventTriggers;
    }

    public Boolean getIncludeDetails() {
        return includeDetails;
    }

    public void setIncludeDetails(Boolean includeDetails) {
        this.includeDetails = includeDetails;
    }

    /**
     * Allowed column to specify for sort order.
     */
    public enum DailyJobColumns implements SortedColumn.Column {
        NAME("name"),
        MACHINE("machine"),
        TYPE("jobtype"),
        PRIORITY("priority"),
        DOCUMENTATION("documentation"),
        DATE("date"),
        PATH("path"),
        SCHEDULE_STATUS("schedulestatus"),
        STATUS("status"),
        START("start"),
        DURATION("duration"),
        END("end"),
        TERMINATION_DESCRIPTION("termdesc");

        private String name;

        DailyJobColumns(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}
