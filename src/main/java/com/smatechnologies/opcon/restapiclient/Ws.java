package com.smatechnologies.opcon.restapiclient;

import com.smatechnologies.opcon.commons.objmapper.ObjMapper;
import com.smatechnologies.opcon.commons.objmapper.ObjMapperBuilder;
import com.smatechnologies.opcon.commons.objmapper.ObjMapperException;
import com.smatechnologies.opcon.commons.util.StringUtil;
import com.smatechnologies.opcon.commons.util.VersionComparator;
import com.smatechnologies.opcon.restapiclient.api.tokens.WsTokens;
import com.smatechnologies.opcon.restapiclient.criteria.ICriteria;
import com.smatechnologies.opcon.restapiclient.model.ApiError;
import com.smatechnologies.opcon.restapiclient.model.Token;
import com.smatechnologies.opcon.restapiclient.model.Version;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;


/**
 * @author Pierre PINON
 * @author Francois EYL
 */
public class Ws {

    private static final Logger LOG = LoggerFactory.getLogger(Ws.class);

    private final static Type DEFAULT_TYPE = Type.GET;
    private final static MediaType DEFAULT_PAYLOAD_MEDIA_TYPE = MediaType.APPLICATION_JSON_TYPE;
    private final static MediaType[] DEFAULT_ACCEPT_MEDIA_TYPE = { MediaType.APPLICATION_JSON_TYPE };

    private final static int TRY_RENEW_STATUS_CODE = 401;
    private final static String TRY_RENEW_REASON_PHRASE = "Unauthorized";
    private final static String TRY_RENEW_API_ERROR_MESSAGE = "Invalid token specified";
    private final static String TRY_RENEW_REASON_PHRASE_BEFORE_19_1_0 = "Invalid token specified";

    public final static String COUNT_HEADER_KEY = "TotalResourceCount";

    private final Client client;
    private final WsListener wsListener;

    private Type type = DEFAULT_TYPE;
    private boolean token = true;

    private String target;
    private List<String> paths;
    private Object payload;
    private MediaType payloadMediaType = DEFAULT_PAYLOAD_MEDIA_TYPE;
    private MediaType[] acceptMediaTypes = DEFAULT_ACCEPT_MEDIA_TYPE;
    private Map<String, List<Object>> headers;
    private Map<String, List<Object>> params;

    private final static ObjMapper OBJ_MAPPER = ObjMapperBuilder.createNewObjMapper();

    public Ws(Client client, WsListener wsListener) {
        this.client = client;
        this.wsListener = wsListener;
    }

    public Ws type(Type type) {
        this.type = type;

        return this;
    }

    public Ws token(boolean token) {
        this.token = token;

        return this;
    }

    public Ws target(String target) {
        this.target = target;

        return this;
    }

    public Ws path(String... path) {
        if (path != null) {
            if (paths == null) {
                paths = new ArrayList<>();
            }
            paths.addAll(Arrays.asList(path));
        }

        return this;
    }

    public Ws payload(Object payload) {
        this.payload = payload;

        return this;
    }

    public Ws payloadMediaType(MediaType payloadMediaType) {
        this.payloadMediaType = payloadMediaType;

        return this;
    }

    public Ws acceptMediaTypes(MediaType... acceptMediaTypes) {
        this.acceptMediaTypes = acceptMediaTypes;

        return this;
    }

    public Ws header(String key, Object... values) {
        Objects.requireNonNull(key, "Key cannot be null");
        Objects.requireNonNull(values, "Values cannot be null");

        if (headers == null) {
            headers = new LinkedHashMap<>();
        }

        headers.put(key, new ArrayList<>(Arrays.asList(values)));

        return this;
    }

    public Ws headers(Map<String, List<Object>> headers) {
        Objects.requireNonNull(headers, "Headers cannot be null");

        for (Map.Entry<String, List<Object>> entry : headers.entrySet()) {
            String key = entry.getKey();
            List<Object> values = entry.getValue();

            if (key != null && values != null && !values.isEmpty()) {
                header(key, values.toArray(new Object[values.size()]));
            }
        }

        return this;
    }

