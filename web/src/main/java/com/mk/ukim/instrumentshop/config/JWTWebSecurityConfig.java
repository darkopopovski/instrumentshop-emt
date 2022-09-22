package com.mk.ukim.instrumentshop.config;

import com.mk.ukim.instrumentshop.config.filters.JWTAuthorizationFilter;
import com.mk.ukim.instrumentshop.config.filters.JwtAuthenticationFilter;
import com.mk.ukim.instrumentshop.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Order(200)
@Configuration
@Profile("jwt")
@AllArgsConstructor
public class JWTWebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    //private final CustomUsernamePasswordAuthenticationProvider authenticationProvider;
    private final UsersService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home", "/assets/**", "/register", "/products", "/api/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager(), (UserDetailsService) userService, passwordEncoder, userService))
                .addFilter(new JWTAuthorizationFilter(authenticationManager(), (UserDetailsService) userService))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }
}
