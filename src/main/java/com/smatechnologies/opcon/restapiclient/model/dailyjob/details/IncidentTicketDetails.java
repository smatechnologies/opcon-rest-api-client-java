package com.smatechnologies.opcon.restapiclient.model.dailyjob.details;

public class IncidentTicketDetails {
	
	   public static final String RESOURCE = "incidentTickets";

	    public static final String PROPERTY_ID = "id";
	    public static final String TICKET_ID = "ticketId";
	    public static final String TICKET_URL = "ticketUrl";

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

}
