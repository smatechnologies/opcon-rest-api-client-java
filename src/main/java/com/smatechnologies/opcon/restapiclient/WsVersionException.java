package com.smatechnologies.opcon.restapiclient;

/**
 * @author Pierre PINON
 */
public class WsVersionException extends WsException {

    private static final long serialVersionUID = 1L;

    private final String requiredVersion;
    private final String currentVersion;

    public WsVersionException(String message, String requiredVersion, String currentVersion) {
        super(message);
        this.requiredVersion = requiredVersion;
        this.currentVersion = currentVersion;
    }

    public String getRequiredVersion() {
        return requiredVersion;
    }

    public String getCurrentVersion() {
        return currentVersion;
    }
}
