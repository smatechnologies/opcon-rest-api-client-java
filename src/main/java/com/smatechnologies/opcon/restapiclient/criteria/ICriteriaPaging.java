package com.smatechnologies.opcon.restapiclient.criteria;

/**
 * @author Pierre PINON
 */
public interface ICriteriaPaging extends ICriteria {

    Integer getOffset();

    Integer getLimit();
}
