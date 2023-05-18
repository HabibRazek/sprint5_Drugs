package com.walter.drugs.sercurity;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

                .cors().configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest
                                                                          request) {
                        CorsConfiguration config = new CorsConfiguration();

                        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                        config.setAllowedMethods(Collections.singletonList("*"));
                        config.setAllowCredentials(true);
                        config.setAllowedHeaders(Collections.singletonList("*"));
                        config.setExposedHeaders(Arrays.asList("Authorization"));
                        config.setMaxAge(3600L);
                        return config;
                    }
                }).and().authorizeHttpRequests().anyRequest().permitAll();


              /*  .authorizeHttpRequests()
                .requestMatchers("/api/all/**").hasAnyAuthority("ADMIN","USER")
                .requestMatchers("/api/getbyid/**").hasAnyAuthority("ADMIN","USER")
                .requestMatchers(HttpMethod.POST,"/api/adddrug/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.PUT,"/api/updatedrug/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE,"/api/deldrug/**").hasAuthority("ADMIN")
                .requestMatchers("/drugclass/**").hasAnyAuthority("ADMIN","USER")
                .anyRequest().authenticated().and()
                .addFilterBefore(new JWTAuthorizationFilter(), BasicAuthenticationFilter.class);*/

        return http.build();

    }


}