package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class configuration {

    @Bean("thisone")
    @Primary
    public newCoach getCoach() {
       return new newCoach();
    }
}
