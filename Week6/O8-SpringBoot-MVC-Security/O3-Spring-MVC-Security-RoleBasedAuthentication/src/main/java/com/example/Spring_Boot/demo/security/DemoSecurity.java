package com.example.Spring_Boot.demo.security;

import jakarta.servlet.FilterChain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurity {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){

        UserDetails user1 =  User.builder()
                .username("John")
                .password("{noop}test123")
                .roles("USER")
                .build();

        UserDetails user2 =  User.builder()
                .username("Ram")
                .password("{noop}test123")
                .roles("USER","MANAGER")
                .build();

        UserDetails user3 =  User.builder()
                .username("Bablu")
                .password("{noop}test123")
                .roles("USER","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user1,user2,user3);
    }

    // bean for making spring redirect to custom login form:
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers("/").hasRole("USER")
                        .requestMatchers("/leaders/**").hasRole("MANAGER")
                        .requestMatchers("/systems/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
        )
                .formLogin(form->
                        form
                                .loginPage("/showMyLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()

                )
                .logout(logout-> logout.permitAll())

        ;
        return http.build();
    }
}
