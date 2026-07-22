package com.example.springboot.thymeleafDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class demoController {

    @GetMapping("/hello")
    public String hello(Model model) {

        model.addAttribute("Time" , java.time.LocalTime.now());
        return "helloworld";
    }

}
