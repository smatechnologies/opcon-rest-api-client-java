package com.smatechnologies.opcon.restapiclient.api.calendars;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.restapiclient.criteria.AbstractResourcesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.SortedColumn;

import java.util.Collection;


/**
 * @author Matthieu COELHO
 */

public class CalendarsCriteria extends AbstractResourcesCriteria<CalendarsCriteria.CalendarColumns> {

    @ObjMapperField
    private Collection<String> ids;

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
    public enum CalendarColumns implements SortedColumn.Column {
        ID("id"),
        NAME("name"),
        DESCRIPTION("description");

        private String name;

        CalendarColumns(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}
