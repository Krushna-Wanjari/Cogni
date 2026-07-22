package com.example.common;

import org.springframework.stereotype.Component;

@Component
public class bigCoach implements coach{

    @Override
    public String getCoach() {
        return "bigcoach implements the coach";
    }
}
