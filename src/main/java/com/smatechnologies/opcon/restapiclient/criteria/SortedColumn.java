package com.smatechnologies.opcon.restapiclient.criteria;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperValue;


/**
 * @author Pierre PINON
 */
public class SortedColumn<T extends SortedColumn.Column> {

    private final static String ASCENDING = ":asc";
    private final static String DESCENDING = ":desc";

    private final T column;
    private final boolean ascending;

    public SortedColumn(T column) {
        this(column, true);
    }

    public SortedColumn(T column, boolean ascending) {
        this.column = column;
        this.ascending = ascending;
    }

    public String getName() {
        return column.getName();
    }

    public boolean isAscending() {
        return ascending;
    }

    @ObjMapperValue
    public String getValue() {
        return getName() + (isAscending() ? ASCENDING : DESCENDING);
    }

    public interface Column {

        String getName();
    }
}
