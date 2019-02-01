package com.agileactors.config;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterRegistry;
import org.springframework.stereotype.Component;

@Component
final class ConverterRegistrar {

    @Autowired
    ConverterRegistrar(Optional<List<Converter>> converters, ConverterRegistry converterRegistry) {
        converters.ifPresent(c -> c.forEach(converterRegistry::addConverter));
    }
}
