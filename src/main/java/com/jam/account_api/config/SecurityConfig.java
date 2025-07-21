package com.jam.account_api.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    /**
     * Configures the HTTP security filter chain.
     *
     * @param http the HttpSecurity object to configure
     * @return the configured SecurityFilterChain
     * @throws Exception if a security configuration error occurs
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())        // Disable CSRF (for stateless APIs)
            .cors().and()                        // Enable CORS
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll()  // Allow open access to auth routes
                .anyRequest().authenticated()                // Secure all other routes
            )
            .exceptionHandling(ex -> ex
                .authenticationEntryPoint(unauthorizedJsonEntryPoint()) // Return JSON error
            );

        return http.build();
    }

    /**
     * Returns a 401 Unauthorized response in JSON format for unauthenticated users.
     *
     * @return AuthenticationEntryPoint returning a JSON error
     */
    @Bean
    public AuthenticationEntryPoint unauthorizedJsonEntryPoint() {
        return (HttpServletRequest request, HttpServletResponse response,
                org.springframework.security.core.AuthenticationException authException) -> {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("{\"error\": \"Unauthorized access\"}");
        };
    }
}
