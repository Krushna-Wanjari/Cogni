package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class smallCoach implements coach{

    @Override
    public String getCoach() {
        return "Coach is small in height";
    }
}
