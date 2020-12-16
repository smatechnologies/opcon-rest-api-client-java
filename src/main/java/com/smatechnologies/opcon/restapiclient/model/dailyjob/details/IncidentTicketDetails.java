package com.smatechnologies.opcon.restapiclient.model.dailyjob.details;

import java.util.Objects;

public class IncidentTicketDetails {
	
	    public static final String RESOURCE = "incidentTickets";

	    public static final String PROPERTY_ID = "id";
	    public static final String PROPERTY_TICKET_ID = "ticketId";
	    public static final String PROPERTY_TICKET_URL = "ticketUrl";

	    private String id;
	    private String ticketId;
	    private String ticketUrl;
	
	    public String getId() {
	        return id;
	    }
	
	    public void setId(String id) {
	        this.id = id;
	    }
	
	    public String getTicketId() {
	        return ticketId;
	    }
	
	    public void setTicketId(String ticketId) {
	        this.ticketId = ticketId;
	    }
	
	    public String getTicketUrl() {
	        return ticketUrl;
	    }
	
	    public void setTicketUrl(String ticketUrl) {
	        this.ticketUrl = ticketUrl;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o)
	            return true;
	        if (o == null || getClass() != o.getClass())
	            return false;
	        IncidentTicketDetails that = (IncidentTicketDetails) o;
	        return Objects.equals(id, that.id) &&
	                Objects.equals(ticketId, that.ticketId) &&
	                Objects.equals(ticketUrl, that.ticketUrl);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(id, ticketId, ticketUrl);
	    }

}
