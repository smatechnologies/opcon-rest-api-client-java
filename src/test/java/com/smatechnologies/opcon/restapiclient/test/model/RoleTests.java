package com.smatechnologies.opcon.restapiclient.test.model;

import com.smatechnologies.opcon.restapiclient.WsModelException;
import com.smatechnologies.opcon.restapiclient.model.FunctionPrivilege;
import com.smatechnologies.opcon.restapiclient.model.Permissions;
import com.smatechnologies.opcon.restapiclient.model.Role;
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
public class RoleTests {

    @Test(expected = WsModelException.class)
    public void test01IsOCADMNotAvailable() {
        Role role = new Role();

        role.isOCADM();
    }

    @Test
    public void test02IsOCADM() {
        Role role = new Role();
        role.setId(0);

        Assert.assertTrue(role.isOCADM());

        role.setId(1);

        Assert.assertFalse(role.isOCADM());
    }

    @Test(expected = NullPointerException.class)
    public void test03HasPrivilegeNull() {
        Role role = new Role();
        role.setId(1);

        role.hasPrivilege(null);
    }

    @Test(expected = WsModelException.class)
    public void test04HasPrivilegeNotAvailable() {
        Role role = new Role();

        role.hasPrivilege(FunctionPrivilege.ALL_FUNCTION_PRIVILEGES);
    }

    @Test
    public void test05HasPrivilegeRecursive() {
        Permissions permissions = new Permissions();

        Permissions.DepartmentFunctionPrivilege departmentFunctionPrivilege = new Permissions.DepartmentFunctionPrivilege();
        departmentFunctionPrivilege.setFunctionIds(Collections.singletonList(FunctionPrivilege.ALL_DAILY_SCHEDULE_FUNCTIONS.getId()));

        permissions.setDepartmentFunctionPrivileges(Collections.singletonList(departmentFunctionPrivilege));

        Role role = new Role();
        role.setId(1);
        role.setPermissions(permissions);

        Assert.assertTrue(role.hasPrivilege(FunctionPrivilege.ALL_DAILY_SCHEDULE_FUNCTIONS));
        Assert.assertTrue(role.hasPrivilege(FunctionPrivilege.ADD_JOBS_TO_DAILY_SCHEDULES));
        Assert.assertFalse(role.hasPrivilege(FunctionPrivilege.ALL_REPORT_FUNCTIONS));
        Assert.assertFalse(role.hasPrivilege(FunctionPrivilege.ALL_ADMINISTRATIVE_FUNCTIONS));
        Assert.assertFalse(role.hasPrivilege(FunctionPrivilege.ALL_FUNCTION_PRIVILEGES));
    }

    @Test
    public void test06HasPrivilegeRecursive2() {
        Permissions permissions = new Permissions();

        Permissions.DepartmentFunctionPrivilege departmentFunctionPrivilege = new Permissions.DepartmentFunctionPrivilege();
        departmentFunctionPrivilege.setFunctionIds(Collections.singletonList(FunctionPrivilege.ALL_DAILY_SCHEDULE_FUNCTIONS.getId()));

        Permissions.DepartmentFunctionPrivilege departmentFunctionPrivilege2 = new Permissions.DepartmentFunctionPrivilege();
        departmentFunctionPrivilege2.setFunctionIds(Collections.singletonList(FunctionPrivilege.ALL_REPORT_FUNCTIONS.getId()));

        permissions.setDepartmentFunctionPrivileges(Arrays.asList(departmentFunctionPrivilege, departmentFunctionPrivilege2));

        Role role = new Role();
        role.setId(1);
        role.setPermissions(permissions);

        Assert.assertTrue(role.hasPrivilege(FunctionPrivilege.ALL_DAILY_SCHEDULE_FUNCTIONS));
        Assert.assertTrue(role.hasPrivilege(FunctionPrivilege.ADD_JOBS_TO_DAILY_SCHEDULES));
        Assert.assertTrue(role.hasPrivilege(FunctionPrivilege.ALL_REPORT_FUNCTIONS));
        Assert.assertFalse(role.hasPrivilege(FunctionPrivilege.ALL_ADMINISTRATIVE_FUNCTIONS));
        Assert.assertFalse(role.hasPrivilege(FunctionPrivilege.ALL_FUNCTION_PRIVILEGES));
    }

    @Test
    public void test07HasPrivilegeOCADM() {
        Role role = new Role();
        role.setId(0);

        Assert.assertTrue(role.hasPrivilege(FunctionPrivilege.ALL_DAILY_SCHEDULE_FUNCTIONS));
        Assert.assertTrue(role.hasPrivilege(FunctionPrivilege.ADD_JOBS_TO_DAILY_SCHEDULES));
        Assert.assertTrue(role.hasPrivilege(FunctionPrivilege.ALL_REPORT_FUNCTIONS));
        Assert.assertTrue(role.hasPrivilege(FunctionPrivilege.ALL_ADMINISTRATIVE_FUNCTIONS));
        Assert.assertTrue(role.hasPrivilege(FunctionPrivilege.ALL_FUNCTION_PRIVILEGES));
    }
}
