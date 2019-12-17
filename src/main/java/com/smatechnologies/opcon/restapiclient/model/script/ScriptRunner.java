package com.smatechnologies.opcon.restapiclient.model.script;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class ScriptRunner {

    public static final String RESOURCE = "scriptRunner";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_OS_TYPE = "osType";
    public static final String PROPERTY_SCRIPT_TYPE = "scriptType";
    public static final String PROPERTY_CREATED_DATE = "createdDate";
    public static final String PROPERTY_LAST_UPDATED = "lastUpdated";
    public static final String PROPERTY_COMMAND = "command";

    private Integer id;
    private String description;
    private ScriptOs osType;
    private ScriptType scriptType;
    private ZonedDateTime createdDate;
    private ZonedDateTime lastUpdated;
    private String command;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ScriptOs getOsType() {
        return osType;
    }

    public void setOsType(ScriptOs osType) {
        this.osType = osType;
    }

    public ScriptType getScriptType() {
        return scriptType;
    }

    public void setScriptType(ScriptType scriptType) {
        this.scriptType = scriptType;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public ZonedDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(ZonedDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ScriptRunner that = (ScriptRunner) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(description, that.description) &&
                osType == that.osType &&
                Objects.equals(scriptType, that.scriptType) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(lastUpdated, that.lastUpdated) &&
                Objects.equals(command, that.command);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, osType, scriptType, createdDate, lastUpdated, command);
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    public enum ScriptOs {
        WINDOWS(3, "Windows"),
        UNIX(6, "UNIX");

        public static final String RESOURCE = "scriptOs";

        public static final String PROPERTY_ID = "id";
        public static final String PROPERTY_DESCRIPTION = "description";

        private final int id;
        @JsonIgnore
        private final String description;

        ScriptOs(int id, String description) {
            this.id = id;
            this.description = description;
        }

        public int getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }

        @JsonCreator
        public static ScriptOs fromObject(final Map<String, Object> obj) {
            if (obj != null && obj.containsKey("id")) {
                Integer id;
                if (obj.get("id") instanceof Integer) {
                    id = (Integer) obj.get("id");
                } else {
                    id = Integer.parseInt((String) obj.get("id"));
                }
                if (id != null) {
                    for (ScriptOs e : ScriptOs.values()) {
                        if (id.equals(e.getId()))
                            return e;
                    }
                }
                return null;
            }
            return null;
        }
    }

}
