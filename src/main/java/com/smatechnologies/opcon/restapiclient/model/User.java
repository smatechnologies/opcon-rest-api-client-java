package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smatechnologies.opcon.restapiclient.WsModelException;
import com.smatechnologies.opcon.restapiclient.model.dailyjob.DailyJob;
import com.smatechnologies.opcon.restapiclient.model.machine.Machine;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * @author Pierre PINON
 */
@JsonIgnoreProperties(value = { "solutionManagerSettings" })
public class User {

    public static final String RESOURCE = "user";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_LOGIN_NAME = "loginName";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_PASSWORD = "password";
    public static final String PROPERTY_EXTERNAL_PASSWORD = "externalPassword";
    public static final String PROPERTY_DETAILS = "details";
    public static final String PROPERTY_MORE_DETAILS = "moreDetails";
    public static final String PROPERTY_ROLES = "roles";
    public static final String PROPERTY_LANGUAGE = "language";
    public static final String PROPERTY_IS_DISABLED = "isDisabled";
    public static final String PROPERTY_FORCE_PASSWORD_CHANGE = "forcePasswordChange";
    public static final String PROPERTY_HISTORICAL_PASSWORDS = "historicalPasswords";
    public static final String PROPERTY_EMAIL = "email";
    public static final String PROPERTY_NUMBER_OF_FAILED_PASSWORD_ATTEMPTS = "numberOfFailedPasswordAttempts";
    public static final String PROPERTY_PASSWORD_NEVER_EXPIRES = "passwordNeverExpires";
    public static final String PROPERTY_LAST_PASSWORD_CHANGE_DATE = "lastPasswordChangeDate";
    public static final String PROPERTY_LAST_LOGGED_IN = "lastLoggedIn";
    public static final String PROPERTY_LAST_LOGGED_OUT = "lastLoggedOut";
    public static final String PROPERTY_IS_SELF_SERVICE_USER = "isSelfServiceUser";

    public static final int MAX_CHARS_PASSWORD = 12;
    public static final int MAX_CHARS_EXTERNAL_PASSWORD = 20;
    public static final int MAX_CHARS_OTHER = 60;

    private static final int OCADM_ID = 0;

    private Integer id;
    private String loginName;
    private String name;
    private String password;
    private String externalPassword;
    private String details;
    private String moreDetails;
    private List<Role> roles;
    private String language;
    private Boolean isDisabled;
    private Boolean forcePasswordChange;
    private List<String> historicalPasswords;
    private String email;
    private Integer numberOfFailedPasswordAttempts;
    private Boolean passwordNeverExpires;
    private Date lastPasswordChangeDate;
    private String lastLoggedIn;
    private String lastLoggedOut;
    private Boolean isSelfServiceUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getExternalPassword() {
        return externalPassword;
    }

