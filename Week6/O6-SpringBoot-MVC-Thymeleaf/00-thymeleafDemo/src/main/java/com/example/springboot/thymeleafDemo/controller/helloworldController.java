package com.example.springboot.thymeleafDemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class helloworldController {

    @RequestMapping("/showform")
    public String showform(){
        return "helloworld-form";
    }

    @RequestMapping("/postform")
    public String postform(){
        return "helloworld";
    }

    @RequestMapping("/postformv2")
    public String getShoutOut(HttpServletRequest request , Model model){
        String name = request.getParameter("name");
        name = name.toUpperCase();

        String var = "Yo!! " + name;

        model.addAttribute("var", var);
        return "helloworld";
    }

    @RequestMapping("/postformv3")
    public String getShoutOut2(@RequestParam("name") String name, Model model){
        name = name.toUpperCase();

        String var = "Yo!! " + name;

        model.addAttribute("var", var);
        return "helloworld";
    }
}
