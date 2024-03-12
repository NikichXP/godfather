package com.nikichxp.godfather

import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service

@Service
class CustomAuthenticationManager : AuthenticationManager {

    @Value("\${spring.security.user.name}")
    private lateinit var defaultLogin: String

    @Value("\${spring.security.user.password}")
    private lateinit var defaultPassword: String

    override fun authenticate(authentication: Authentication): Authentication {
        return if (
            defaultLogin.equals(authentication.principal.toString(), ignoreCase = true) &&
            defaultPassword == authentication.credentials
        ) {
            UsernamePasswordAuthenticationToken(
                authentication.principal,
                authentication.credentials,
                authentication.authorities
            )
        } else {
            authentication // leaving default auth status -> it is set to false if none of the others is set it
        }
    }
}