    public void setExternalPassword(String externalPassword) {
        this.externalPassword = externalPassword;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getMoreDetails() {
        return moreDetails;
    }

    public void setMoreDetails(String moreDetails) {
        this.moreDetails = moreDetails;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getIsDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(Boolean isDisabled) {
        this.isDisabled = isDisabled;
    }

    public Boolean getForcePasswordChange() {
        return forcePasswordChange;
    }

    public void setForcePasswordChange(Boolean forcePasswordChange) {
        this.forcePasswordChange = forcePasswordChange;
    }

    public List<String> getHistoricalPasswords() {
        return historicalPasswords;
    }

    public void setHistoricalPasswords(List<String> historicalPasswords) {
        this.historicalPasswords = historicalPasswords;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNumberOfFailedPasswordAttempts() {
        return numberOfFailedPasswordAttempts;
    }

    public void setNumberOfFailedPasswordAttempts(Integer numberOfFailedPasswordAttempts) {
        this.numberOfFailedPasswordAttempts = numberOfFailedPasswordAttempts;
    }

    public Boolean getPasswordNeverExpires() {
        return passwordNeverExpires;
    }

    public void setPasswordNeverExpires(Boolean passwordNeverExpires) {
        this.passwordNeverExpires = passwordNeverExpires;
    }

    public Date getLastPasswordChangeDate() {
        return lastPasswordChangeDate;
    }

    public void setLastPasswordChangeDate(Date lastPasswordChangeDate) {
        this.lastPasswordChangeDate = lastPasswordChangeDate;
    }

    public String getLastLoggedIn() {
        return lastLoggedIn;
    }

    public void setLastLoggedIn(String lastLoggedIn) {
        this.lastLoggedIn = lastLoggedIn;
    }

    public String getLastLoggedOut() {
        return lastLoggedOut;
    }

    public void setLastLoggedOut(String lastLoggedOut) {
        this.lastLoggedOut = lastLoggedOut;
    }

    public Boolean getIsSelfServiceUser() {
        return isSelfServiceUser;
    }

    public void setIsSelfServiceUser(Boolean isSelfServiceUser) {
        this.isSelfServiceUser = isSelfServiceUser;
    }

	@JsonIgnore
    public boolean isOCADMUser() {
        return id == User.OCADM_ID;
    }

    @JsonIgnore
    public boolean isOCADM() throws WsModelException {
        if (id == null) {
            throw new WsModelException("Id is not available");
        }

        if (isOCADMUser()) {
            return true;
        }

        if (roles == null) {
            throw new WsModelException("Roles is not available");
        }

        for (Role role : roles) {
            if (role.isOCADM()) {
                return true;
            }
        }

        return false;
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

        if (roles == null) {
            throw new WsModelException("Roles is not available");
        }

        for (Role role : roles) {
            if (role.hasPrivilege(departmentId, functionPrivileges)) {
                return true;
            }
        }

        return false;
    }

    @JsonIgnore
    public boolean hasPrivilege(DailyJob dailyJob, boolean readOnly) {
        Objects.requireNonNull(dailyJob, "DailyJob cannot be null");

        if (isOCADM()) {
            return true;
        }

        if (roles == null) {
            throw new WsModelException("Roles is not available");
        }

        //Check Schedule Privilege
        Integer scheduleId = dailyJob.getSchedule().getMasterId();

        if (roles.stream().noneMatch(role ->
                (role.getInheritAllSchedulePrivileges() != null && role.getInheritAllSchedulePrivileges())
                        || Optional.ofNullable(role.getPermissions())
                        .map(Permissions::getAccessibleScheduleIds)
                        .map(accessibleScheduleIds -> accessibleScheduleIds.contains(scheduleId))
                        .orElse(false)
        )) {
            return false;
        }

        //Check Department Function Privilege
        if (!hasPrivilege(dailyJob.getDepartment().getId(), readOnly ? FunctionPrivilege.VIEW_JOBS_IN_DAILY_SCHEDULES : FunctionPrivilege.MODIFY_JOBS_IN_DAILY_SCHEDULES)) {
            return false;
        }

        //Check Machine Group or Machines Privileges
        if (!readOnly) {
            if (dailyJob.getMachineGroup() != null) { //Machine Group
                Integer machineGroupId = dailyJob.getMachineGroup().getId();

                if (roles.stream().noneMatch(role ->
                        Optional.ofNullable(role.getPermissions())
                                .map(Permissions::getMachineGroupPrivileges)
                                .map(machineGroupPrivileges -> machineGroupPrivileges.stream().anyMatch(machineGroupPrivilege -> machineGroupPrivilege.getId() == machineGroupId && machineGroupPrivilege.isCanUpdate()))
                                .orElse(false)
                )) {
                    return false;
                }
            } else { //Machines (Primary, Alternate, Alternate2 and Alternate3)
                List<Integer> machineIds = Stream.of(dailyJob.getPrimaryMachine(), dailyJob.getAlternateMachine(), dailyJob.getAlternateMachine2(), dailyJob.getAlternateMachine3())
                        .filter(Objects::nonNull)
                        .map(Machine::getId)
                        .collect(Collectors.toList());

                if (!machineIds.stream().allMatch(machineId ->
                        roles.stream().anyMatch(role ->
                                Optional.ofNullable(role.getPermissions())
                                        .map(Permissions::getMachinePrivileges)
                                        .map(machinePrivileges -> machinePrivileges.stream().anyMatch(machinePrivilege -> machinePrivilege.getId() == machineId && machinePrivilege.isCanUpdate()))
                                        .orElse(false)
                        ))) {
                    return false;
                }
            }
        }

        //Check Code Privilege
        Integer accessCodeId = dailyJob.getAccessCode().getId();

        return roles.stream().anyMatch(role ->
                Optional.ofNullable(role.getPermissions())
                        .map(Permissions::getAccessCodePrivileges)
                        .map(accessCodePrivileges -> accessCodePrivileges.stream().anyMatch(accessCodePrivilege -> accessCodePrivilege.getId() == accessCodeId && (readOnly || accessCodePrivilege.isCanUpdate())))
                        .orElse(false)
        );
    }

    @JsonIgnore
    public boolean isAuthorizedForAllSchedules() {
        if (isOCADM()) {
            return true;
        }

        if (roles == null) {
            throw new WsModelException("Roles is not available");
        }

        return roles.stream()
                .filter(role -> role.getInheritAllSchedulePrivileges() != null)
                .anyMatch(Role::getInheritAllSchedulePrivileges);
    }

    @JsonIgnore
    public List<Integer> getAuthorizedScheduleIds() {
        if (roles == null) {
            throw new WsModelException("Roles is not available");
        }

        return roles.stream()
                .flatMap(role -> Optional.ofNullable(role.getPermissions())
                        .map(Permissions::getAccessibleScheduleIds)
                        .map(Collection::stream)
                        .stream()
                        .flatMap(getAccessibleScheduleIds -> getAccessibleScheduleIds))
                .collect(Collectors.toList());
    }

    @JsonIgnore
    public List<Integer> getAccessCodeIdsCanBeSetOnDailyJob() {
        if (roles == null) {
            throw new WsModelException("Roles is not available");
        }

        return roles.stream()
                .flatMap(role -> Optional.ofNullable(role.getPermissions())
                        .map(Permissions::getAccessCodePrivileges)
                        .map(Collection::stream)
                        .map(accessCodePrivilegeStream -> accessCodePrivilegeStream.filter(Permissions.AccessCodePrivilege::isCanUpdate))
                        .stream()
                        .flatMap(accessCodePrivilegeStream -> accessCodePrivilegeStream.map(Permissions.AccessCodePrivilege::getId)))
                .collect(Collectors.toList());
    }

    @JsonIgnore
    public List<Integer> getDepartmentIdsHasPrivilege(FunctionPrivilege... functionPrivileges) {
        Objects.requireNonNull(functionPrivileges, "FunctionPrivileges cannot be null");

        if (roles == null) {
            throw new WsModelException("Roles is not available");
        }

        return roles.stream()
                .flatMap(role -> Optional.ofNullable(role.getPermissions())
                        .map(Permissions::getDepartmentFunctionPrivileges)
                        .map(Collection::stream)
                        .map(departmentFunctionPrivilegeStream -> departmentFunctionPrivilegeStream.filter(departmentFunctionPrivilege -> departmentFunctionPrivilege.hasPrivilege(functionPrivileges)))
                        .stream()
                        .flatMap(departmentFunctionPrivilegeStream -> departmentFunctionPrivilegeStream.map(Permissions.DepartmentFunctionPrivilege::getId)))
                .collect(Collectors.toList());
    }

    @JsonIgnore
    public List<Integer> getAuthorizedBatchUserIds() {
        if (roles == null) {
            throw new WsModelException("Roles is not available");
        }

        return roles.stream()
                .flatMap(role -> Optional.ofNullable(role.getPermissions())
                        .map(Permissions::getAccessibleBatchUserIds)
                        .map(Collection::stream)
                        .stream()
                        .flatMap(getAccessibleBatchUserIds -> getAccessibleBatchUserIds))
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(loginName, user.loginName) &&
                Objects.equals(name, user.name) &&
                Objects.equals(password, user.password) &&
                Objects.equals(externalPassword, user.externalPassword) &&
                Objects.equals(details, user.details) &&
                Objects.equals(moreDetails, user.moreDetails) &&
                Objects.equals(roles, user.roles) &&
                Objects.equals(language, user.language) &&
                Objects.equals(isDisabled, user.isDisabled) &&
                Objects.equals(forcePasswordChange, user.forcePasswordChange) &&
                Objects.equals(historicalPasswords, user.historicalPasswords) &&
                Objects.equals(email, user.email) &&
                Objects.equals(numberOfFailedPasswordAttempts, user.numberOfFailedPasswordAttempts) &&
                Objects.equals(passwordNeverExpires, user.passwordNeverExpires) &&
                Objects.equals(lastPasswordChangeDate, user.lastPasswordChangeDate) &&
                Objects.equals(lastLoggedIn, user.lastLoggedIn) &&
                Objects.equals(lastLoggedOut, user.lastLoggedOut) &&
                Objects.equals(isSelfServiceUser, user.isSelfServiceUser);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, loginName, name, password, externalPassword, details, moreDetails, roles, language, isDisabled, forcePasswordChange, historicalPasswords, email, numberOfFailedPasswordAttempts, passwordNeverExpires, lastPasswordChangeDate, lastLoggedIn, lastLoggedOut, isSelfServiceUser);
    }
}
