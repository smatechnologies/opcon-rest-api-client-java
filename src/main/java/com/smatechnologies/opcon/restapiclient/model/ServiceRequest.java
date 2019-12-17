package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.smatechnologies.opcon.restapiclient.jackson.deserializer.XmlJsonDeserializer;
import com.smatechnologies.opcon.restapiclient.jackson.serializer.XmlJsonSerializer;
import com.smatechnologies.opcon.restapiclient.model.servicerequest.ServiceRequestDetails;

import java.util.List;


/**
 * @author Pierre PINON
 */
public class ServiceRequest {

    public static final String RESOURCE = "serviceRequest";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DOCUMENTATION = "documentation";
    public static final String PROPERTY_HTML = "html";
    public static final String PROPERTY_DETAILS = "details";
    public static final String PROPERTY_CATEGORY = "category";
    public static final String PROPERTY_ROLES = "roles";
    public static final String PROPERTY_DISABLE_RULE = "disableRule";
    public static final String PROPERTY_HIDE_RULE = "hideRule";
    public static final String PROPERTY_DISABLED = "disabled";
    public static final String PROPERTY_HIDDEN = "hidden";

    public static final int MAX_CHARS_DISABLE_RULE = 4000;
    public static final int MAX_CHARS_HIDE_RULE = 4000;

    private Integer id;
    private String name;
    private String documentation;
    private String html;
    @JsonSerialize(using = XmlJsonSerializer.class)
    @JsonDeserialize(using = XmlJsonDeserializer.class)
    private ServiceRequestDetails details;
    @JsonProperty("serviceRequestCategory")
    private ServiceRequestCategory category;
    private List<Role> roles;
    private String disableRule;
    private String hideRule;
    private Rule disabled;
    private Rule hidden;

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

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public ServiceRequestDetails getDetails() {
        return details;
    }

    public void setDetails(ServiceRequestDetails details) {
        this.details = details;
    }

    public ServiceRequestCategory getCategory() {
        return category;
    }

    public void setCategory(ServiceRequestCategory category) {
        this.category = category;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getDisableRule() {
        return disableRule;
    }

    public void setDisableRule(String disableRule) {
        this.disableRule = disableRule;
    }

    public String getHideRule() {
        return hideRule;
    }

    public void setHideRule(String hideRule) {
        this.hideRule = hideRule;
    }

    public Rule getDisabled() {
        return disabled;
    }

    public void setDisabled(Rule disabled) {
        this.disabled = disabled;
    }

    public Rule getHidden() {
        return hidden;
    }

    public void setHidden(Rule hidden) {
        this.hidden = hidden;
    }

    public Boolean isDisabled() {
        ServiceRequest.Rule disabled = getDisabled();

        if (disabled == null) {
            throw new IllegalArgumentException("Disabled is not available");
        }

        return getDisableRule() != null && !getDisableRule().isEmpty() && disabled.getState() != ServiceRequest.Rule.State.FALSE;
    }

    public Boolean isHidden() {
        ServiceRequest.Rule hidden = getHidden();

        if (hidden == null) {
            throw new IllegalArgumentException("Hidden is not available");
        }

        return getHideRule() != null && !getHideRule().isEmpty() && hidden.getState() != ServiceRequest.Rule.State.FALSE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ServiceRequest that = (ServiceRequest) o;

        if (id != null ? !id.equals(that.id) : that.id != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null)
            return false;
        if (documentation != null ? !documentation.equals(that.documentation) : that.documentation != null)
            return false;
        if (html != null ? !html.equals(that.html) : that.html != null)
            return false;
        if (details != null ? !details.equals(that.details) : that.details != null)
            return false;
        if (category != null ? !category.equals(that.category) : that.category != null)
            return false;
        if (roles != null ? !roles.equals(that.roles) : that.roles != null)
            return false;
        if (disableRule != null ? !disableRule.equals(that.disableRule) : that.disableRule != null)
            return false;
        if (hideRule != null ? !hideRule.equals(that.hideRule) : that.hideRule != null)
            return false;
        if (disabled != null ? !disabled.equals(that.disabled) : that.disabled != null)
            return false;
        return hidden != null ? hidden.equals(that.hidden) : that.hidden == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (documentation != null ? documentation.hashCode() : 0);
        result = 31 * result + (html != null ? html.hashCode() : 0);
        result = 31 * result + (details != null ? details.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        result = 31 * result + (disableRule != null ? disableRule.hashCode() : 0);
        result = 31 * result + (hideRule != null ? hideRule.hashCode() : 0);
        result = 31 * result + (disabled != null ? disabled.hashCode() : 0);
        result = 31 * result + (hidden != null ? hidden.hashCode() : 0);
        return result;
    }

    public final static class Rule {

        public static final String RESOURCE = "rule";

        public static final String PROPERTY_STATE = "state";
        public static final String PROPERTY_ERROR_MESSAGE = "errorMessage";

        private State state;
        private String errorMessage;

        public State getState() {
            return state;
        }

        public void setState(State state) {
            this.state = state;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            Rule rule = (Rule) o;

            if (state != rule.state)
                return false;
            return errorMessage != null ? errorMessage.equals(rule.errorMessage) : rule.errorMessage == null;

        }

        @Override
        public int hashCode() {
            int result = state != null ? state.hashCode() : 0;
            result = 31 * result + (errorMessage != null ? errorMessage.hashCode() : 0);
            return result;
        }

        public enum State {
            TRUE("true"),
            FALSE("false"),
            ERROR("error");

            private final String value;

            State(String value) {
                this.value = value;
            }

            @JsonValue
            public String value() {
                return value;
            }
        }
    }
}
