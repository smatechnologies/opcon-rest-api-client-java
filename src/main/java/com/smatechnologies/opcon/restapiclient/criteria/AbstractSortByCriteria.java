package com.smatechnologies.opcon.restapiclient.criteria;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


/**
 * Shared implementation of Criteria, supports Ordering.
 *
 * @author Pierre  PINON.
 */
public class AbstractSortByCriteria<T extends SortedColumn.Column> implements ICriteriaSortBy<T> {

    @ObjMapperField
    private List<SortedColumn<T>> sortBy;

    @Override
    public List<SortedColumn<T>> getSortBy() {
        return sortBy;
    }

    public AbstractSortByCriteria<T> setSortBy(List<SortedColumn<T>> sortBy) {
        this.sortBy = sortBy;

        return this;
    }

    @SafeVarargs
    public final AbstractSortByCriteria<T> addSortBy(SortedColumn<T>... sortBy) {
        Objects.requireNonNull(sortBy, "SortBy cannot be null");

        if (sortBy.length > 0) {
            if (this.sortBy == null) {
                this.sortBy = new ArrayList<>();
            }
            this.sortBy.addAll(Arrays.asList(sortBy));
        }

        return this;
    }

    public AbstractSortByCriteria<T> addSortBy(T column) {
        addSortBy(new SortedColumn<>(column));

        return this;
    }

    public AbstractSortByCriteria<T> addSortBy(T column, boolean ascending) {
        addSortBy(new SortedColumn<>(column, ascending));

        return this;
    }
}
