package com.smatechnologies.opcon.restapiclient.model;

import java.util.List;


/**
 * @author Matthieu COELHO
 */
public class BatchUser {

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_PLATFORM = "platform";
    public static final String PROPERTY_LOGIN_NAME = "loginName";
    public static final String PROPERTY_PASSWORD = "password";
    public static final String PROPERTY_ROLES = "roles";

    private Integer id;
    private Platform platform;
    private String loginName;
    private String password;
    private List<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof BatchUser))
            return false;

        BatchUser batchUser = (BatchUser) o;

        if (getId() != null ? !getId().equals(batchUser.getId()) : batchUser.getId() != null)
            return false;
        if (platform != null ? !platform.equals(batchUser.platform) : batchUser.platform != null)
            return false;
        if (loginName != null ? !loginName.equals(batchUser.loginName) : batchUser.loginName != null)
            return false;
        if (password != null ? !password.equals(batchUser.password) : batchUser.password != null)
            return false;
        return roles != null ? roles.equals(batchUser.roles) : batchUser.roles == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (platform != null ? platform.hashCode() : 0);
        result = 31 * result + (loginName != null ? loginName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        return result;
    }

    public static class Platform {

        public static final String RESOURCE = "platform";
        public static final String PROPERTY_ID = "id";
        public static final String PROPERTY_NAME = "name";

        private Integer id;
        private String name;

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

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Platform))
                return false;

            Platform platform = (Platform) o;

            if (getId() != null ? !getId().equals(platform.getId()) : platform.getId() != null)
                return false;
            return getName() != null ? getName().equals(platform.getName()) : platform.getName() == null;
        }

        @Override
        public int hashCode() {
            int result = getId() != null ? getId().hashCode() : 0;
            result = 31 * result + (getName() != null ? getName().hashCode() : 0);
            return result;
        }
    }
}