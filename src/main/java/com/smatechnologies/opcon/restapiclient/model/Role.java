package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smatechnologies.opcon.restapiclient.WsModelException;

import java.util.List;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class Role {

    public static final String RESOURCE = "role";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_INHERIT_ALL_SCHEDULE_PRIVILEGES = "inheritAllSchedulePrivileges";
    public static final String PROPERTY_INHERIT_ALL_MACHINE_PRIVILEGES = "inheritAllMachinePrivileges";
    public static final String PROPERTY_INHERIT_ALL_MACHINE_GROUP_PRIVILEGES = "inheritAllMachineGroupPrivileges";
    public static final String PROPERTY_PERMISSIONS = "permissions";

    public static final int OCADM_ROLE_ID = 0;

    private Integer id;
    private String name;
    private Boolean inheritAllSchedulePrivileges;
    private Boolean inheritAllMachinePrivileges;
    private Boolean inheritAllMachineGroupPrivileges;
    private Boolean inheritAllEmbeddedScriptPrivileges;
    private Permissions permissions;
    private List<User> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getInheritAllSchedulePrivileges() {
        return inheritAllSchedulePrivileges;
    }

    public void setInheritAllSchedulePrivileges(Boolean inheritAllSchedulePrivileges) {
        this.inheritAllSchedulePrivileges = inheritAllSchedulePrivileges;
    }

    public Boolean getInheritAllMachinePrivileges() {
        return inheritAllMachinePrivileges;
    }

    public void setInheritAllMachinePrivileges(Boolean inheritAllMachinePrivileges) {
        this.inheritAllMachinePrivileges = inheritAllMachinePrivileges;
    }

    public Boolean getInheritAllMachineGroupPrivileges() {
        return inheritAllMachineGroupPrivileges;
    }

    public void setInheritAllMachineGroupPrivileges(Boolean inheritAllMachineGroupPrivileges) {
        this.inheritAllMachineGroupPrivileges = inheritAllMachineGroupPrivileges;
    }

    public Boolean getInheritAllEmbeddedScriptPrivileges() {
        return inheritAllEmbeddedScriptPrivileges;
    }

    public void setInheritAllEmbeddedScriptPrivileges(Boolean inheritAllEmbeddedScriptPrivileges) {
        this.inheritAllEmbeddedScriptPrivileges = inheritAllEmbeddedScriptPrivileges;
    }

    public Permissions getPermissions() {
        return permissions;
    }

    public void setPermissions(Permissions permissions) {
        this.permissions = permissions;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @JsonIgnore
    public boolean isOCADM() throws WsModelException {
        if (id == null) {
            throw new WsModelException("Id is not available");
        }

        return (id == OCADM_ROLE_ID);
    }

    @JsonIgnore
    public boolean hasPrivilege(FunctionPrivilege... functionPrivileges) throws WsModelException {
        return hasPrivilege(null, functionPrivileges);
    }

    /**
     * @param departmentId
     *         (Null for no or all departments)
     * @param functionPrivileges
     * @return if has privilege
     * @throws WsModelException
     */
    @JsonIgnore
    public boolean hasPrivilege(Integer departmentId, FunctionPrivilege... functionPrivileges) throws WsModelException {
        if (isOCADM()) {
            return true;
        }

        Objects.requireNonNull(functionPrivileges, "FunctionPrivileges cannot be null");

        if (permissions == null) {
            throw new WsModelException("Permissions is not available");
        }

        return permissions.hasPrivilege(departmentId, functionPrivileges);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id) &&
                Objects.equals(name, role.name) &&
                Objects.equals(inheritAllSchedulePrivileges, role.inheritAllSchedulePrivileges) &&
                Objects.equals(inheritAllMachinePrivileges, role.inheritAllMachinePrivileges) &&
                Objects.equals(inheritAllMachineGroupPrivileges, role.inheritAllMachineGroupPrivileges) &&
                Objects.equals(inheritAllEmbeddedScriptPrivileges, role.inheritAllEmbeddedScriptPrivileges) &&
                Objects.equals(permissions, role.permissions) &&
                Objects.equals(users, role.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, inheritAllSchedulePrivileges, inheritAllMachinePrivileges, inheritAllMachineGroupPrivileges, inheritAllEmbeddedScriptPrivileges, permissions, users);
    }
}
