package com.agileactors.databind;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Component
public class ObjectMapperFactory implements FactoryBean<ObjectMapper> {

    @Override
    public ObjectMapper getObject() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        return builder.createXmlMapper(false)
            .failOnUnknownProperties(false)
            .featuresToDisable(
                SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
                SerializationFeature.WRAP_EXCEPTIONS,
                DeserializationFeature.WRAP_EXCEPTIONS,
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES
            )
            .featuresToEnable(
                DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL,
                MapperFeature.AUTO_DETECT_IS_GETTERS
            )
            .serializationInclusion(JsonInclude.Include.NON_NULL)
            .build();
    }

    @Override
    public Class<?> getObjectType() {
        return ObjectMapper.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
