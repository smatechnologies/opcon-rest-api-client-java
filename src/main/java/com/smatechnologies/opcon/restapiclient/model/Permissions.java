package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smatechnologies.opcon.restapiclient.WsModelException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.smatechnologies.opcon.restapiclient.model.Permissions.DepartmentFunctionPrivilege.NO_OR_ALL_DEPARTMENTS_ID;


/**
 * @author Pierre PINON
 */
public class Permissions {

    public static final String RESOURCE = "permission";

    public static final String PROPERTY_ACCESS_CODE_PRIVILEGES = "accessCodePrivileges";
    public static final String PROPERTY_DEPARTMENT_FUNCTION_PRIVILEGES = "departmentFunctionPrivileges";
    public static final String PROPERTY_MACHINE_PRIVILEGES = "machinePrivileges";
    public static final String PROPERTY_MACHINE_GROUP_PRIVILEGES = "machineGroupPrivileges";
    public static final String PROPERTY_ACCESSIBLE_SCHEDULE_IDS = "accessibleScheduleIds";
    public static final String PROPERTY_ACCESSIBLE_SERVICE_REQUEST_IDS = "accessibleServiceRequestIds";
    public static final String PROPERTY_ACCESSIBLE_BATCHUSER_IDS = "accessibleBatchUserIds";

    private List<AccessCodePrivilege> accessCodePrivileges;
    private List<DepartmentFunctionPrivilege> departmentFunctionPrivileges;
    private List<MachinePrivilege> machinePrivileges;
    private List<MachineGroupPrivilege> machineGroupPrivileges;
    private List<Integer> accessibleScheduleIds;
    private List<Integer> accessibleEmbeddedScriptIds;
    private List<Integer> accessibleServiceRequestIds;
    private List<Integer> accessibleBatchUserIds;

    public List<AccessCodePrivilege> getAccessCodePrivileges() {
        return accessCodePrivileges;
    }

    public void setAccessCodePrivileges(List<AccessCodePrivilege> accessCodePrivileges) {
        this.accessCodePrivileges = accessCodePrivileges;
    }

    public List<DepartmentFunctionPrivilege> getDepartmentFunctionPrivileges() {
        return departmentFunctionPrivileges;
    }

    public void setDepartmentFunctionPrivileges(List<DepartmentFunctionPrivilege> departmentFunctionPrivileges) {
        this.departmentFunctionPrivileges = departmentFunctionPrivileges;
    }

    public List<MachinePrivilege> getMachinePrivileges() {
        return machinePrivileges;
    }

    public void setMachinePrivileges(List<MachinePrivilege> machinePrivileges) {
        this.machinePrivileges = machinePrivileges;
    }

    public List<MachineGroupPrivilege> getMachineGroupPrivileges() {
        return machineGroupPrivileges;
    }

    public void setMachineGroupPrivileges(List<MachineGroupPrivilege> machineGroupPrivileges) {
        this.machineGroupPrivileges = machineGroupPrivileges;
    }

    public List<Integer> getAccessibleScheduleIds() {
        return accessibleScheduleIds;
    }

    public void setAccessibleScheduleIds(List<Integer> accessibleScheduleIds) {
        this.accessibleScheduleIds = accessibleScheduleIds;
    }

    public List<Integer> getAccessibleEmbeddedScriptIds() {
        return accessibleEmbeddedScriptIds;
    }

    public void setAccessibleEmbeddedScriptIds(List<Integer> accessibleEmbeddedScriptIds) {
        this.accessibleEmbeddedScriptIds = accessibleEmbeddedScriptIds;
    }

    public List<Integer> getAccessibleServiceRequestIds() {
        return accessibleServiceRequestIds;
    }

    public void setAccessibleServiceRequestIds(List<Integer> accessibleServiceRequestIds) {
        this.accessibleServiceRequestIds = accessibleServiceRequestIds;
    }

    public List<Integer> getAccessibleBatchUserIds() {
        return accessibleBatchUserIds;
    }

    public void setAccessibleBatchUserIds(List<Integer> accessibleBatchUserIds) {
        this.accessibleBatchUserIds = accessibleBatchUserIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Permissions that = (Permissions) o;
        return Objects.equals(accessCodePrivileges, that.accessCodePrivileges) &&
                Objects.equals(departmentFunctionPrivileges, that.departmentFunctionPrivileges) &&
                Objects.equals(machinePrivileges, that.machinePrivileges) &&
                Objects.equals(machineGroupPrivileges, that.machineGroupPrivileges) &&
                Objects.equals(accessibleScheduleIds, that.accessibleScheduleIds) &&
                Objects.equals(accessibleEmbeddedScriptIds, that.accessibleEmbeddedScriptIds) &&
                Objects.equals(accessibleServiceRequestIds, that.accessibleServiceRequestIds) &&
                Objects.equals(accessibleBatchUserIds, that.accessibleBatchUserIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessCodePrivileges, departmentFunctionPrivileges, machinePrivileges, machineGroupPrivileges, accessibleScheduleIds, accessibleEmbeddedScriptIds, accessibleServiceRequestIds, accessibleBatchUserIds);
    }

