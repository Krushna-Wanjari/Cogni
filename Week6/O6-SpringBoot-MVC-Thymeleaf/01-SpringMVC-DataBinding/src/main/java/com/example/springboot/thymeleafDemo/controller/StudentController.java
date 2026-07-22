package com.example.springboot.thymeleafDemo.controller;

import com.example.springboot.thymeleafDemo.entity.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${CountryList}")
    List<String> list ;

    @Value("${LangList}")
    List<String> langList ;

    @Value("${Gender}")
    List<String> genderList ;

    @RequestMapping("/showstudent")
    public String showStudent(Model model) {
        model.addAttribute("countries",list);
        model.addAttribute("langs",langList);
        model.addAttribute("gender",genderList);
        return "helloworld-form";
    }

    @RequestMapping("/result")
    public String result(Student student , Model model) {

        model.addAttribute("student",student);
        return "helloworld";

    }

}
