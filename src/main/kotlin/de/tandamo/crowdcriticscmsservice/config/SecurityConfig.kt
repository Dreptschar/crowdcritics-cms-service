package de.tandamo.crowdcriticscmsservice.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.reactive.CorsWebFilter
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource

@Configuration
@EnableWebSecurity
class SecurityConfig{
    @Bean
    fun filterChain(http: HttpSecurity): DefaultSecurityFilterChain {
        http.authorizeHttpRequests().anyRequest().authenticated().and().oauth2ResourceServer().jwt()
        return http.build()
    }

    @Bean
    public fun corsWebFilter(): CorsWebFilter {
        val corsConfig: CorsConfiguration = CorsConfiguration();
        corsConfig.allowedOrigins = listOf("*");
        corsConfig.maxAge = 3600L;
        corsConfig.allowedMethods = listOf("GET", "POST");
        corsConfig.addAllowedHeader("*");
        val source: UrlBasedCorsConfigurationSource = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", corsConfig);
        return CorsWebFilter(source);
    }
}