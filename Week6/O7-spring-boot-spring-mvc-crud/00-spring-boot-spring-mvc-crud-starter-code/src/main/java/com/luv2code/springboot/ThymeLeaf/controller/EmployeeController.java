package com.luv2code.springboot.ThymeLeaf.controller;

import com.luv2code.springboot.ThymeLeaf.entity.Employee;
import com.luv2code.springboot.ThymeLeaf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    EmployeeService theEmployeeService;
    @Autowired
    public void setEmployeeService(EmployeeService theEmployeeService) {
        this.theEmployeeService = theEmployeeService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Employee> list = theEmployeeService.findAll();
        model.addAttribute("employee", list);
        return "employee/Employee-List";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
         Employee employee = new Employee();
         model.addAttribute("employee", employee);
         return "employee/employee-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("employee") Employee employee) {
        theEmployeeService.save(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId , Model model) {
        Employee employee = theEmployeeService.findById(theId);
        model.addAttribute("employee", employee);
        return "employee/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId) {
        theEmployeeService.deleteById(theId);
        return "redirect:/employees/list";
    }

}
