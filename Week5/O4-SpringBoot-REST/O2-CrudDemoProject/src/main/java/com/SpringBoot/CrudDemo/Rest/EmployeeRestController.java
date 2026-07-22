package com.SpringBoot.CrudDemo.Rest;

import com.SpringBoot.CrudDemo.Service.EmployeeService;
import com.SpringBoot.CrudDemo.dao.daoEmployee;
import com.SpringBoot.CrudDemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService es;
    @Autowired
    public EmployeeRestController(EmployeeService es) {
        this.es = es;
    }

    @GetMapping("/Employee")
    public List<Employee> getAllEmployees() {
        return es.findAll();
    }

    @PostMapping("/Employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        //employee.setId(0);
        es.save(employee);
        return employee;
    }

    @PutMapping("/Employee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return es.save(employee);
    }

    @DeleteMapping("/Employee/{id}")
    public void deleteEmployee(@PathVariable int id) {
        es.deleteById(id);

    }

    @PatchMapping("/Employee/{id}")
    public Employee updateEmployee(@RequestBody Employee employee,@PathVariable int id) {

    }
}
