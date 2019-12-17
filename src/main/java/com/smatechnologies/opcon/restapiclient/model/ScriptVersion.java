package com.smatechnologies.opcon.restapiclient.model;

import java.time.ZonedDateTime;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class ScriptVersion {

    public static final String RESOURCE = "version";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_LATEST = "latest";
    public static final String PROPERTY_VERSION = "version";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_MESSAGE = "message";
    public static final String PROPERTY_AUTHOR = "author";
    public static final String PROPERTY_HASH = "hash";
    public static final String PROPERTY_CONTENT = "content";
    public static final String PROPERTY_SCRIPT = "script";

    private Integer id;
    private Boolean latest;
    private Integer version;
    private ZonedDateTime created;
    private ZonedDateTime updated;
    private String message;
    private User author;
    private String hash;
    private String content;
    private Script script;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getLatest() {
        return latest;
    }

    public void setLatest(Boolean latest) {
        this.latest = latest;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public ZonedDateTime getCreated() {
        return created;
    }

    public void setCreated(ZonedDateTime created) {
        this.created = created;
    }

    public ZonedDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(ZonedDateTime updated) {
        this.updated = updated;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Script getScript() {
        return script;
    }

    public void setScript(Script script) {
        this.script = script;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ScriptVersion that = (ScriptVersion) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(latest, that.latest) &&
                Objects.equals(version, that.version) &&
                Objects.equals(created, that.created) &&
                Objects.equals(updated, that.updated) &&
                Objects.equals(message, that.message) &&
                Objects.equals(author, that.author) &&
                Objects.equals(hash, that.hash) &&
                Objects.equals(content, that.content) &&
                Objects.equals(script, that.script);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, latest, version, created, updated, message, author, hash, content, script);
    }
}
