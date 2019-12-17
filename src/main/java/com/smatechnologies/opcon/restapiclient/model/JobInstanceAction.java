package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Date;
import java.util.List;


/**
 * @author Pierre PINON
 */
public class JobInstanceAction {

    public static final String RESOURCE = "jobInstanceAction";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ACTION = "action";
    public static final String PROPERTY_RESULT = "result";
    public static final String PROPERTY_MESSAGE = "message";
    public static final String PROPERTY_JOB_INSTANCE_ACTION_ITEMS = "jobInstanceActionItems";
    public static final String PROPERTY_EXPIRES = "expires";

    private Integer id;
    private Action action;
    private Result result;
    private String message;
    private List<JobInstanceActionItem> jobInstanceActionItems;
    private Date expires;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<JobInstanceActionItem> getJobInstanceActionItems() {
        return jobInstanceActionItems;
    }

    public void setJobInstanceActionItems(List<JobInstanceActionItem> jobInstanceActionItems) {
        this.jobInstanceActionItems = jobInstanceActionItems;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        JobInstanceAction that = (JobInstanceAction) o;

        if (id != null ? !id.equals(that.id) : that.id != null)
            return false;
        if (action != that.action)
            return false;
        if (result != that.result)
            return false;
        if (message != null ? !message.equals(that.message) : that.message != null)
            return false;
        if (jobInstanceActionItems != null ? !jobInstanceActionItems.equals(that.jobInstanceActionItems) : that.jobInstanceActionItems != null)
            return false;
        return expires != null ? expires.equals(that.expires) : that.expires == null;
    }

    @Override
    public int hashCode() {
        int result1 = id != null ? id.hashCode() : 0;
        result1 = 31 * result1 + (action != null ? action.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (message != null ? message.hashCode() : 0);
        result1 = 31 * result1 + (jobInstanceActionItems != null ? jobInstanceActionItems.hashCode() : 0);
        result1 = 31 * result1 + (expires != null ? expires.hashCode() : 0);
        return result1;
    }

    public enum Action {
        LIST("LIST"),
        FILE("FILE");

        private final String value;

        Action(String value) {
            this.value = value;
        }

        @JsonValue
        public String value() {
            return value;
        }
    }

    public static class JobInstanceActionItem {

        public static final String RESOURCE = "jobInstanceActionItem";

        public static final String PROPERTY_ID = "id";
        public static final String PROPERTY_JORS_REQUEST_PARAMETERS = "jorsRequestParameters";
        public static final String PROPERTY_RESULT = "result";
        public static final String PROPERTY_MESSAGE = "message";
        public static final String PROPERTY_FILES = "files";
        public static final String PROPERTY_DATA = "data";

        private Integer id;
        private String jorsRequestParameters;
        private Result result;
        private String message;
        private List<String> files;
        private String data;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getJorsRequestParameters() {
            return jorsRequestParameters;
        }

        public void setJorsRequestParameters(String jorsRequestParameters) {
            this.jorsRequestParameters = jorsRequestParameters;
        }

        public Result getResult() {
            return result;
        }

        public void setResult(Result result) {
            this.result = result;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public List<String> getFiles() {
            return files;
        }

        public void setFiles(List<String> files) {
            this.files = files;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            JobInstanceActionItem that = (JobInstanceActionItem) o;

            if (id != null ? !id.equals(that.id) : that.id != null)
                return false;
            if (jorsRequestParameters != null ? !jorsRequestParameters.equals(that.jorsRequestParameters) : that.jorsRequestParameters != null)
                return false;
            if (result != that.result)
                return false;
            if (message != null ? !message.equals(that.message) : that.message != null)
                return false;
            if (files != null ? !files.equals(that.files) : that.files != null)
                return false;
            return data != null ? data.equals(that.data) : that.data == null;
        }

        @Override
        public int hashCode() {
            int result1 = id != null ? id.hashCode() : 0;
            result1 = 31 * result1 + (jorsRequestParameters != null ? jorsRequestParameters.hashCode() : 0);
            result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
            result1 = 31 * result1 + (message != null ? message.hashCode() : 0);
            result1 = 31 * result1 + (files != null ? files.hashCode() : 0);
            result1 = 31 * result1 + (data != null ? data.hashCode() : 0);
            return result1;
        }
    }
}
