package com.smatechnologies.opcon.restapiclient.model;

import java.time.LocalDate;
import java.util.Objects;


public class ScheduleBuildRequestLog {

    public static final String RESOURCE = "scheduleBuildRequestLog";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_DATE = "date";
    public static final String PROPERTY_SCHEDULE_ID = "scheduleId";
    public static final String PROPERTY_LOG_FILE_NAME = "logFileName";
    public static final String PROPERTY_LOG_FILE_CONTENT = "logFileContent";

    private Integer id;
    private LocalDate date;
    private Integer scheduleId;
    private String logFileName;
    private String logFileContent;

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

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getLogFileName() {
        return logFileName;
    }

    public void setLogFileName(String logFileName) {
        this.logFileName = logFileName;
    }

    public String getLogFileContent() {
        return logFileContent;
    }

    public void setLogFileContent(String logFileContent) {
        this.logFileContent = logFileContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ScheduleBuildRequestLog that = (ScheduleBuildRequestLog) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(date, that.date) &&
                Objects.equals(scheduleId, that.scheduleId) &&
                Objects.equals(logFileName, that.logFileName) &&
                Objects.equals(logFileContent, that.logFileContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, scheduleId, logFileName, logFileContent);
    }
}
