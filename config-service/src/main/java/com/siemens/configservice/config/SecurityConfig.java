package com.siemens.configservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/actuator/**").authenticated()  // Allow actuator endpoints to be accessed without authentication
                    .requestMatchers("/config/**").authenticated()  // Secure configuration endpoints
                    .anyRequest().authenticated()  // Secure all other endpoints
            )
            .httpBasic();  // Enable HTTP Basic Authentication

        return http.build();
    }
}
