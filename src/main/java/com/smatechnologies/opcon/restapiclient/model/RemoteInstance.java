package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class RemoteInstance {

    public static final String RESOURCE = "remoteInstance";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_DATABASE_CONNECTION = "databaseConnection";
    public static final String PROPERTY_API_BASE_URL = "apiBaseUrl";
    public static final String PROPERTY_SOLUTION_MANAGER_BASE_URL = "solutionManagerBaseUrl";
    public static final String PROPERTY_ADMIN_USER = "adminUser";
    public static final String PROPERTY_VISION_ACTION_USERS = "visionActionUsers";

    private Integer id;
    private String name;
    private String description;
    private DatabaseConnection databaseConnection;
    private String apiBaseUrl;
    private String solutionManagerBaseUrl;
    private User adminUser;
    private List<User> visionActionUsers;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DatabaseConnection getDatabaseConnection() {
        return databaseConnection;
    }

    public void setDatabaseConnection(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public String getApiBaseUrl() {
        return apiBaseUrl;
    }

    public void setApiBaseUrl(String apiBaseUrl) {
        this.apiBaseUrl = apiBaseUrl;
    }

    public String getSolutionManagerBaseUrl() {
        return solutionManagerBaseUrl;
    }

    public void setSolutionManagerBaseUrl(String solutionManagerBaseUrl) {
        this.solutionManagerBaseUrl = solutionManagerBaseUrl;
    }

    public User getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(User adminUser) {
        this.adminUser = adminUser;
    }

    public List<User> getVisionActionUsers() {
        return visionActionUsers;
    }

    public void setVisionActionUsers(List<User> visionActionUsers) {
        this.visionActionUsers = visionActionUsers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        RemoteInstance instance = (RemoteInstance) o;
        return Objects.equals(id, instance.id) &&
                Objects.equals(name, instance.name) &&
                Objects.equals(description, instance.description) &&
                Objects.equals(databaseConnection, instance.databaseConnection) &&
                Objects.equals(apiBaseUrl, instance.apiBaseUrl) &&
                Objects.equals(solutionManagerBaseUrl, instance.solutionManagerBaseUrl) &&
                Objects.equals(adminUser, instance.adminUser) &&
                Objects.equals(visionActionUsers, instance.visionActionUsers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, databaseConnection, apiBaseUrl, solutionManagerBaseUrl, adminUser, visionActionUsers);
    }

    public static class DatabaseConnection {

        public static final String RESOURCE = "databaseConnection";

        public static final String PROPERTY_SERVER = "server";
        public static final String PROPERTY_DATABASE = "database";
        public static final String PROPERTY_WINDOWS_AUTH = "windowsAuth";
        public static final String PROPERTY_USER = "user";
        public static final String PROPERTY_PASSWORD = "password";
        public static final String PROPERTY_MIRRORING = "mirroring";
        public static final String PROPERTY_TRANSPARENT_NETWORK_IP_RESOLUTION = "transparentNetworkIpResolution";

        private String server;
        private String database;
        private Boolean windowsAuth;
        private String user;
        private String password;
        private Boolean mirroring;
        private TransparentNetworkIpResolution transparentNetworkIpResolution;

        public String getServer() {
            return server;
        }

        public void setServer(String server) {
            this.server = server;
        }

        public String getDatabase() {
            return database;
        }

        public void setDatabase(String database) {
            this.database = database;
        }

        public Boolean getWindowsAuth() {
            return windowsAuth;
        }

        public void setWindowsAuth(Boolean windowsAuth) {
            this.windowsAuth = windowsAuth;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Boolean getMirroring() {
            return mirroring;
        }

        public void setMirroring(Boolean mirroring) {
            this.mirroring = mirroring;
        }

        public TransparentNetworkIpResolution getTransparentNetworkIpResolution() {
            return transparentNetworkIpResolution;
        }

        public void setTransparentNetworkIpResolution(TransparentNetworkIpResolution transparentNetworkIpResolution) {
            this.transparentNetworkIpResolution = transparentNetworkIpResolution;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            DatabaseConnection that = (DatabaseConnection) o;
            return Objects.equals(server, that.server) &&
                    Objects.equals(database, that.database) &&
                    Objects.equals(windowsAuth, that.windowsAuth) &&
                    Objects.equals(user, that.user) &&
                    Objects.equals(password, that.password) &&
                    Objects.equals(mirroring, that.mirroring) &&
                    transparentNetworkIpResolution == that.transparentNetworkIpResolution;
        }

        @Override
        public int hashCode() {
            return Objects.hash(server, database, windowsAuth, user, password, mirroring, transparentNetworkIpResolution);
        }

        public enum TransparentNetworkIpResolution {
            AUTO(-1),
            DISABLED(0),
            ENABLED(1);

            private final int value;

            TransparentNetworkIpResolution(int value) {
                this.value = value;
            }

            @JsonValue
            public int getValue() {
                return value;
            }

            @JsonCreator
            public static TransparentNetworkIpResolution getObject(Integer value) {
                return Arrays.stream(TransparentNetworkIpResolution.values())
                        .filter(transparentNetworkIpResolution -> transparentNetworkIpResolution.getValue() == value)
                        .findFirst()
                        .orElse(null);
            }
        }
    }
}
