package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonValue;
import com.smatechnologies.opcon.restapiclient.model.machine.Machine;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;


public class ScheduleBuildRequest {

    public static final String RESOURCE = "scheduleBuildRequest";

    public static final String PROPERTY_REQUESTED_BY = "requestedBy";
    public static final String PROPERTY_REQUEST_TIME = "requestTime";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_BUILDS = "builds";
    public static final String PROPERTY_DATES = "dates";
    public static final String PROPERTY_OVERWRITE = "overwrite";
    public static final String PROPERTY_HOLD = "hold";
    public static final String PROPERTY_RESULTS = "results";

    private User requestedBy;
    private ZonedDateTime requestTime;
    private Integer id;
    private List<Build> builds;
    private List<LocalDate> dates;
    private Boolean overwrite;
    private Boolean hold;
    private List<Result> results;

    public User getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(User requestedBy) {
        this.requestedBy = requestedBy;
    }

    public ZonedDateTime getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(ZonedDateTime requestTime) {
        this.requestTime = requestTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Build> getBuilds() {
        return builds;
    }

    public void setBuilds(List<Build> builds) {
        this.builds = builds;
    }

    public List<LocalDate> getDates() {
        return dates;
    }

    public void setDates(List<LocalDate> dates) {
        this.dates = dates;
    }

    public Boolean getOverwrite() {
        return overwrite;
    }

    public void setOverwrite(Boolean overwrite) {
        this.overwrite = overwrite;
    }

    public Boolean getHold() {
        return hold;
    }

    public void setHold(Boolean hold) {
        this.hold = hold;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ScheduleBuildRequest that = (ScheduleBuildRequest) o;
        return Objects.equals(requestedBy, that.requestedBy) &&
                Objects.equals(requestTime, that.requestTime) &&
                Objects.equals(id, that.id) &&
                Objects.equals(builds, that.builds) &&
                Objects.equals(dates, that.dates) &&
                Objects.equals(overwrite, that.overwrite) &&
                Objects.equals(hold, that.hold) &&
                Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestedBy, requestTime, id, builds, dates, overwrite, hold, results);
    }

    public static class Result {

        public static final String RESOURCE = "results";

        public static final String PROPERTY_ID = "id";
        public static final String PROPERTY_DATE = "date";
        public static final String PROPERTY_LOG_FILE_NAME = "logFileName";
        public static final String PROPERTY_JOB_COUNT = "jobCount";
        public static final String PROPERTY_SCHEDULE_COUNT = "scheduleCount";
        public static final String PROPERTY_ERROR = "error";
        public static final String PROPERTY_STATUS = "status";
        public static final String PROPERTY_MASTER_SCHEDULE = "masterSchedule";
        public static final String PROPERTY_DAILY_SCHEDULE = "dailySchedule";

        private Integer id;
        private LocalDate date;
        private String logFileName;
        private Integer jobCount;
        private Integer scheduleCount;
        private String error;
        private Status status;
        private MasterSchedule masterSchedule;
        private DailySchedule dailySchedule;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public String getLogFileName() {
            return logFileName;
        }

        public void setLogFileName(String logFileName) {
            this.logFileName = logFileName;
        }

        public Integer getJobCount() {
            return jobCount;
        }

        public void setJobCount(Integer jobCount) {
            this.jobCount = jobCount;
        }

        public Integer getScheduleCount() {
            return scheduleCount;
        }

        public void setScheduleCount(Integer scheduleCount) {
            this.scheduleCount = scheduleCount;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }

        public MasterSchedule getMasterSchedule() {
            return masterSchedule;
        }

        public void setMasterSchedule(MasterSchedule masterSchedule) {
            this.masterSchedule = masterSchedule;
        }

        public DailySchedule getDailySchedule() {
            return dailySchedule;
        }

        public void setDailySchedule(DailySchedule dailySchedule) {
            this.dailySchedule = dailySchedule;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Result result = (Result) o;
            return Objects.equals(id, result.id) &&
                    Objects.equals(date, result.date) &&
                    Objects.equals(logFileName, result.logFileName) &&
                    Objects.equals(jobCount, result.jobCount) &&
                    Objects.equals(scheduleCount, result.scheduleCount) &&
                    Objects.equals(error, result.error) &&
                    status == result.status &&
                    Objects.equals(masterSchedule, result.masterSchedule) &&
                    Objects.equals(dailySchedule, result.dailySchedule);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, date, logFileName, jobCount, scheduleCount, error, status, masterSchedule, dailySchedule);
        }

        public enum Status {
            SUBMITTED("submitted"),
            FAILED("failed"),
            CONTAINS_FAILED_BUILD("contains failed build"),
            SUCCESS("success");

            private String value;

            Status(String value) {
                this.value = value;
            }

            @JsonValue
            public String getValue() {
                return value;
            }
        }
    }

    public static class Build {

        public static final String RESOURCE = "builds";

        public static final String PROPERTY_MASTER_SCHEDULE = "masterSchedule";
        public static final String PROPERTY_OVERWRITE = "overwrite";
        public static final String PROPERTY_HOLD = "hold";
        public static final String PROPERTY_INSTANCES = "instances";

        private MasterSchedule masterSchedule;
        private Boolean overwrite;
        private Boolean hold;
        private List<Instance> instances;

        public MasterSchedule getMasterSchedule() {
            return masterSchedule;
        }

        public void setMasterSchedule(MasterSchedule masterSchedule) {
            this.masterSchedule = masterSchedule;
        }

        public Boolean getOverwrite() {
            return overwrite;
        }

        public void setOverwrite(Boolean overwrite) {
            this.overwrite = overwrite;
        }

        public Boolean getHold() {
            return hold;
        }

        public void setHold(Boolean hold) {
            this.hold = hold;
        }

        public List<Instance> getInstances() {
            return instances;
        }

        public void setInstances(List<Instance> instances) {
            this.instances = instances;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Build build = (Build) o;
            return Objects.equals(masterSchedule, build.masterSchedule) &&
                    Objects.equals(overwrite, build.overwrite) &&
                    Objects.equals(hold, build.hold) &&
                    Objects.equals(instances, build.instances);
        }

        @Override
        public int hashCode() {
            return Objects.hash(masterSchedule, overwrite, hold, instances);
        }

        public static class Instance {

            public static final String RESOURCE = "instances";

            public static final String PROPERTY_PROPERTIES = "properties";
            public static final String PROPERTY_NAMED_INSTANCE = "namedInstance";
            public static final String PROPERTY_MACHINE = "machine";

            private List<Property> properties;
            private NamedInstance namedInstance;
            private Machine machine;

            public List<Property> getProperties() {
                return properties;
            }

            public void setProperties(List<Property> properties) {
                this.properties = properties;
            }

            public NamedInstance getNamedInstance() {
                return namedInstance;
            }

            public void setNamedInstance(NamedInstance namedInstance) {
                this.namedInstance = namedInstance;
            }

            public Machine getMachine() {
                return machine;
            }

            public void setMachine(Machine machine) {
                this.machine = machine;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o)
                    return true;
                if (o == null || getClass() != o.getClass())
                    return false;
                Instance instance = (Instance) o;
                return Objects.equals(properties, instance.properties) &&
                        Objects.equals(namedInstance, instance.namedInstance) &&
                        Objects.equals(machine, instance.machine);
            }

            @Override
            public int hashCode() {
                return Objects.hash(properties, namedInstance, machine);
            }
        }
    }
}