    /**
     * Verify if the given {@link FunctionPrivilege} is part of the current {@link Permissions}.
     *
     * @param functionPrivileges
     * @return
     * @throws WsModelException
     */
    @JsonIgnore
    public boolean hasPrivilege(FunctionPrivilege... functionPrivileges) throws WsModelException {
        return hasPrivilege(null, functionPrivileges);
    }

    /**
     * Verify if fro the given Department Id the given {@link FunctionPrivilege} is part of the current {@link Permissions}.
     *
     * @param departmentId
     *         (Null for no or all departments)
     * @param functionPrivileges
     * @return if has privilege
     * @throws WsModelException
     */
    @JsonIgnore
    public boolean hasPrivilege(Integer departmentId, FunctionPrivilege... functionPrivileges) throws WsModelException {
        Objects.requireNonNull(functionPrivileges, "FunctionPrivileges cannot be null");

        if (departmentFunctionPrivileges == null) {
            throw new WsModelException("DepartmentFunctionPrivileges is not available");
        }

        final List<DepartmentFunctionPrivilege> partialDepartmentFunctionPrivileges;
        if (departmentId == null) {
            partialDepartmentFunctionPrivileges = departmentFunctionPrivileges;
        } else {
            partialDepartmentFunctionPrivileges = departmentFunctionPrivileges.stream()
                    .filter(departmentFunctionPrivileges -> departmentFunctionPrivileges.getId() == NO_OR_ALL_DEPARTMENTS_ID || departmentFunctionPrivileges.getId() == departmentId)
                    .collect(Collectors.toList());
        }

        for (FunctionPrivilege functionPrivilege : functionPrivileges) {
            if (partialDepartmentFunctionPrivileges.stream().noneMatch(departmentFunctionPrivilege -> departmentFunctionPrivilege.hasPrivilege(functionPrivilege))) {
                return false;
            }
        }

        return true;
    }

    public static class AccessCodePrivilege {

        public static final String RESOURCE = "accessCodePrivilege";

        public static final String PROPERTY_ID = "id";
        public static final String PROPERTY_CAN_UPDATE = "canUpdate";

        private int id;
        private boolean canUpdate;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isCanUpdate() {
            return canUpdate;
        }

        public void setCanUpdate(boolean canUpdate) {
            this.canUpdate = canUpdate;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            AccessCodePrivilege that = (AccessCodePrivilege) o;

            if (id != that.id)
                return false;
            return canUpdate == that.canUpdate;

        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + (canUpdate ? 1 : 0);
            return result;
        }
    }

    public static class DepartmentFunctionPrivilege {

        public static final String RESOURCE = "departmentFunctionPrivilege";

        public static final String PROPERTY_ID = "id";
        public static final String PROPERTY_FUNCTION_IDS = "functionIds";

        public static final int NO_OR_ALL_DEPARTMENTS_ID = 0;

        private int id;
        private List<Integer> functionIds;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<Integer> getFunctionIds() {
            return functionIds;
        }

        public void setFunctionIds(List<Integer> functionIds) {
            this.functionIds = functionIds;
        }

        @JsonIgnore
        public boolean hasPrivilege(FunctionPrivilege... functionPrivileges) throws WsModelException {
            Objects.requireNonNull(functionPrivileges, "FunctionPrivileges cannot be null");

            if (functionIds == null) {
                throw new WsModelException("FunctionIds is not available");
            }

            for (FunctionPrivilege functionPrivilege : functionPrivileges) {
                if (!functionIds.contains(functionPrivilege.getId()) && (functionPrivilege.getGroups() == null || functionPrivilege.getGroups().stream().noneMatch(this::hasPrivilege))) {
                    return false;
                }
            }

            return true;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            DepartmentFunctionPrivilege that = (DepartmentFunctionPrivilege) o;

            if (id != that.id)
                return false;
            return functionIds != null ? functionIds.equals(that.functionIds) : that.functionIds == null;

        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + (functionIds != null ? functionIds.hashCode() : 0);
            return result;
        }
    }

    public static class MachinePrivilege {

        public static final String RESOURCE = "machinePrivilege";

        public static final String PROPERTY_ID = "id";
        public static final String PROPERTY_CAN_UPDATE = "canUpdate";

        private int id;
        private boolean canUpdate;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isCanUpdate() {
            return canUpdate;
        }

        public void setCanUpdate(boolean canUpdate) {
            this.canUpdate = canUpdate;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            MachinePrivilege that = (MachinePrivilege) o;

            if (id != that.id)
                return false;
            if (canUpdate != that.canUpdate)
                return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + (canUpdate ? 1 : 0);
            return result;
        }
    }

    public static class MachineGroupPrivilege {

        public static final String RESOURCE = "machineGroupPrivilege";

        public static final String PROPERTY_ID = "id";
        public static final String PROPERTY_CAN_UPDATE = "canUpdate";

        private int id;
        private boolean canUpdate;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isCanUpdate() {
            return canUpdate;
        }

        public void setCanUpdate(boolean canUpdate) {
            this.canUpdate = canUpdate;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            MachineGroupPrivilege that = (MachineGroupPrivilege) o;

            if (id != that.id)
                return false;
            return canUpdate == that.canUpdate;
        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + (canUpdate ? 1 : 0);
            return result;
        }
    }
}
