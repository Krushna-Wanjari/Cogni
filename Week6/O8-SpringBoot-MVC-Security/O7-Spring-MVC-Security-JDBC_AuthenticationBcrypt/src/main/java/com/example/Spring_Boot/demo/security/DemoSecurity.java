package com.example.Spring_Boot.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurity {

    //just change the mysql script to algo as bcrypt and the pass bcryted
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return  new JdbcUserDetailsManager(dataSource);
    }

    /*@Bean
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
    }*/


    // bean for making spring redirect to custom login form:
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers("/").hasAnyAuthority("ROLE_EMPLOYEE")
                        .requestMatchers("/leaders/**").hasAnyAuthority("ROLE_MANAGER")
                        .requestMatchers("/systems/**").hasAnyAuthority("ROLE_ADMIN")
                        .anyRequest().authenticated()
        )
                //triggered when access is denied for specific role:
                .exceptionHandling(configurer->
                        configurer
                                .accessDeniedPage("/access-Denied")
                )
                //
                .formLogin(form->
                        form
                                .loginPage("/showMyLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()

                )
                //
                .logout(logout-> logout.permitAll())

        ;
        return http.build();
    }
}
