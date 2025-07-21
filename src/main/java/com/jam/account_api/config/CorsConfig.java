package com.jam.account_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * CORS (Cross-Origin Resource Sharing) configuration class.
 *
 * This class allows the frontend client (e.g., Vite or React running on http://localhost:5173)
 * to access the backend API by configuring allowed origins, methods, and credentials.
 */
@Configuration
public class CorsConfig {

    /**
     * Defines the global CORS mapping settings.
     *
     * @return a WebMvcConfigurer that customizes CORS behavior
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            /**
             * Configures CORS mappings to allow requests from the frontend.
             *
             * @param registry the CORS registry
             */
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Apply CORS to all endpoints
                        .allowedOrigins("http://localhost:5173") // Allow requests from the frontend
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Allowed HTTP methods
                        .allowCredentials(true); // Allow cookies or credentials (e.g., Authorization headers)
            }
        };
    }
}

