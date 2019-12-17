package com.smatechnologies.opcon.restapiclient.model.settings;

import com.smatechnologies.opcon.restapiclient.model.JobStatus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;


/**
 * @author Pierre PINON
 */
@XmlRootElement(name = "operationsFilterProfile")
@XmlAccessorType(XmlAccessType.FIELD)
public class OperationsFilterProfileSettings implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String RESOURCE = "operationsFilterProfile";

    private static final long XML_VERSION = 1L;

    @XmlElement(name = "xml_version")
    private long xmlVersion = XML_VERSION;

    @XmlElement
    private String id = UUID.randomUUID().toString();

    @XmlElement
    private String name;

    @XmlElementWrapper(name = "dateOffsets")
    @XmlElement(name = "dateOffset")
    private Set<Integer> dateOffsets;

    @XmlElement
    private String scheduleColumnPath;

    @XmlElement
    private ScheduleStatusSummary scheduleColumnStatusSummary;

    @XmlElement
    private String jobColumnSchedulePath;

    @XmlElement
    private String jobColumnName;

    @XmlElement
    private String jobColumnStatus;

    @XmlElement
    private String jobColumnType;

    @XmlElement
    private String jobColumnMachine;

    @XmlElement
    private String jobColumnPriority;

    @XmlElement
    private String jobColumnReturnCode;

    @XmlElementWrapper(name = "jobStatusCategories")
    @XmlElement(name = "jobStatusCategory")
    private Set<JobStatus.JobStatusCategory> jobStatusCategories;

    @XmlElementWrapper(name = "jobTags")
    @XmlElement(name = "jobTag")
    private Set<String> jobTags;

    @XmlElementWrapper(name = "departments")
    @XmlElement(name = "department")
    private Set<Integer> departments;

    @XmlElementWrapper(name = "accessCodes")
    @XmlElement(name = "accessCode")
    private Set<Integer> accessCodes;

    public long getXmlVersion() {
        return xmlVersion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Integer> getDateOffsets() {
        return dateOffsets;
    }

    public void setDateOffsets(Set<Integer> dateOffsets) {
        this.dateOffsets = dateOffsets;
    }

    public String getScheduleColumnPath() {
        return scheduleColumnPath;
    }

    public void setScheduleColumnPath(String scheduleColumnPath) {
        this.scheduleColumnPath = scheduleColumnPath;
    }

    public ScheduleStatusSummary getScheduleColumnStatusSummary() {
        return scheduleColumnStatusSummary;
    }

    public void setScheduleColumnStatusSummary(ScheduleStatusSummary scheduleStatusSummary) {
        this.scheduleColumnStatusSummary = scheduleStatusSummary;
    }

    public String getJobColumnSchedulePath() {
        return jobColumnSchedulePath;
    }

    public void setJobColumnSchedulePath(String jobColumnSchedulePath) {
        this.jobColumnSchedulePath = jobColumnSchedulePath;
    }

    public String getJobColumnName() {
        return jobColumnName;
    }

    public void setJobColumnName(String jobColumnName) {
        this.jobColumnName = jobColumnName;
    }

    public String getJobColumnStatus() {
        return jobColumnStatus;
    }

    public void setJobColumnStatus(String jobColumnStatus) {
        this.jobColumnStatus = jobColumnStatus;
    }

    public void setJobColumnType(String jobColumnType) {
        this.jobColumnType = jobColumnType;
    }

    public String getJobColumnType() {
        return jobColumnType;
    }

    public String getJobColumnMachine() {
        return jobColumnMachine;
    }

    public void setJobColumnMachine(String jobColumnMachine) {
        this.jobColumnMachine = jobColumnMachine;
    }

    public String getJobColumnPriority() {
        return jobColumnPriority;
    }

    public void setJobColumnPriority(String jobColumnPriority) {
        this.jobColumnPriority = jobColumnPriority;
    }

    public String getJobColumnReturnCode() {
        return jobColumnReturnCode;
    }

    public void setJobColumnReturnCode(String jobColumnReturnCode) {
        this.jobColumnReturnCode = jobColumnReturnCode;
    }

    public Set<JobStatus.JobStatusCategory> getJobStatusCategory() {
        return jobStatusCategories;
    }

    public void setJobStatusCategory(Set<JobStatus.JobStatusCategory> jobStatusCategories) {
        this.jobStatusCategories = jobStatusCategories;
    }

    public Set<String> getJobTagFilter() {
        return jobTags;
    }

    public void setJobTagFilter(Set<String> jobTags) {
        this.jobTags = jobTags;
    }

    public Set<Integer> getJobDepartmentFilter() {
        return departments;
    }

    public void setJobDepartmentFilter(Set<Integer> departments) {
        this.departments = departments;
    }

    public Set<Integer> getJobAccessCodeFilter() {
        return accessCodes;
    }

    public void setJobAccessCodeFilter(Set<Integer> accessCodes) {
        this.accessCodes = accessCodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        OperationsFilterProfileSettings that = (OperationsFilterProfileSettings) o;
        return xmlVersion == that.xmlVersion &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(dateOffsets, that.dateOffsets) &&
                Objects.equals(scheduleColumnPath, that.scheduleColumnPath) &&
                scheduleColumnStatusSummary == that.scheduleColumnStatusSummary &&
                Objects.equals(jobColumnSchedulePath, that.jobColumnSchedulePath) &&
                Objects.equals(jobColumnName, that.jobColumnName) &&
                Objects.equals(jobColumnStatus, that.jobColumnStatus) &&
                Objects.equals(jobColumnType, that.jobColumnType) &&
                Objects.equals(jobColumnMachine, that.jobColumnMachine) &&
                Objects.equals(jobColumnPriority, that.jobColumnPriority) &&
                Objects.equals(jobColumnReturnCode, that.jobColumnReturnCode) &&
                Objects.equals(jobStatusCategories, that.jobStatusCategories) &&
                Objects.equals(jobTags, that.jobTags) &&
                Objects.equals(departments, that.departments) &&
                Objects.equals(accessCodes, that.accessCodes);
    }

    @Override
    public int hashCode() {

        return Objects.hash(xmlVersion, id, name, dateOffsets, scheduleColumnPath, scheduleColumnStatusSummary, jobColumnSchedulePath, jobColumnName, jobColumnStatus, jobColumnType, jobColumnMachine, jobColumnPriority, jobColumnReturnCode, jobStatusCategories, jobTags, departments, accessCodes);
    }
}
