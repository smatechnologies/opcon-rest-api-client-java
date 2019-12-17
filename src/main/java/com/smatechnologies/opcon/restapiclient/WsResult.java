package com.smatechnologies.opcon.restapiclient;

/**
 * Utility Object used by ws.api.*.Ws* that allow to return totalCount + entity
 *
 * @author Pierre PINON
 */
public class WsResult<T> {

    private final T entity;
    private final int totalCount;

    public WsResult(T entity, int totalCount) {
        this.totalCount = totalCount;
        this.entity = entity;
    }

    public T getEntity() {
        return entity;
    }

    public int getTotalCount() {
        return totalCount;
    }
}
