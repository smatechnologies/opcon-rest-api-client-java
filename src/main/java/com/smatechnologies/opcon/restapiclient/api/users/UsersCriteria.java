package com.smatechnologies.opcon.restapiclient.api.users;

import com.smatechnologies.opcon.commons.objmapper.annotation.ObjMapperField;
import com.smatechnologies.opcon.restapiclient.criteria.AbstractResourcesCriteria;
import com.smatechnologies.opcon.restapiclient.criteria.SortedColumn;


/**
 * @author Pierre PINON
 */
public class UsersCriteria extends AbstractResourcesCriteria<UsersCriteria.UserColumns> {

    @ObjMapperField
    private Boolean includeDetails;
    @ObjMapperField
    private String loginName;
    @ObjMapperField
    private String userName;
    @ObjMapperField
    private String roleName;

    public Boolean isIncludeDetails() {
        return includeDetails;
    }

    public void setIncludeDetails(Boolean includeDetails) {
        this.includeDetails = includeDetails;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Allowed columns on Users to specify sort order.
     *
     * @author Pierre PINON.
     */
    public enum UserColumns implements SortedColumn.Column {

        ID("id"),
        LOGIN_NAME("loginname"),
        USER_NAME("username");

        private String name;

        UserColumns(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }
    }
}
