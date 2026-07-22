package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class funController {

    private coach c;
    @Autowired
    public funController(@Qualifier("thisone") coach co) {
        this.c = co;
    }

    @GetMapping("/coach")
    public String getCoach() {
        return c.getCoach();
    }
}
