package com.smatechnologies.opcon.restapiclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smatechnologies.opcon.commons.util.UrlUtil;
import com.smatechnologies.opcon.restapiclient.jackson.DefaultObjectMapperProvider;
import org.glassfish.jersey.client.ClientProperties;

import javax.net.ssl.SSLContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.ext.ContextResolver;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class DefaultClientBuilder {

    private static final String ALGORITHM_PROTOCOL = "TLS";

    private Class<? extends ContextResolver<ObjectMapper>> objectMapperProviderClass = DefaultObjectMapperProvider.class;
    private ContextResolver<ObjectMapper> objectMapperProvider;

    private boolean trustAllCert;
    private Integer connectTimeout;
    private Integer readTimeout;

    private DefaultClientBuilder() {
    }

    public static DefaultClientBuilder get() {
        return new DefaultClientBuilder();
    }

    public DefaultClientBuilder setObjectMapperProviderClass(Class<? extends ContextResolver<ObjectMapper>> objectMapperProviderClass) {
        this.objectMapperProviderClass = Objects.requireNonNull(objectMapperProviderClass, "ObjectMapperProviderClass cannot be null");
        objectMapperProvider = null;

        return this;
    }

    public DefaultClientBuilder setObjectMapperProvider(ContextResolver<ObjectMapper> objectMapperProvider) {
        this.objectMapperProvider = Objects.requireNonNull(objectMapperProvider, "ObjectMapperProvider cannot be null");
        objectMapperProviderClass = null;

        return this;
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

        if (objectMapperProviderClass != null) {
            client.register(objectMapperProviderClass);
        }
        if (objectMapperProvider != null) {
            client.register(objectMapperProvider);
        }

        return client;
    }
}
