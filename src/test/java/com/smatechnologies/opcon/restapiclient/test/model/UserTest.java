package com.smatechnologies.opcon.restapiclient.test.model;

import com.smatechnologies.opcon.restapiclient.WsModelException;
import com.smatechnologies.opcon.restapiclient.model.FunctionPrivilege;
import com.smatechnologies.opcon.restapiclient.model.Permissions;
import com.smatechnologies.opcon.restapiclient.model.Role;
import com.smatechnologies.opcon.restapiclient.model.User;
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
public class UserTest {

    @Test(expected = WsModelException.class)
    public void test01IsOCADMNotAvailable() {
        User user = new User();

        user.isOCADM();
    }

    @Test
    public void test02IsOCADM() {
        User user = new User();
        user.setId(0);

        Assert.assertTrue(user.isOCADM());

        Role role = new Role();
        role.setId(1);
        user.setRoles(Collections.singletonList(role));

        user.setId(1);

        Assert.assertFalse(user.isOCADM());

        role.setId(0);

        Assert.assertTrue(user.isOCADM());
    }

    @Test
    public void test03HasPrivilegeRecursive() {
        Permissions permissions = new Permissions();

        Permissions.DepartmentFunctionPrivilege departmentFunctionPrivilege = new Permissions.DepartmentFunctionPrivilege();
        departmentFunctionPrivilege.setFunctionIds(Collections.singletonList(FunctionPrivilege.ALL_DAILY_SCHEDULE_FUNCTIONS.getId()));

        permissions.setDepartmentFunctionPrivileges(Collections.singletonList(departmentFunctionPrivilege));

        Role role = new Role();
        role.setId(1);
        role.setPermissions(permissions);

        User user = new User();
        user.setId(1);
        user.setRoles(Collections.singletonList(role));

        Assert.assertTrue(user.hasPrivilege(FunctionPrivilege.ALL_DAILY_SCHEDULE_FUNCTIONS));
        Assert.assertTrue(user.hasPrivilege(FunctionPrivilege.ADD_JOBS_TO_DAILY_SCHEDULES));
        Assert.assertFalse(user.hasPrivilege(FunctionPrivilege.ALL_REPORT_FUNCTIONS));
        Assert.assertFalse(user.hasPrivilege(FunctionPrivilege.ALL_ADMINISTRATIVE_FUNCTIONS));
        Assert.assertFalse(user.hasPrivilege(FunctionPrivilege.ALL_FUNCTION_PRIVILEGES));

        Assert.assertTrue(user.hasPrivilege(FunctionPrivilege.ALL_DAILY_SCHEDULE_FUNCTIONS, FunctionPrivilege.ADD_JOBS_TO_DAILY_SCHEDULES));
        Assert.assertFalse(user.hasPrivilege(FunctionPrivilege.ALL_DAILY_SCHEDULE_FUNCTIONS, FunctionPrivilege.ALL_ADMINISTRATIVE_FUNCTIONS));
        Assert.assertFalse(user.hasPrivilege(FunctionPrivilege.ALL_FUNCTION_PRIVILEGES, FunctionPrivilege.ALL_ADMINISTRATIVE_FUNCTIONS));
    }

    @Test
    public void test04HasPrivilegeRecursive2() {
        Permissions permissions = new Permissions();

        Permissions.DepartmentFunctionPrivilege departmentFunctionPrivilege = new Permissions.DepartmentFunctionPrivilege();
        departmentFunctionPrivilege.setFunctionIds(Collections.singletonList(FunctionPrivilege.ALL_DAILY_SCHEDULE_FUNCTIONS.getId()));

        Permissions.DepartmentFunctionPrivilege departmentFunctionPrivilege2 = new Permissions.DepartmentFunctionPrivilege();
        departmentFunctionPrivilege2.setFunctionIds(Collections.singletonList(FunctionPrivilege.ALL_REPORT_FUNCTIONS.getId()));

        permissions.setDepartmentFunctionPrivileges(Arrays.asList(departmentFunctionPrivilege, departmentFunctionPrivilege2));

        Role role = new Role();
        role.setId(1);
        role.setPermissions(permissions);

        User user = new User();
        user.setId(1);
        user.setRoles(Collections.singletonList(role));

        Assert.assertTrue(user.hasPrivilege(FunctionPrivilege.ALL_DAILY_SCHEDULE_FUNCTIONS));
        Assert.assertTrue(user.hasPrivilege(FunctionPrivilege.ADD_JOBS_TO_DAILY_SCHEDULES));
        Assert.assertTrue(user.hasPrivilege(FunctionPrivilege.ALL_REPORT_FUNCTIONS));
        Assert.assertFalse(user.hasPrivilege(FunctionPrivilege.ALL_ADMINISTRATIVE_FUNCTIONS));
        Assert.assertFalse(user.hasPrivilege(FunctionPrivilege.ALL_FUNCTION_PRIVILEGES));

        Assert.assertTrue(user.hasPrivilege(FunctionPrivilege.ALL_DAILY_SCHEDULE_FUNCTIONS, FunctionPrivilege.ADD_JOBS_TO_DAILY_SCHEDULES, FunctionPrivilege.ALL_REPORT_FUNCTIONS));
        Assert.assertFalse(user.hasPrivilege(FunctionPrivilege.ALL_DAILY_SCHEDULE_FUNCTIONS, FunctionPrivilege.ADD_JOBS_TO_DAILY_SCHEDULES, FunctionPrivilege.ALL_ADMINISTRATIVE_FUNCTIONS));
        Assert.assertFalse(user.hasPrivilege(FunctionPrivilege.ALL_FUNCTION_PRIVILEGES, FunctionPrivilege.ALL_ADMINISTRATIVE_FUNCTIONS));
    }

    @Test
    public void test05HasPrivilegeOCADM() {
        User user = new User();
        user.setId(0);

        Assert.assertTrue(user.hasPrivilege(FunctionPrivilege.ALL_DAILY_SCHEDULE_FUNCTIONS));
        Assert.assertTrue(user.hasPrivilege(FunctionPrivilege.ADD_JOBS_TO_DAILY_SCHEDULES));
        Assert.assertTrue(user.hasPrivilege(FunctionPrivilege.ALL_REPORT_FUNCTIONS));
        Assert.assertTrue(user.hasPrivilege(FunctionPrivilege.ALL_ADMINISTRATIVE_FUNCTIONS));
        Assert.assertTrue(user.hasPrivilege(FunctionPrivilege.ALL_FUNCTION_PRIVILEGES));

        Assert.assertTrue(user.hasPrivilege(FunctionPrivilege.ALL_DAILY_SCHEDULE_FUNCTIONS, FunctionPrivilege.ADD_JOBS_TO_DAILY_SCHEDULES, FunctionPrivilege.ALL_REPORT_FUNCTIONS, FunctionPrivilege.ALL_ADMINISTRATIVE_FUNCTIONS, FunctionPrivilege.ALL_FUNCTION_PRIVILEGES));
    }
}
