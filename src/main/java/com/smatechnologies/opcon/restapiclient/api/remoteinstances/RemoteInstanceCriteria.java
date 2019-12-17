package com.smatechnologies.opcon.restapiclient.api.remoteinstances;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.restapiclient.criteria.AbstractResourcesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.SortedColumn;

import java.util.Collection;


/**
 * @author Pierre PINON
 */
public class RemoteInstanceCriteria extends AbstractResourcesCriteria<RemoteInstanceCriteria.RemoteInstanceColumns> {

    @ObjMapperField
    private Collection<Integer> ids;

    @ObjMapperField
    private Boolean includeCount;

    public Collection<Integer> getIds() {
        return ids;
    }

    public void setIds(Collection<Integer> ids) {
        this.ids = ids;
    }

    public Boolean getIncludeCount() {
        return includeCount;
    }

    public void setIncludeCount(Boolean includeCount) {
        this.includeCount = includeCount;
    }

    public enum RemoteInstanceColumns implements SortedColumn.Column {
        ID("id"),
        NAME("name");

        private String value;

        RemoteInstanceColumns(String value) {
            this.value = value;
        }

        @Override
        public String getName() {
            return value;
        }
    }
}
