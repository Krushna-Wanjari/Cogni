package com.SpringBoot.CrudDemo.dao;

import com.SpringBoot.CrudDemo.entity.Employee;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface daoEmployee {
    List<Employee> getAllEmployees();
    Employee getSingleEmployee(Integer id);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(Integer id);
}
