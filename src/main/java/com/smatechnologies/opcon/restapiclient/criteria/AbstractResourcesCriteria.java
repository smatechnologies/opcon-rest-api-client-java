package com.smatechnologies.opcon.restapiclient.criteria;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;


/**
 * Shared implementation of Criteria, supports Paging and Ordering.
 *
 * @author Francois EYL
 */
public class AbstractResourcesCriteria<T extends SortedColumn.Column> extends AbstractSortByCriteria<T> implements ICriteriaPaging {

    @ObjMapperField
    private Integer offset;
    @ObjMapperField
    private Integer limit;

    @Override
    public Integer getOffset() {
        return offset;
    }

    public AbstractResourcesCriteria<T> setOffset(Integer offset) {
        this.offset = offset;

        return this;
    }

    @Override
    public Integer getLimit() {
        return limit;
    }

    public AbstractResourcesCriteria<T> setLimit(Integer limit) {
        this.limit = limit;

        return this;
    }
}
