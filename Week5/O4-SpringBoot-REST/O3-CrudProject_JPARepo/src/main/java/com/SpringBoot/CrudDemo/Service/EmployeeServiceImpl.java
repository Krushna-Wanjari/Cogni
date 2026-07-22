package com.SpringBoot.CrudDemo.Service;

import com.SpringBoot.CrudDemo.JPARepo.EmployeeJpaRepo;
import com.SpringBoot.CrudDemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public EmployeeJpaRepo getEmployeeJpaRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeJpaRepo getEmployeeJpaRepo) {
        this.getEmployeeJpaRepo = getEmployeeJpaRepo;
    }

    @Override
    public List<Employee> findAll() {
        return getEmployeeJpaRepo.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return getEmployeeJpaRepo.findById(id).get();
    }

    @Override
    public Employee save(Employee employee) {
        return getEmployeeJpaRepo.save(employee);
    }

    @Override
    public void deleteById(Integer id) {
        getEmployeeJpaRepo.deleteById(id);
    }
}
