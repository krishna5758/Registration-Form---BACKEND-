package com.regidtration.registration01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()  // Disable CSRF for APIs
            .authorizeHttpRequests()  // Use authorizeHttpRequests instead of authorizeRequests
            .requestMatchers("/api/**").permitAll()  // Replace antMatchers with requestMatchers
            .anyRequest().authenticated();  // Secure other endpoints
        return http.build();
    }
}
