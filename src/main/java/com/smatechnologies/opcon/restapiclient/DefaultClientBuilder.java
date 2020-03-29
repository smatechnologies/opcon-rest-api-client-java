package com.smatechnologies.opcon.restapiclient;

import com.smatechnologies.opcon.commons.util.UrlUtil;
import org.glassfish.jersey.client.ClientProperties;

import javax.net.ssl.SSLContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;


/**
 * @author Pierre PINON
 */
public class DefaultClientBuilder {

    private static final String ALGORITHM_PROTOCOL = "TLS";

    private boolean trustAllCert;
    private Integer connectTimeout;
    private Integer readTimeout;

    private DefaultClientBuilder() {
    }

    public static DefaultClientBuilder get() {
        return new DefaultClientBuilder();
    }

    public DefaultClientBuilder setTrustAllCert(boolean trustAllCert) {
        this.trustAllCert = trustAllCert;

        return this;
    }

    public DefaultClientBuilder setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;

        return this;
    }

    public DefaultClientBuilder setReadTimeout(Integer readTimeout) {
        this.readTimeout = readTimeout;

        return this;
    }

    public Client build() throws KeyManagementException, NoSuchAlgorithmException {
        ClientBuilder clientBuilder = ClientBuilder.newBuilder();

        if (trustAllCert) {
            SSLContext trustAllCertsSslContext = UrlUtil.createTrustAllCertsSSLContext(ALGORITHM_PROTOCOL);

            clientBuilder.sslContext(trustAllCertsSslContext);
            clientBuilder.hostnameVerifier((s, sslSession) -> true);
        }

        Client client = clientBuilder.build();
        if (connectTimeout != null) {
            client.property(ClientProperties.CONNECT_TIMEOUT, connectTimeout);
        }
        if (readTimeout != null) {
            client.property(ClientProperties.READ_TIMEOUT, readTimeout);
        }

        return client;
    }
}
