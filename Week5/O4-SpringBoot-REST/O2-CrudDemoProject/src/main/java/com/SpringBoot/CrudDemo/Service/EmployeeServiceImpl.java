package com.SpringBoot.CrudDemo.Service;

import com.SpringBoot.CrudDemo.dao.daoEmployee;
import com.SpringBoot.CrudDemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public daoEmployee daoEmployeeObject;

    @Autowired
    public EmployeeServiceImpl(daoEmployee daoEmployeeObject) {
        this.daoEmployeeObject = daoEmployeeObject;
    }

    @Override
    public List<Employee> findAll() {
        return daoEmployeeObject.getAllEmployees();
    }

    @Override
    public Employee findById(Integer id) {
        return daoEmployeeObject.getSingleEmployee(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return daoEmployeeObject.saveEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        daoEmployeeObject.deleteEmployee(id);
    }
}
