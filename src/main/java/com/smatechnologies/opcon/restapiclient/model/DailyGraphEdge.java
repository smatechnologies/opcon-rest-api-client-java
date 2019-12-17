package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonValue;


/**
 * @author Pierre PINON
 */
public class DailyGraphEdge {

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_PREDECESSOR_ID = "predecessorId";
    public static final String PROPERTY_PREDECESSOR_BUILT = "predecessorBuilt";
    public static final String PROPERTY_TYPE = "type";
    public static final String PROPERTY_LEVEL = "level";

    public final static int INFINITE_LEVEL = -1;
    public final static int ZERO_LEVEL = 0;

    private String id;
    private String predecessorId;
    private Boolean predecessorBuilt;
    private Type type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPredecessorId() {
        return predecessorId;
    }

    public void setPredecessorId(String predecessorId) {
        this.predecessorId = predecessorId;
    }

    public Boolean getPredecessorBuilt() {
        return predecessorBuilt;
    }

    public void setPredecessorBuilt(Boolean predecessorBuilt) {
        this.predecessorBuilt = predecessorBuilt;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof DailyGraphEdge))
            return false;

        DailyGraphEdge that = (DailyGraphEdge) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null)
            return false;
        if (getPredecessorId() != null ? !getPredecessorId().equals(that.getPredecessorId()) : that.getPredecessorId() != null)
            return false;
        if (getPredecessorBuilt() != null ? !getPredecessorBuilt().equals(that.getPredecessorBuilt()) : that.getPredecessorBuilt() != null)
            return false;
        return getType() != null ? getType().equals(that.getType()) : that.getType() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getPredecessorId() != null ? getPredecessorId().hashCode() : 0);
        result = 31 * result + (getPredecessorBuilt() != null ? getPredecessorBuilt().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        return result;
    }

    public static class Type {

        public static final String PROPERTY_ID = "id";
        public static final String PROPERTY_NAME = "name";
        public static final String PROPERTY_CONDITION = "condition";
        public static final String PROPERTY_CHECK_ALL_DAYS = "checkAllDays";
        public static final String PROPERTY_JOB_NAME_LIKE = "jobNameLike";
        public static final String PROPERTY_OFFSET = "offset";

        private Integer id;
        private Name name;
        private Condition condition;
        private Boolean checkAllDays;
        private String jobNameLike;
        private Integer offset;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Name getName() {
            return name;
        }

        public void setName(Name name) {
            this.name = name;
        }

        public Condition getCondition() {
            return condition;
        }

        public void setCondition(Condition condition) {
            this.condition = condition;
        }

        public Boolean getCheckAllDays() {
            return checkAllDays;
        }

        public void setCheckAllDays(Boolean checkAllDays) {
            this.checkAllDays = checkAllDays;
        }

        public String getJobNameLike() {
            return jobNameLike;
        }

        public void setJobNameLike(String jobNameLike) {
            this.jobNameLike = jobNameLike;
        }

        public Integer getOffset() {
            return offset;
        }

        public void setOffset(Integer offset) {
            this.offset = offset;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Type))
                return false;

            Type type = (Type) o;

            if (getId() != null ? !getId().equals(type.getId()) : type.getId() != null)
                return false;
            if (getName() != type.getName())
                return false;
            if (getCondition() != type.getCondition())
                return false;
            if (getCheckAllDays() != null ? !getCheckAllDays().equals(type.getCheckAllDays()) : type.getCheckAllDays() != null)
                return false;
            if (getJobNameLike() != null ? !getJobNameLike().equals(type.getJobNameLike()) : type.getJobNameLike() != null)
                return false;
            return getOffset() != null ? getOffset().equals(type.getOffset()) : type.getOffset() == null;
        }

        @Override
        public int hashCode() {
            int result = getId() != null ? getId().hashCode() : 0;
            result = 31 * result + (getName() != null ? getName().hashCode() : 0);
            result = 31 * result + (getCondition() != null ? getCondition().hashCode() : 0);
            result = 31 * result + (getCheckAllDays() != null ? getCheckAllDays().hashCode() : 0);
            result = 31 * result + (getJobNameLike() != null ? getJobNameLike().hashCode() : 0);
            result = 31 * result + (getOffset() != null ? getOffset().hashCode() : 0);
            return result;
        }

        public enum Name {
            REQUIRES("Requires"),
            AFTER("After"),
            CONFLICT("Conflict"),
            EXCLUDES("Excludes");

            private String value;

            Name(String value) {
                this.value = value;
            }

            @JsonValue
            public String getValue() {
                return value;
            }
        }

        public enum Condition {
            FINISHED_OK("FinishedOk", "Finished OK"),
            FAILED("Failed", "Failed"),
            IGNORE_EXIT_CODE("IgnoreExitCode", "Ignore Exit Code");

            private String value;
            private String description;

            Condition(String value, String description) {
                this.value = value;
                this.description = description;
            }

            @JsonValue
            public String getValue() {
                return value;
            }

            public String getDescription() {
                return description;
            }
        }
    }
}
