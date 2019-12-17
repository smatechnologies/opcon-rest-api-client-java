package com.smatechnologies.opcon.restapiclient.api.globalproperties;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.restapiclient.criteria.AbstractResourcesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.SortedColumn;

import java.util.Collection;


public class GlobalPropertiesCriteria extends AbstractResourcesCriteria<GlobalPropertiesCriteria.GlobalPropertyColumns> {

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

    /**
     * Allowed column to specify for sort order.
     */
    public enum GlobalPropertyColumns implements SortedColumn.Column {

        ID("id"),
        NAME("name"),
        VALUE("value");

        private String name;

        GlobalPropertyColumns(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}
