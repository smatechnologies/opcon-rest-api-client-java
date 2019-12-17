package com.smatechnologies.opcon.restapiclient.api;

/**
 * @author Pierre PINON
 */
public class OpconApiProfile {

    private final String url;

    public OpconApiProfile(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
