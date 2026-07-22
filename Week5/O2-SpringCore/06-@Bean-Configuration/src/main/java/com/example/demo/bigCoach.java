package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class bigCoach implements coach{

    @Override
    public String getCoach() {
        return "bigcoach implements the coach";
    }
}