    public Ws param(String key, Object... values) {
        Objects.requireNonNull(key, "Key cannot be null");
        Objects.requireNonNull(values, "Values cannot be null");

        if (params == null) {
            params = new LinkedHashMap<>();
        }

        params.put(key, new ArrayList<>(Arrays.asList(values)));

        return this;
    }

    public Ws params(Map<String, List<Object>> params) {
        Objects.requireNonNull(params, "Params cannot be null");

        for (Map.Entry<String, List<Object>> entry : params.entrySet()) {
            String key = entry.getKey();
            List<Object> values = entry.getValue();

            if (key != null && values != null && !values.isEmpty()) {
                param(key, values.toArray(new Object[values.size()]));
            }
        }

        return this;
    }

    public Ws criteria(ICriteria criteria) {
        if (criteria == null) {
            return this;
        }

        try {
            OBJ_MAPPER.serialize(criteria).forEach((key, value) -> param(key, StringUtil.urlEncodeCurlyBraces(value)));
        } catch (ObjMapperException e) {
            throw new IllegalArgumentException("Cannot serialize the criteria", e);
        }

        return this;
    }

    private Result call() throws WsErrorException, WsException {
        wsListener.callModifier(this);

        WebTarget webTarget = client.target(target);

        //Set paths
        if (paths != null) {
            for (String path : paths) {
                webTarget = webTarget.path(path);
            }
        }

        //Set params
        if (params != null) {
            for (Map.Entry<String, List<Object>> param : params.entrySet()) {
                String key = param.getKey();
                List<Object> values = param.getValue();

                if (key != null && values != null && !values.isEmpty()) {
                    webTarget = webTarget.queryParam(key, values.toArray(new Object[values.size()]));
                }
            }
        }

        Invocation.Builder invocationBuilder = webTarget.request();

        //Set acceptMediaTypes
        if (acceptMediaTypes != null && acceptMediaTypes.length != 0) {
            invocationBuilder.accept(acceptMediaTypes);
        }

        //Set headers
        if (headers != null) {
            for (Map.Entry<String, List<Object>> header : headers.entrySet()) {
                String key = header.getKey();
                List<Object> values = header.getValue();

                if (key != null && values != null && !values.isEmpty()) {
                    for (Object value : values) {
                        invocationBuilder.header(key, value);
                    }
                }
            }
        }

        //Set token in header if asked
        if (token) {
            Token token = wsListener.getToken();
            if (token == null) {
                throw new WsException("Cannot find token", type, webTarget.getUri().toString());
            }

            invocationBuilder.header(WsTokens.HEADER_KEY, WsTokens.HEADER_VALUE_PREFIX + token.getId());
        }

        //Check if type is correct and if payload is correct
        if (type == null) {
            throw new IllegalArgumentException("Type cannot be null");
        } else if (type == Type.PUT && payload == null) {
            throw new IllegalArgumentException("An entity is required");
        } else if (type != Type.PUT && type != Type.POST && payload != null) {
            throw new IllegalArgumentException("You cannot specify an entity");
        }

        try {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();

            Response response;
            //Call method with entity if payload is specified
            if (payload == null) {
                response = invocationBuilder.method(type.toString());
            } else {
                Entity<Object> entity = Entity.entity(payload, payloadMediaType);
                response = invocationBuilder.method(type.toString(), entity);
            }

            LOG.debug("[WebService][{}] {} {} => {} ({}) in {}ms", getLogTokenInfo(), type, webTarget.getUri().toString(), response.getStatusInfo().getReasonPhrase(), response.getStatus(), stopWatch.getTime());

            //Allow to readEntity several times
            //Useful to show header and body if response status is not successful or when de deserialization failed
            response.bufferEntity();

            //If response status if not successful, throw an exception
            if (response.getStatusInfo().getFamily() != Response.Status.Family.SUCCESSFUL) {
                try {
                    List<ApiError> apiErrors = response.readEntity(new GenericType<List<ApiError>>() {

                    });

                    throw new WsErrorException("Web service response status is not successful", type, webTarget.getUri().toString(), response, apiErrors);
                } catch (ProcessingException | IllegalStateException e) {
                    throw new WsException("Web service response status is not successful", e, type, webTarget.getUri().toString(), response);
                }
            }
            wsListener.onSuccess(response);
            return new Result(type, webTarget.getUri().toString(), response);
        } catch (ProcessingException e) {
            LOG.error("[WebService][{}] {} {}", getLogTokenInfo(), type, webTarget.getUri().toString(), e);

            //Wrap exception
            throw new WsException("Web service processing error", e, type, webTarget.getUri().toString());
        }
    }

