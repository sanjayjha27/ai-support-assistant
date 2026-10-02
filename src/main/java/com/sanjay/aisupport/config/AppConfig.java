package com.sanjay.aisupport.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class AppConfig {
    @Bean
    RestClient ollamaClient(RestClient.Builder builder) {
        return builder.baseUrl("http://localhost:11434").build();
    }
}