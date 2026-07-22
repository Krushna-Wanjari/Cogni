package com.SpringBoot.CrudDemo.Service;

import com.SpringBoot.CrudDemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();
    Employee findById(Integer id);
    Employee save(Employee employee);
    void deleteById(Integer id);
}
