package com.smatechnologies.opcon.restapiclient.api.dailyschedules;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.restapiclient.criteria.AbstractResourcesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.SortedColumn;

import java.time.LocalDate;
import java.util.Collection;


/**
 * @author Pierre PINON
 */
public class DailySchedulesCriteria extends AbstractResourcesCriteria<DailySchedulesCriteria.DailyScheduleColumns> {

    @ObjMapperField
    private Collection<String> ids;

    @ObjMapperField
    private Collection<Integer> uids;

    @ObjMapperField
    private Collection<LocalDate> dates;

    @ObjMapperField
    private String path;

    @ObjMapperField
    private String status;

    @ObjMapperField
    private Collection<String> categories;

    @ObjMapperField
    private Boolean failedJobs;

    @ObjMapperField
    private Boolean includeCount;

    @ObjMapperField
    private String name;

    public Collection<String> getIds() {
        return ids;
    }

    public void setIds(Collection<String> ids) {
        this.ids = ids;
    }

    public Collection<Integer> getUids() {
        return uids;
    }

    public void setUids(Collection<Integer> uids) {
        this.uids = uids;
    }

    public Collection<LocalDate> getDates() {
        return dates;
    }

    public void setDates(Collection<LocalDate> dates) {
        this.dates = dates;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Collection<String> getCategories() {
        return categories;
    }

    public void setCategories(Collection<String> categories) {
        this.categories = categories;
    }

    public Boolean getFailedJobs() {
        return failedJobs;
    }

    public void setFailedJobs(Boolean failedJobs) {
        this.failedJobs = failedJobs;
    }

    public Boolean getIncludeCount() {
        return includeCount;
    }

    public void setIncludeCount(Boolean includeCount) {
        this.includeCount = includeCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Allowed column to specify for sort order.
     */
    public enum DailyScheduleColumns implements SortedColumn.Column {

        PATH("path"),
        DATE("date"),
        STATUS("status"),
        START_TIME("startTime"),
        END_TIME("endTime");

        private String name;

        DailyScheduleColumns(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}