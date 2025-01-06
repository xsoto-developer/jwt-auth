package org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.xsoto.springcloud.msvc.auth.msvc_jwt_auth.jwt.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
            return  http
                    // por defecto springboot habilita csrf
                    .csrf(csrf->csrf //Cross-site Request Forgery(CRRF) es una medida de seguridad que se utiliza
                                     //para agregar a las solicitudes post basada en un token csrf valido
                                     // se dehabilita por que trabajaremos en un token propio
                        .disable())
                            .authorizeHttpRequests(authRequest -> authRequest
                            .requestMatchers("/auth/**").permitAll()
                            .anyRequest().authenticated()
            )
                    .sessionManagement(sessionManager ->
                            sessionManager
                                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .authenticationProvider(authenticationProvider)
                    .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                    .build();
    }

}
