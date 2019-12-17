package com.smatechnologies.opcon.restapiclient.api.jobhistories;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.restapiclient.criteria.AbstractResourcesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.SortedColumn;

import java.time.LocalDate;
import java.util.List;


/**
 * @author Matthieu COELHO
 */
public class JobHistoriesCriteria extends AbstractResourcesCriteria<JobHistoriesCriteria.JobHistoryColumns> {

    @ObjMapperField
    private List<String> uniqueJobIds;

    @ObjMapperField
    private String jobName;

    @ObjMapperField
    private String scheduleName;

    @ObjMapperField
    private LocalDate from;

    @ObjMapperField
    private LocalDate to;

    public List<String> getUniqueJobIds() {
        return uniqueJobIds;
    }

    public void setUniqueJobIds(List<String> uniqueJobIds) {
        this.uniqueJobIds = uniqueJobIds;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    public enum JobHistoryColumns implements SortedColumn.Column {
        ID("id"),
        JOB_NAME("jobName");

        private String value;

        JobHistoryColumns(String value) {
            this.value = value;
        }

        @Override
        public String getName() {
            return value;
        }
    }
}
