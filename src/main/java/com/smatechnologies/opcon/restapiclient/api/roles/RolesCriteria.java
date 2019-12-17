package com.smatechnologies.opcon.restapiclient.api.roles;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.restapiclient.criteria.AbstractResourcesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.SortedColumn;

import java.util.Collection;


/**
 * @author Pierre PINON
 */
public class RolesCriteria extends AbstractResourcesCriteria<RolesCriteria.RoleColumns> {

    @ObjMapperField
    private Collection<Integer> ids;
    @ObjMapperField
    private Boolean includeAccessCodes;
    @ObjMapperField
    private Boolean includeDepartmentFunctions;
    @ObjMapperField
    private Boolean includeMachines;
    @ObjMapperField
    private Boolean includeMachineGroups;
    @ObjMapperField
    private Boolean includeSchedules;
    @ObjMapperField
    private Boolean includeServiceRequests;
    @ObjMapperField
    private boolean includeBatchUsers;
    @ObjMapperField
    private Boolean includeEmbeddedScripts;
    @ObjMapperField
    private Boolean includeCount;
    @ObjMapperField
    private String name;

    public Collection<Integer> getIds() {
        return ids;
    }

    public void setIds(Collection<Integer> ids) {
        this.ids = ids;
    }

    public Boolean isIncludeAccessCodes() {
        return includeAccessCodes;
    }

    public void setIncludeAccessCodes(Boolean includeAccessCodes) {
        this.includeAccessCodes = includeAccessCodes;
    }

    public Boolean isIncludeDepartmentFunctions() {
        return includeDepartmentFunctions;
    }

    public void setIncludeDepartmentFunctions(Boolean includeDepartmentFunctions) {
        this.includeDepartmentFunctions = includeDepartmentFunctions;
    }

    public Boolean isIncludeMachines() {
        return includeMachines;
    }

    public void setIncludeMachines(Boolean includeMachines) {
        this.includeMachines = includeMachines;
    }

    public Boolean isIncludeMachineGroups() {
        return includeMachineGroups;
    }

    public void setIncludeMachineGroups(Boolean includeMachineGroups) {
        this.includeMachineGroups = includeMachineGroups;
    }

    public Boolean isIncludeSchedules() {
        return includeSchedules;
    }

    public void setIncludeSchedules(Boolean includeSchedules) {
        this.includeSchedules = includeSchedules;
    }

    public Boolean isIncludeServiceRequests() {
        return includeServiceRequests;
    }

    public void setIncludeServiceRequests(Boolean includeServiceRequests) {
        this.includeServiceRequests = includeServiceRequests;
    }

    public Boolean getIncludeBatchUsers() {
        return includeBatchUsers;
    }

    public void setIncludeBatchUsers(boolean includeBatchUsers) {
        this.includeBatchUsers = includeBatchUsers;
    }

    public Boolean getIncludeEmbeddedScripts() {
        return includeEmbeddedScripts;
    }

    public void setIncludeEmbeddedScripts(Boolean includeEmbeddedScripts) {
        this.includeEmbeddedScripts = includeEmbeddedScripts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIncludeCount() {
        return includeCount;
    }

    public void setIncludeCount(Boolean includeCount) {
        this.includeCount = includeCount;
    }

    /**
     * Allowed columns on Roles to specify sort order.
     *
     * @author Francois EYL
     */
    public enum RoleColumns implements SortedColumn.Column {

        ID("id"),
        NAME("name");

        private String name;

        RoleColumns(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }
    }
}
