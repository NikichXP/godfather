package com.nikichxp.godfather

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val customAuthenticationManager: CustomAuthenticationManager
) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.csrf { it.disable() }
        http
            .authorizeHttpRequests { auth -> auth.anyRequest().authenticated() }
            .httpBasic(withDefaults())
            .authenticationManager(customAuthenticationManager)
        return http.build()
    }
}

