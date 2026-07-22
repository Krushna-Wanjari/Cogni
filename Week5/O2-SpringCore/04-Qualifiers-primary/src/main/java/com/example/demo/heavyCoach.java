package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class heavyCoach implements coach{

    @Override
    public String getCoach() {
        return "coach is very heavy";
    }
}
