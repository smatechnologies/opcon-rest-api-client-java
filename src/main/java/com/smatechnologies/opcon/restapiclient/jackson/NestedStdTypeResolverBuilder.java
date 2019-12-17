package com.smatechnologies.opcon.restapiclient.jackson;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.annotation.NoClass;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import com.smatechnologies.opcon.restapiclient.jackson.deserializer.AsNestedPropertyTypeDeserializer;

import java.util.Collection;


/**
 * @author Pierre PINON
 */
public class NestedStdTypeResolverBuilder extends StdTypeResolverBuilder {

    @Override
    public TypeDeserializer buildTypeDeserializer(DeserializationConfig config, JavaType baseType, Collection<NamedType> subtypes) {
        //Copied this code from parent class, StdTypeResolverBuilder with same method name
        TypeIdResolver idRes = idResolver(config, baseType, subtypes, false, true);

        JavaType defaultImpl;

        //Copied this code from parent class, StdTypeResolverBuilder with same method name
        if (_defaultImpl == null) {
            defaultImpl = null;
        } else {
            // 20-Mar-2016, tatu: It is important to do specialization go through
            //   TypeFactory to ensure proper resolution; with 2.7 and before, direct
            //   call to JavaType was used, but that can not work reliably with 2.7
            // 20-Mar-2016, tatu: Can finally add a check for type compatibility BUT
            //   if so, need to add explicit checks for marker types. Not ideal, but
            //   seems like a reasonable compromise.
            if ((_defaultImpl == Void.class)
                    || (_defaultImpl == NoClass.class)) {
                defaultImpl = config.getTypeFactory().constructType(_defaultImpl);
            } else {
                defaultImpl = config.getTypeFactory()
                        .constructSpecializedType(baseType, _defaultImpl);
            }
        }

        return new AsNestedPropertyTypeDeserializer(baseType, idRes, _typeProperty, _typeIdVisible, defaultImpl, _includeAs);
    }
}
