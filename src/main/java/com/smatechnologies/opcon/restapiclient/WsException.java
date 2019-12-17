package com.smatechnologies.opcon.restapiclient;

import javax.ws.rs.core.Response;


/**
 * @author Pierre PINON
 */
public class WsException extends Exception {

    private static final long serialVersionUID = 1L;

    private Ws.Type type;
    private String url;
    private Response response;

    public WsException(String message) {
        super(message);
    }

    public WsException(String message, Ws.Type type, String url) {
        super(message);
        this.type = type;
        this.url = url;
    }

    public WsException(String message, Throwable cause) {
        super(message, cause);
    }

    public WsException(String message, Ws.Type type, String url, Response response) {
        super(message);
        this.type = type;
        this.url = url;
        this.response = response;
    }

    public WsException(String message, Throwable cause, Ws.Type type, String url) {
        super(message, cause);
        this.type = type;
        this.url = url;
    }

    public WsException(String message, Throwable cause, Ws.Type type, String url, Response response) {
        super(message, cause);
        this.type = type;
        this.url = url;
        this.response = response;
    }

    public Ws.Type getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public Response getResponse() {
        return response;
    }
}
