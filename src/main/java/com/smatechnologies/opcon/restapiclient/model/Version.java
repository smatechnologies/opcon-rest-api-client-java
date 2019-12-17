package com.smatechnologies.opcon.restapiclient.model;

/**
 * @author Pierre PINON
 */
public class Version {

    public static final String RESOURCE = "version";

    public static final String PROPERTY_OPCON_REST_API_PRODUCT_VERSION = "opConRestApiProductVersion";

    private String opConRestApiProductVersion;

    public String getOpConRestApiProductVersion() {
        return opConRestApiProductVersion;
    }

    public void setOpConRestApiProductVersion(String opConRestApiProductVersion) {
        this.opConRestApiProductVersion = opConRestApiProductVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Version version = (Version) o;

        return opConRestApiProductVersion != null ? opConRestApiProductVersion.equals(version.opConRestApiProductVersion) : version.opConRestApiProductVersion == null;

    }

    @Override
    public int hashCode() {
        return opConRestApiProductVersion != null ? opConRestApiProductVersion.hashCode() : 0;
    }
}
