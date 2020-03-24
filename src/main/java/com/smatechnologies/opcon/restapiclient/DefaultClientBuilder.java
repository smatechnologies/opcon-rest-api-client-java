package com.smatechnologies.opcon.restapiclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smatechnologies.opcon.commons.util.UrlUtil;
import com.smatechnologies.opcon.restapiclient.jackson.DefaultObjectMapperProvider;
import com.smatechnologies.opcon.restapiclient.model.Version;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.client.ClientResponse;

import javax.annotation.Priority;
import javax.net.ssl.SSLContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.ext.ContextResolver;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;


/**
 * @author Pierre PINON
 */
public class DefaultClientBuilder {

    public final static String VERSION_ATTRIBUTE = "version";
    private static final String ALGORITHM_PROTOCOL = "TLS";

    private ContextResolver<ObjectMapper> objectMapperProvider;

    private boolean trustAllCert;
    private Integer connectTimeout;
    private Integer readTimeout;

    private DefaultClientBuilder() {
    }

    public static DefaultClientBuilder get() {
        return new DefaultClientBuilder();
    }

    public DefaultClientBuilder setObjectMapperProvider(ContextResolver<ObjectMapper> objectMapperProvider) {
        this.objectMapperProvider = Objects.requireNonNull(objectMapperProvider, "ObjectMapperProvider cannot be null");

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

        if (objectMapperProvider == null) {
            objectMapperProvider = new DefaultObjectMapperProvider();
        }

        client.register(objectMapperProvider);
        client.register(new VersionContextInjector(objectMapperProvider));

        return client;
    }

    @Priority(5)
    private static class VersionContextInjector implements ClientResponseFilter {

        private ContextResolver<ObjectMapper> objectMapperProvider;

        public VersionContextInjector(ContextResolver<ObjectMapper> objectMapperProvider) {
            this.objectMapperProvider = Objects.requireNonNull(objectMapperProvider, "ObjectMapperProvider cannot be null");
        }

        @Override
        public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
            if ("/api/version".equals(requestContext.getUri().getPath()) && responseContext instanceof ClientResponse) {
                ClientResponse clientResponse = (ClientResponse) responseContext;
                clientResponse.bufferEntity();
                String version = clientResponse.readEntity(Version.class).getOpConRestApiProductVersion();

                ObjectMapper objectMapper = objectMapperProvider.getContext(requestContext.getEntityClass());
                objectMapper.setConfig(objectMapper.getDeserializationConfig().withAttribute(VERSION_ATTRIBUTE, version));
                objectMapper.setConfig(objectMapper.getSerializationConfig().withAttribute(VERSION_ATTRIBUTE, version));
            }
        }
    }
}
