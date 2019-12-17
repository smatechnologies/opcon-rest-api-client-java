package com.smatechnologies.opcon.restapiclient.model;

import java.util.List;


public class ScheduleBuild {

    public static class Schedule {

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

        private Integer id;
        private String name;
    }

    public static class InstanceProperty {

        private String key;
        private String value;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    private List<Schedule> schedules;
    private Integer id;
    private String expiryTime;
    private List<String> dates;
    private String logFile;
    private Boolean overwrite;
    private List<InstanceProperty> properties;
    private String namedInstance;
    private String machineName;
    private Boolean hold;

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
    }

    public List<String> getDates() {
        return dates;
    }

    public void setDates(List<String> dates) {
        this.dates = dates;
    }

    public String getLogFile() {
        return logFile;
    }

    public void setLogFile(String logFile) {
        this.logFile = logFile;
    }

    public Boolean getOverwrite() {
        return overwrite;
    }

    public void setOverwrite(Boolean overwrite) {
        this.overwrite = overwrite;
    }

    public List<InstanceProperty> getProperties() {
        return properties;
    }

    public void setProperties(List<InstanceProperty> properties) {
        this.properties = properties;
    }

    public String getNamedInstance() {
        return namedInstance;
    }

    public void setNamedInstance(String namedInstance) {
        this.namedInstance = namedInstance;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public Boolean getHold() {
        return hold;
    }

    public void setHold(Boolean hold) {
        this.hold = hold;
    }
}
