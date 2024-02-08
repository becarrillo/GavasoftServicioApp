package com.microservices.servicioapp.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    /**
     * @return el objeto de RestTemplate, una implementación de
     * comunicación http entre dos microservicios independientes
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
