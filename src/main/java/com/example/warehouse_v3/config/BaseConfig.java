package com.example.warehouse_v3.config;

import com.example.warehouse_v3.properties.OpenApiProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Configuration
@OpenAPIDefinition
@EnableConfigurationProperties( value = {
        OpenApiProperties.class} )
@EnableTransactionManagement
//@EnableJpaAuditing( auditorAwareRef = "auditorProvider" )
public class BaseConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
