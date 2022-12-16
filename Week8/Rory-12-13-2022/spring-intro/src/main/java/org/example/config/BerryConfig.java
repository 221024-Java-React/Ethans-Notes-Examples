package org.example.config;

import org.example.entity.Berry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BerryConfig {

    @Bean
    public Berry berry() {
        return new Berry("oran", "heal 10 HP");
    }
}
