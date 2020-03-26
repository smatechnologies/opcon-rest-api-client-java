package com.smatechnologies.opcon.restapiclient.api.solutionmanagersettings;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.restapiclient.criteria.AbstractResourcesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.SortedColumn;

import java.util.Collection;


/**
 * @author Pierre PINON
 */
public class SolutionManagerSettingsCriteria extends AbstractResourcesCriteria<SolutionManagerSettingsCriteria.SolutionManagerSettingsColumns> {

    @ObjMapperField
    private Collection<Integer> ids;
    @ObjMapperField
    private String name;
    @ObjMapperField
    private Integer userId;
    @ObjMapperField
    private Integer roleId;
    @ObjMapperField
    private Boolean globalOnly;
    @ObjMapperField("public")
    private Boolean isPublic;

    public Collection<Integer> getIds() {
        return ids;
    }

    public void setIds(Collection<Integer> ids) {
        this.ids = ids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Boolean getGlobalOnly() {
        return globalOnly;
    }

    public void setGlobalOnly(Boolean globalOnly) {
        this.globalOnly = globalOnly;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    /**
     * Allowed columns on SolutionManagerSettings to specify sort order.
     *
     * @author Pierre PINON.
     */
    public enum SolutionManagerSettingsColumns implements SortedColumn.Column {

        ID("id"),
        NAME("name");

        private String name;

        SolutionManagerSettingsColumns(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }
    }
}
