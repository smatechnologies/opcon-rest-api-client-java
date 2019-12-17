package com.smatechnologies.opcon.restapiclient.api.visionfrequencies;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.restapiclient.criteria.AbstractResourcesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.SortedColumn;

import java.util.Collection;


/**
 * @author Matthieu COELHO
 */
public class VisionFrequenciesCriteria extends AbstractResourcesCriteria<VisionFrequenciesCriteria.VisionFrequencyColumns> {

    @ObjMapperField
    private Collection<Integer> ids;

    @ObjMapperField
    private String name;

    @ObjMapperField
    private String description;

    @ObjMapperField
    private String path;

    @ObjMapperField
    private Boolean includeCount;

    public Collection<Integer> getIds() {
        return ids;
    }

    public void setIds(Collection<Integer> ids) {
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

    public enum VisionFrequencyColumns implements SortedColumn.Column {
        ID("id"),
        NAME("name"),
        DESCRIPTION("description"),
        TYPE("type"),
        DATES("dates");

        private String value;

        VisionFrequencyColumns(String value) {
            this.value = value;
        }

        @Override
        public String getName() {
            return value;
        }
    }
}
