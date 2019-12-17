package com.smatechnologies.opcon.restapiclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;


/**
 * @author Matthieu COELHO
 */
public class VisionAction {

    public static final String RESOURCE = "action";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DETAILS = "details";

    private Integer id;
    private String name;
    @JsonProperty("actionDetails")
    private List<VisionActionDetail> details;

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

    public List<VisionActionDetail> getDetails() {
        return details;
    }

    public void setDetails(List<VisionActionDetail> details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof VisionAction))
            return false;
        VisionAction that = (VisionAction) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getDetails(), that.getDetails());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDetails());
    }

    public static class VisionActionDetail {

        public static final String RESOURCE = "details";

        public static final String PROPERTY_ID = "id";
        public static final String PROPERTY_DETAIL = "detail";

        private Integer id;
        private String detail;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            VisionActionDetail that = (VisionActionDetail) o;
            return Objects.equals(id, that.id) &&
                    Objects.equals(detail, that.detail);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, detail);
        }
    }
}
