package com.ntndev.basicspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = User.builder()
                .username("truongnhu31")
                .password("$2a$10$DAIQ1s6iPDepZtkaAVlb9eRM48O/t9sXslmWgi/drnN8MW3bReKOi")
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("$2a$10$7jXjst4jb2RnKKO9pFCd3OeVkByeMYXtkBHU.16Cz7Z1YuWk9hi0K")
                .roles("USER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user,admin);
    }

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
