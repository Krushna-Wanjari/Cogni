package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class funController {
    private coach s;

    @Autowired
    public void funContoller(@Qualifier("heavyCoach") coach thecoach) {
        this.s = thecoach;
    }

    @Autowired
    public void setmethod(@Qualifier("smallCoach") coach thecoach) {
        this.s = thecoach;
    }

    @GetMapping("/coach")
    public String getCoach() {
        return s.getCoach();
    }
}
