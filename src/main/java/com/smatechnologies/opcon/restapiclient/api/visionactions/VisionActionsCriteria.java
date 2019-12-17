package com.smatechnologies.opcon.restapiclient.api.visionactions;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.restapiclient.criteria.AbstractResourcesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.SortedColumn;

import java.util.Collection;


/**
 * @author Matthieu COELHO
 */
public class VisionActionsCriteria extends AbstractResourcesCriteria<VisionActionsCriteria.VisionActionColumns> {

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

    public enum VisionActionColumns implements SortedColumn.Column {
        ID("id"),
        NAME("name"),
        DETAILS("details");

        private String value;

        VisionActionColumns(String value) {
            this.value = value;
        }

        @Override
        public String getName() {
            return value;
        }
    }
}