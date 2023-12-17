package com.raifmirza.passwordapp.security;

import com.raifmirza.passwordapp.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserServiceImpl userService){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(configurer -> configurer
                        .requestMatchers("/register/**").permitAll()
                        .requestMatchers("/login").authenticated()
                        .requestMatchers("/users").hasRole("EMPLOYEE")
//                        .requestMatchers("/users/**").hasAnyRole("MANAGER","ADMIN")
                        .anyRequest().permitAll())
                .httpBasic(withDefaults())
                .formLogin(withDefaults())
                .csrf().disable();

        return httpSecurity.build();
    }
 }
