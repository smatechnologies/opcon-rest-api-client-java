package com.smatechnologies.opcon.restapiclient.api.servicerequests;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.restapiclient.criteria.AbstractResourcesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.SortedColumn;

import java.util.Collection;


/**
 * @author Pierre PINON
 */
public class ServiceRequestsCriteria extends AbstractResourcesCriteria<ServiceRequestsCriteria.ServiceRequestColumns> {

    @ObjMapperField
    private Collection<Integer> ids;
    @ObjMapperField
    private Boolean includeRoles;
    @ObjMapperField
    private String name;
    @ObjMapperField
    private String categoryName;
    @ObjMapperField
    private String roleName;
    @ObjMapperField
    private Boolean evaluateRules;

    public Collection<Integer> getIds() {
        return ids;
    }

    public void setIds(Collection<Integer> ids) {
        this.ids = ids;
    }

    public Boolean isIncludeRoles() {
        return includeRoles;
    }

    public void setIncludeRoles(Boolean includeRoles) {
        this.includeRoles = includeRoles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getRoleName() {
        return roleName;
    }

    public Boolean isEvaluateRules() {
        return evaluateRules;
    }

    public void setEvaluateRules(Boolean evaluateRules) {
        this.evaluateRules = evaluateRules;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Allowed columns on ServiceRequests to specify sort order.
     *
     * @author Pierre PINON.
     */
    public enum ServiceRequestColumns implements SortedColumn.Column {

        ID("id"),
        NAME("name"),
        CATEGORY_NAME("categoryname");

        private String name;

        ServiceRequestColumns(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }
    }
}
