package com.smatechnologies.opcon.restapiclient.model;

import java.util.List;


/**
 * @author Pierre PINON
 */
public class ServiceRequestCategory {

    public static final String RESOURCE = "serviceRequestCategory";

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_COLOR = "color";
    public static final String PROPERTY_SERVICE_REQUESTS = "serviceRequests";

    private Integer id;
    private String name;
    private String color;
    private List<ServiceRequest> serviceRequests;

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<ServiceRequest> getServiceRequests() {
        return serviceRequests;
    }

    public void setServiceRequests(List<ServiceRequest> serviceRequests) {
        this.serviceRequests = serviceRequests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ServiceRequestCategory that = (ServiceRequestCategory) o;

        if (id != null ? !id.equals(that.id) : that.id != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null)
            return false;
        if (color != null ? !color.equals(that.color) : that.color != null)
            return false;
        return serviceRequests != null ? serviceRequests.equals(that.serviceRequests) : that.serviceRequests == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (serviceRequests != null ? serviceRequests.hashCode() : 0);
        return result;
    }
}
