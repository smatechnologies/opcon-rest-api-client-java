package com.smatechnologies.opcon.restapiclient;

/**
 * @author Pierre PINON
 */
public class WsModelException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public WsModelException() {
        super();
    }

    public WsModelException(String message, Throwable cause) {
        super(message, cause);
    }

    public WsModelException(String message) {
        super(message);
    }

    public WsModelException(Throwable cause) {
        super(cause);
    }
}
