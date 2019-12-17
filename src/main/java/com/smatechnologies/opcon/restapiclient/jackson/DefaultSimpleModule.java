package com.smatechnologies.opcon.restapiclient.jackson;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.smatechnologies.opcon.restapiclient.jackson.deserializer.DateJsonDeserializer;
import com.smatechnologies.opcon.restapiclient.jackson.deserializer.LocalDateJsonDeserializer;
import com.smatechnologies.opcon.restapiclient.jackson.deserializer.LocalDateTimeJsonDeserializer;
import com.smatechnologies.opcon.restapiclient.jackson.deserializer.OffsetTimeJsonDeserializer;
import com.smatechnologies.opcon.restapiclient.jackson.deserializer.TokenisableIntegerDeserializer;
import com.smatechnologies.opcon.restapiclient.jackson.deserializer.ZonedDateTimeJsonDeserializer;
import com.smatechnologies.opcon.restapiclient.jackson.serializer.DateJsonSerializer;
import com.smatechnologies.opcon.restapiclient.jackson.serializer.LocalDateJsonSerializer;
import com.smatechnologies.opcon.restapiclient.jackson.serializer.LocalDateTimeJsonSerializer;
import com.smatechnologies.opcon.restapiclient.jackson.serializer.OffsetTimeJsonSerializer;
import com.smatechnologies.opcon.restapiclient.jackson.serializer.TokenisableIntegerSerializer;
import com.smatechnologies.opcon.restapiclient.jackson.serializer.ZonedDateTimeJsonSerializer;
import com.smatechnologies.opcon.restapiclient.model.TokenisableInteger;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetTime;
import java.time.ZonedDateTime;
import java.util.Date;


/**
 * Jackson module implementation used to auto-magically serialize/deserialize {@link Date} objects to/from Json.
 *
 * @author Pierre PINON
 * @author Francois EYL
 */
public class DefaultSimpleModule extends SimpleModule {

    public DefaultSimpleModule() {
        addSerializer(Date.class, new DateJsonSerializer());
        addDeserializer(Date.class, new DateJsonDeserializer());
        addSerializer(LocalDateTime.class, new LocalDateTimeJsonSerializer());
        addDeserializer(LocalDateTime.class, new LocalDateTimeJsonDeserializer());
        addSerializer(LocalDate.class, new LocalDateJsonSerializer());
        addDeserializer(LocalDate.class, new LocalDateJsonDeserializer());
        addSerializer(ZonedDateTime.class, new ZonedDateTimeJsonSerializer());
        addDeserializer(ZonedDateTime.class, new ZonedDateTimeJsonDeserializer());
        addSerializer(OffsetTime.class, new OffsetTimeJsonSerializer());
        addDeserializer(OffsetTime.class, new OffsetTimeJsonDeserializer());
        addSerializer(TokenisableInteger.class, new TokenisableIntegerSerializer());
        addDeserializer(TokenisableInteger.class, new TokenisableIntegerDeserializer());
    }
}
