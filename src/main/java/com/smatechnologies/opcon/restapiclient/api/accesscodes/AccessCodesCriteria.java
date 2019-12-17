package com.smatechnologies.opcon.restapiclient.api.accesscodes;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.restapiclient.criteria.AbstractResourcesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.SortedColumn;


/**
 * @author Matthieu COELHO
 */
public class AccessCodesCriteria extends AbstractResourcesCriteria<AccessCodesCriteria.AccessCodesColumns> {

    @ObjMapperField
    private Boolean includeCount;

    public Boolean getIncludeCount() {
        return includeCount;
    }

    public void setIncludeCount(Boolean includeCount) {
        this.includeCount = includeCount;
    }

    public enum AccessCodesColumns implements SortedColumn.Column {
        NAME("name");

        private String name;

        AccessCodesColumns(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}
