package com.smatechnologies.opcon.restapiclient.test.model;

import com.smatechnologies.opcon.restapiclient.WsModelException;
import com.smatechnologies.opcon.restapiclient.model.FunctionPrivilege;
import com.smatechnologies.opcon.restapiclient.model.Permissions;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.Collections;


/**
 * @author Pierre PINON
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PermissionsTest {

    @Test(expected = NullPointerException.class)
    public void test01DepartmentFunctionPrivilegeHasPrivilegeNull() {
        Permissions.DepartmentFunctionPrivilege departmentFunctionPrivilege = new Permissions.DepartmentFunctionPrivilege();
        departmentFunctionPrivilege.hasPrivilege(null);
    }

    @Test(expected = WsModelException.class)
    public void test02DepartmentFunctionPrivilegeHasPrivilegeNotAvailable() {
        Permissions.DepartmentFunctionPrivilege departmentFunctionPrivilege = new Permissions.DepartmentFunctionPrivilege();
        departmentFunctionPrivilege.hasPrivilege(FunctionPrivilege.ALL_FUNCTION_PRIVILEGES);
    }

    @Test
    public void test03DepartmentFunctionPrivilegeHasPrivilegeSimple() {
        Permissions.DepartmentFunctionPrivilege departmentFunctionPrivilege = new Permissions.DepartmentFunctionPrivilege();
        departmentFunctionPrivilege.setFunctionIds(Arrays.asList(
                FunctionPrivilege.VIEW_LICENSE_INFORMATION.getId(),
                FunctionPrivilege.MAINTAIN_ACCESS_CODES.getId(),
                FunctionPrivilege.MAINTAIN_DEPARTMENTS.getId()
        ));

        Assert.assertTrue(departmentFunctionPrivilege.hasPrivilege(FunctionPrivilege.VIEW_LICENSE_INFORMATION));
        Assert.assertTrue(departmentFunctionPrivilege.hasPrivilege(FunctionPrivilege.MAINTAIN_ACCESS_CODES));
        Assert.assertTrue(departmentFunctionPrivilege.hasPrivilege(FunctionPrivilege.MAINTAIN_DEPARTMENTS));
        Assert.assertFalse(departmentFunctionPrivilege.hasPrivilege(FunctionPrivilege.ALL_FUNCTION_PRIVILEGES));
        Assert.assertFalse(departmentFunctionPrivilege.hasPrivilege(FunctionPrivilege.ALL_ADMINISTRATIVE_FUNCTIONS));

        Assert.assertTrue(departmentFunctionPrivilege.hasPrivilege(FunctionPrivilege.VIEW_LICENSE_INFORMATION, FunctionPrivilege.MAINTAIN_ACCESS_CODES, FunctionPrivilege.MAINTAIN_DEPARTMENTS));
        Assert.assertFalse(departmentFunctionPrivilege.hasPrivilege(FunctionPrivilege.VIEW_LICENSE_INFORMATION, FunctionPrivilege.MAINTAIN_ACCESS_CODES, FunctionPrivilege.ALL_FUNCTION_PRIVILEGES));
        Assert.assertFalse(departmentFunctionPrivilege.hasPrivilege(FunctionPrivilege.ALL_ADMINISTRATIVE_FUNCTIONS, FunctionPrivilege.ALL_FUNCTION_PRIVILEGES));
    }

    @Test
    public void test04DepartmentFunctionPrivilegeHasPrivilegeRecursive() {
        Permissions.DepartmentFunctionPrivilege departmentFunctionPrivilege = new Permissions.DepartmentFunctionPrivilege();
        departmentFunctionPrivilege.setFunctionIds(Collections.singletonList(FunctionPrivilege.ALL_DAILY_SCHEDULE_FUNCTIONS.getId()));

        Assert.assertTrue(departmentFunctionPrivilege.hasPrivilege(FunctionPrivilege.ALL_DAILY_SCHEDULE_FUNCTIONS));
        Assert.assertTrue(departmentFunctionPrivilege.hasPrivilege(FunctionPrivilege.ADD_JOBS_TO_DAILY_SCHEDULES));
        Assert.assertFalse(departmentFunctionPrivilege.hasPrivilege(FunctionPrivilege.ALL_REPORT_FUNCTIONS));
        Assert.assertFalse(departmentFunctionPrivilege.hasPrivilege(FunctionPrivilege.ALL_ADMINISTRATIVE_FUNCTIONS));
        Assert.assertFalse(departmentFunctionPrivilege.hasPrivilege(FunctionPrivilege.ALL_FUNCTION_PRIVILEGES));

        Assert.assertTrue(departmentFunctionPrivilege.hasPrivilege(FunctionPrivilege.ALL_DAILY_SCHEDULE_FUNCTIONS, FunctionPrivilege.ADD_JOBS_TO_DAILY_SCHEDULES));
        Assert.assertFalse(departmentFunctionPrivilege.hasPrivilege(FunctionPrivilege.ALL_DAILY_SCHEDULE_FUNCTIONS, FunctionPrivilege.ALL_REPORT_FUNCTIONS));
        Assert.assertFalse(departmentFunctionPrivilege.hasPrivilege(FunctionPrivilege.ALL_ADMINISTRATIVE_FUNCTIONS, FunctionPrivilege.ALL_REPORT_FUNCTIONS));
    }

    @Test(expected = NullPointerException.class)
    public void test05PermissionsHasPrivilegeNull() {
        Permissions permissions = new Permissions();

        permissions.hasPrivilege(null);
    }

    @Test(expected = WsModelException.class)
    public void test06PermissionsHasPrivilegeNotAvailable() {
        Permissions permissions = new Permissions();

        permissions.hasPrivilege(FunctionPrivilege.ALL_FUNCTION_PRIVILEGES);
    }

    @Test
    public void test07PermissionsHasPrivilegeRecursive() {
        Permissions permissions = new Permissions();

        Permissions.DepartmentFunctionPrivilege departmentFunctionPrivilege = new Permissions.DepartmentFunctionPrivilege();
        departmentFunctionPrivilege.setFunctionIds(Collections.singletonList(FunctionPrivilege.ALL_DAILY_SCHEDULE_FUNCTIONS.getId()));

        permissions.setDepartmentFunctionPrivileges(Collections.singletonList(departmentFunctionPrivilege));

        Assert.assertTrue(permissions.hasPrivilege(FunctionPrivilege.ALL_DAILY_SCHEDULE_FUNCTIONS));
        Assert.assertTrue(permissions.hasPrivilege(FunctionPrivilege.ADD_JOBS_TO_DAILY_SCHEDULES));
        Assert.assertFalse(permissions.hasPrivilege(FunctionPrivilege.ALL_REPORT_FUNCTIONS));
        Assert.assertFalse(permissions.hasPrivilege(FunctionPrivilege.ALL_ADMINISTRATIVE_FUNCTIONS));
        Assert.assertFalse(permissions.hasPrivilege(FunctionPrivilege.ALL_FUNCTION_PRIVILEGES));

        Assert.assertTrue(permissions.hasPrivilege(FunctionPrivilege.ALL_DAILY_SCHEDULE_FUNCTIONS, FunctionPrivilege.ADD_JOBS_TO_DAILY_SCHEDULES));
        Assert.assertFalse(permissions.hasPrivilege(FunctionPrivilege.ALL_DAILY_SCHEDULE_FUNCTIONS, FunctionPrivilege.ALL_REPORT_FUNCTIONS));
        Assert.assertFalse(permissions.hasPrivilege(FunctionPrivilege.ALL_ADMINISTRATIVE_FUNCTIONS, FunctionPrivilege.ALL_REPORT_FUNCTIONS));

    }

    @Test
    public void test08PermissionsHasPrivilegeRecursive2() {
        Permissions permissions = new Permissions();

        Permissions.DepartmentFunctionPrivilege departmentFunctionPrivilege = new Permissions.DepartmentFunctionPrivilege();
        departmentFunctionPrivilege.setFunctionIds(Collections.singletonList(FunctionPrivilege.ALL_DAILY_SCHEDULE_FUNCTIONS.getId()));

        Permissions.DepartmentFunctionPrivilege departmentFunctionPrivilege2 = new Permissions.DepartmentFunctionPrivilege();
        departmentFunctionPrivilege2.setFunctionIds(Collections.singletonList(FunctionPrivilege.ALL_REPORT_FUNCTIONS.getId()));

        permissions.setDepartmentFunctionPrivileges(Arrays.asList(departmentFunctionPrivilege, departmentFunctionPrivilege2));

        Assert.assertTrue(permissions.hasPrivilege(FunctionPrivilege.ALL_DAILY_SCHEDULE_FUNCTIONS));
        Assert.assertTrue(permissions.hasPrivilege(FunctionPrivilege.ADD_JOBS_TO_DAILY_SCHEDULES));
        Assert.assertTrue(permissions.hasPrivilege(FunctionPrivilege.ALL_REPORT_FUNCTIONS));
        Assert.assertFalse(permissions.hasPrivilege(FunctionPrivilege.ALL_ADMINISTRATIVE_FUNCTIONS));
        Assert.assertFalse(permissions.hasPrivilege(FunctionPrivilege.ALL_FUNCTION_PRIVILEGES));

        Assert.assertTrue(permissions.hasPrivilege(FunctionPrivilege.ALL_DAILY_SCHEDULE_FUNCTIONS, FunctionPrivilege.ADD_JOBS_TO_DAILY_SCHEDULES, FunctionPrivilege.ALL_REPORT_FUNCTIONS));
        Assert.assertFalse(permissions.hasPrivilege(FunctionPrivilege.ALL_DAILY_SCHEDULE_FUNCTIONS, FunctionPrivilege.ADD_JOBS_TO_DAILY_SCHEDULES, FunctionPrivilege.ALL_ADMINISTRATIVE_FUNCTIONS));
        Assert.assertFalse(permissions.hasPrivilege(FunctionPrivilege.ALL_FUNCTION_PRIVILEGES, FunctionPrivilege.ALL_ADMINISTRATIVE_FUNCTIONS));
    }
}
