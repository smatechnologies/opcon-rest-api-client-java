package com.smatechnologies.opcon.restapiclient.criteria;

import java.util.List;


/**
 * @author Pierre PINON
 */
public interface ICriteriaSortBy<T extends SortedColumn.Column> extends ICriteria {

    List<SortedColumn<T>> getSortBy();
}
