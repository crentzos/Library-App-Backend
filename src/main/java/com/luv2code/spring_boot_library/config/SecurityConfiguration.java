package com.luv2code.spring_boot_library.config;

import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Disable Cross Site Request Forgery (CSRF) protection
        http.csrf().disable();

        // Allow CORS using the global configuration from WebConfig
        http.cors();

        // Allow OPTIONS requests to bypass security for CORS preflight checks
        http.authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()  // Allow all preflight CORS requests
                .antMatchers("/api/books/secure/**", "/api/reviews/secure/**",
                        "/api/messages/secure/**", "/api/admin/secure/**")
                .authenticated()  // Secure these paths
                .anyRequest().permitAll();  // Permit all other requests

        // Configure OAuth2 Resource Server with JWT authentication
        http.oauth2ResourceServer()
                .jwt();

        // Add content negotiation strategy
        http.setSharedObject(ContentNegotiationStrategy.class,
                new HeaderContentNegotiationStrategy());

        // Configure Okta to handle 401 responses
        Okta.configureResourceServer401ResponseBody(http);

        return http.build();
    }
}
