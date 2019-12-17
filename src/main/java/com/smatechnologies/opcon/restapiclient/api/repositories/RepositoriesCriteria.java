package com.smatechnologies.opcon.restapiclient.api.repositories;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.restapiclient.criteria.AbstractResourcesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.SortedColumn;


/**
 * @author Matthieu COELHO
 */
public class RepositoriesCriteria extends AbstractResourcesCriteria<SortedColumn.Column> {

    @ObjMapperField
    private Boolean includeCount;

    public Boolean getIncludeCount() {
        return includeCount;
    }

    public void setIncludeCount(Boolean includeCount) {
        this.includeCount = includeCount;
    }
}