    public Result run() throws WsErrorException, WsException {
        Result result;
        try {
            result = call();
        } catch (WsException e) {
            Response errorResponse = e.getResponse();

            if (token && errorResponse != null && isTokenExpired(errorResponse, e)) {

                try {
                    wsListener.renewToken();
                } catch (WsException e2) {
                    wsListener.onFailed(e);
                    throw e;
                }
                result = call();
            } else {
                wsListener.onFailed(e);
                throw e;
            }
        }

        return result;
    }

    @SafeVarargs
    public final <T> T run(final Class<T> clazz, ConverterDefinition<T>... converterDefinitions) throws WsErrorException, WsException {
        //Convert if a ConverterDefinition match
        ConverterDefinition<T> matchConverterDefinition = getMatchConverterDefinition(converterDefinitions);
        if (matchConverterDefinition != null) {
            convertRequest(matchConverterDefinition);
            return convertResponse(run(), matchConverterDefinition);
        }

        Result result = run();
        try {
            return result.getResponse().readEntity(clazz);
        } catch (ProcessingException e) {
            WsException wsException = new WsException("Web service response entity cannot be read", e, type, result.getUrl(), result.getResponse());
            wsListener.onFailed(wsException);

            throw e;
        }
    }

    @SafeVarargs
    public final <T> T run(final GenericType<T> genericType, ConverterDefinition<T>... converterDefinitions) throws WsErrorException, WsException {
        //Convert if a ConverterDefinition match
        ConverterDefinition<T> matchConverterDefinition = getMatchConverterDefinition(converterDefinitions);
        if (matchConverterDefinition != null) {
            convertRequest(matchConverterDefinition);
            return convertResponse(run(), matchConverterDefinition);
        }

        Result result = run();
        try {
            return result.getResponse().readEntity(genericType);
        } catch (ProcessingException e) {
            WsException wsException = new WsException("Web service response entity cannot be read", e, type, result.getUrl(), result.getResponse());
            wsListener.onFailed(wsException);

            throw e;
        }
    }

    private <T> ConverterDefinition<T> getMatchConverterDefinition(ConverterDefinition<T>[] converterDefinitions) {
        if (converterDefinitions != null && converterDefinitions.length > 0) {
            VersionComparator versionComparator = new VersionComparator();
            String version = wsListener.getVersion().getOpConRestApiProductVersion();

            return Arrays.stream(converterDefinitions)
                    .filter(
                            currentConverterDefinition -> (currentConverterDefinition.getMinimumVersion() == null || versionComparator.compare(version, currentConverterDefinition.getMinimumVersion()) >= 0)
                                    && (currentConverterDefinition.getMaximumVersion() == null || versionComparator.compare(version, currentConverterDefinition.getMaximumVersion()) <= 0)
                    )
                    .findFirst()
                    .orElse(null);
        }

        return null;
    }

    private <T> void convertRequest(ConverterDefinition<T> converterDefinition) throws WsException {
        ConverterDefinition.Converter<T, ?> converter = converterDefinition.getConverter();

        @SuppressWarnings("unchecked")
        T payload = (T) this.payload;

        this.payload = converter.convertRequest(payload);
    }

