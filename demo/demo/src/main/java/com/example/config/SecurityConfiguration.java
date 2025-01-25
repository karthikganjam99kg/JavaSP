package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(requests -> requests  // Use authorizeHttpRequests instead of authorizeRequests
                        .requestMatchers("/api/conversion/**").permitAll()  // Permit access to this specific path
                        .anyRequest().permitAll())
                .csrf(csrf -> csrf.disable());  // Disable CSRF for testing (can enable for production)
        return http.build();
    }
}
