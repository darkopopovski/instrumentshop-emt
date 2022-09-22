package com.mk.ukim.instrumentshop.config;

import com.mk.ukim.instrumentshop.config.filters.JWTAuthorizationFilter;
import com.mk.ukim.instrumentshop.config.filters.JwtAuthenticationFilter;
import com.mk.ukim.instrumentshop.service.UsersService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    private final PasswordEncoder passwordEncoder;
    private final UsersService usersService;
    public WebSecurityConfig(
            PasswordEncoder passwordEncoder, UsersService usersService) {
        this.passwordEncoder = passwordEncoder;
        this.usersService = usersService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
//                .antMatchers("/").permitAll()
                .antMatchers("/login", "/projections", "/**", "/auditoriums", "/reserve/add", "/css/**",
                        "/tests/reserve/projection/add", "/reserve", "/reserve/projection/**",
                        "/view/movies/**", "/", "/movie/projections/detailed-preview/", "/tests", "/home/videos/**",
                        "/videos/**", "/projections/view", "/movies/view/**", "/home","/assets/css/**",
                        "/home/**", "/assets/**", "/register", "/movies", "/api/**", "/logout").permitAll()
                .antMatchers("/admin/**", "/projections/add-form", "/movies/add-form").hasRole("EMPLOYEE")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //.loginPage("/login").permitAll()
                .failureUrl("/login?error=BadCredentials")
                .defaultSuccessUrl("/home", true)
                .and()
                .logout()
                .logoutUrl("/logout")

                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/home")
                .and()
                .exceptionHandling().accessDeniedPage("/access_denied");

    }

    @Bean
    public JWTAuthorizationFilter authorizationFilter() throws Exception {
        return new JWTAuthorizationFilter(authenticationManager(), (UserDetailsService) usersService);
    }

    @Bean
    public JwtAuthenticationFilter authenticationFilter() throws Exception {
        return new JwtAuthenticationFilter(authenticationManager(), (UserDetailsService) usersService, passwordEncoder, usersService);
    }

}
