package com.agileactors.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Autowired
    private ObjectMapper objectMapper;

    @Bean(name = "customerRestTemplate")
    public RestTemplate customerRestTemplate() {
        return createRestTemplate();
    }

    @Bean(name = "auditLogRestTemplate")
    public RestTemplate auditLogRestTemplate() {
        return createRestTemplate();
    }

    private RestTemplate createRestTemplate() {
        List<HttpMessageConverter<?>> httpMessageConverterList = new ArrayList<>();
        httpMessageConverterList.add(new MappingJackson2HttpMessageConverter(objectMapper));
        httpMessageConverterList.add(new StringHttpMessageConverter());
        httpMessageConverterList.add(new FormHttpMessageConverter());
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(httpMessageConverterList);
        return restTemplate;
    }
}
