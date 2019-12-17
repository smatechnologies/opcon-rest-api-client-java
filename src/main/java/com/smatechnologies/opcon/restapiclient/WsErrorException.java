package com.smatechnologies.opcon.restapiclient;

import com.smatechnologies.opcon.restapiclient.model.ApiError;

import javax.ws.rs.core.Response;
import java.util.List;


/**
 * @author Pierre PINON
 */
public class WsErrorException extends WsException {

    private static final long serialVersionUID = 1L;

    private List<ApiError> apiErrors;

    public WsErrorException(String message, Ws.Type type, String url, Response response, List<ApiError> apiErrors) {
        super(message, type, url, response);
        this.apiErrors = apiErrors;
    }

    public List<ApiError> getApiErrors() {
        return apiErrors;
    }
}
