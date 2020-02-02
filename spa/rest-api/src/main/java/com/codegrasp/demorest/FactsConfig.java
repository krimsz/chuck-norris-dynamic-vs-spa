package com.codegrasp.demorest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class FactsConfig {

    @Value("${chuck-api.fetch-rate-ms}")
    private String fetchRate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean
    public String fetchRate() {
        return this.fetchRate;
    }
}
