package com.smatechnologies.opcon.restapiclient.api.thresholds;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.restapiclient.criteria.AbstractResourcesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.SortedColumn;

import java.util.Collection;


public class ThresholdsCriteria extends AbstractResourcesCriteria<ThresholdsCriteria.ThresholdColumns> {

    @ObjMapperField
    private Collection<String> ids;

    @ObjMapperField
    private String name;

    @ObjMapperField
    private String description;

    @ObjMapperField
    private String path;

    @ObjMapperField
    private Boolean includeCount;

    @ObjMapperField
    private Boolean includeUpdatedByDailyJobs;

    @ObjMapperField
    private Boolean includeDependentDailyJobs;

    public Collection<String> getIds() {
        return ids;
    }

    public void setIds(Collection<String> ids) {
        this.ids = ids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Boolean getIncludeCount() {
        return includeCount;
    }

    public void setIncludeCount(Boolean includeCount) {
        this.includeCount = includeCount;
    }

    public Boolean getIncludeUpdatedByDailyJobs() {
        return includeUpdatedByDailyJobs;
    }

    public void setIncludeUpdatedByDailyJobs(Boolean includeUpdatedByDailyJobs) {
        this.includeUpdatedByDailyJobs = includeUpdatedByDailyJobs;
    }

    public Boolean getIncludeDependentDailyJobs() {
        return includeDependentDailyJobs;
    }

    public void setIncludeDependentDailyJobs(Boolean includeDependentDailyJobs) {
        this.includeDependentDailyJobs = includeDependentDailyJobs;
    }

    /**
     * Allowed column to specify for sort order.
     */
    public enum ThresholdColumns implements SortedColumn.Column {

        USED("used"),
        ID("id"),
        NAME("name"),
        DESCRIPTION("description"),
        VALUE("value");

        private String name;

        ThresholdColumns(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}
