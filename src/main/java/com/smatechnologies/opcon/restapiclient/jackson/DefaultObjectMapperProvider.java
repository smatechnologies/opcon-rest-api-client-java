package com.smatechnologies.opcon.restapiclient.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import javax.ws.rs.ext.ContextResolver;


/**
 * This provider supplies the necessary to by default bind or serialize/deserialize
 * objects from/to Json in custom form.
 *
 * @author Pierre PINON
 */
public class DefaultObjectMapperProvider implements ContextResolver<ObjectMapper> {

    private ObjectMapper objectMapper;
    private SimpleModule simpleModule;

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return getObjectMapper();
    }

    public ObjectMapper getObjectMapper() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
            objectMapper.registerModule(getSimpleModule());
        }

        return objectMapper;
    }

    public SimpleModule getSimpleModule() {
        if (simpleModule == null) {
            simpleModule = new DefaultSimpleModule();
        }

        return simpleModule;
    }
}