    private <T> T convertResponse(Result result, ConverterDefinition<T> converterDefinition) throws WsException {
        @SuppressWarnings("unchecked")
        ConverterDefinition.Converter<T, Object> converter = (ConverterDefinition.Converter<T, Object>) converterDefinition.getConverter();
        if (converter.getClazz() != null) {
            return converter.convertResponse(result.getResponse().readEntity(converter.getClazz()));
        } else if (converter.getGenericType() != null) {
            return converter.convertResponse(result.getResponse().readEntity(converter.getGenericType()));
        } else {
            WsException wsException = new WsException("Web service response entity cannot be read (Both Converter Class and GenericType are null)", type, result.getUrl(), result.getResponse());
            wsListener.onFailed(wsException);

            throw wsException;
        }
    }

    public int count() throws WsErrorException, WsException {
        if (params == null) {
            params = new LinkedHashMap<>();
        }

        params.put("offset", Collections.singletonList("0"));
        params.put("limit", Collections.singletonList("0"));
        params.put("includeCount", Collections.singletonList("true"));

        final Result result = run();
        if (!result.getResponse().getHeaders().containsKey(COUNT_HEADER_KEY)) {
            throw new WsException("Count header is missing from response", type, result.getUrl(), result.getResponse());
        }

        return Integer.parseInt(result.getResponse().getHeaderString(COUNT_HEADER_KEY));
    }

    private boolean isTokenExpired(Response errorResponse, WsException e) {
        if (errorResponse.getStatus() != TRY_RENEW_STATUS_CODE) {
            return false;
        } else if (new VersionComparator().compare(wsListener.getVersion().getOpConRestApiProductVersion(), "19.1.0") >= 0) {
            return TRY_RENEW_REASON_PHRASE.equals(errorResponse.getStatusInfo().getReasonPhrase()) && Optional.of(e)
                    .map(wsException -> (wsException instanceof WsErrorException) ? (WsErrorException) wsException : null)
                    .map(WsErrorException::getApiErrors)
                    .map(Collection::stream)
                    .map(apiErrorStream -> apiErrorStream.anyMatch(apiError -> TRY_RENEW_API_ERROR_MESSAGE.equals(apiError.getMessage())))
                    .orElse(false);
        } else {
            return TRY_RENEW_REASON_PHRASE_BEFORE_19_1_0.equals(errorResponse.getStatusInfo().getReasonPhrase());
        }
    }

    private String getLogTokenInfo() {
        Token token = wsListener.getToken();

        if (token == null) {
            return "No Token";
        } else if (token.getTokenType().getType() == Token.TokenType.Type.APPLICATION) {
            return Token.TokenType.Type.APPLICATION.value();
        } else {
            return token.getUser().getLoginName();
        }
    }

    public enum Type {
        GET,
        PUT,
        POST,
        DELETE,
        HEAD,
        OPTIONS,
        CONNECT,
        PATCH,
        TRACE
    }

    public interface WsListener {

        Token getToken();

        Version getVersion();

        void renewToken() throws WsException;

        void onFailed(WsException e);

        void onSuccess(Response response);

        void callModifier(Ws ws);
    }

    public static class Result {

        private final Type type;
        private final String url;
        private final Response response;

        public Result(Type type, String url, Response response) {
            this.type = type;
            this.url = url;
            this.response = response;
        }

        public Type getType() {
            return type;
        }

        public String getUrl() {
            return url;
        }

        public Response getResponse() {
            return response;
        }
    }

    public static class ConverterDefinition<T> {

        private final String minimumVersion;
        private final String maximumVersion;
        private final Converter<T, ?> converter;

        public ConverterDefinition(String minimumVersion, String maximumVersion, Converter<T, ?> converter) {
            this.minimumVersion = minimumVersion;
            this.maximumVersion = maximumVersion;
            this.converter = converter;
        }

        public String getMinimumVersion() {
            return minimumVersion;
        }

        public String getMaximumVersion() {
            return maximumVersion;
        }

        public Converter<T, ?> getConverter() {
            return converter;
        }

        public interface Converter<T, U> {

            Class<U> getClazz();

            GenericType<U> getGenericType();

            U convertRequest(T o);

            T convertResponse(U o);
        }
    }
}
