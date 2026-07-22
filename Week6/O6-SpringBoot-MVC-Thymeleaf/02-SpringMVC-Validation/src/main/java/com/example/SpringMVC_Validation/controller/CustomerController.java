package com.example.SpringMVC_Validation.controller;

import com.example.SpringMVC_Validation.model.Customer;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

     @GetMapping("/show")
     public String show(Model model) {

         model.addAttribute("customer", new Customer());
         return "show";
     }

     @PostMapping("/conformation")
    public String conformation(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model model) {

         model.addAttribute("customer", customer);
         if (result.hasErrors()) {
             return "show";
         }
         return "conformation";

     }
}
