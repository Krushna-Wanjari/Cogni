package com.SpringBoot.CrudDemo.JPARepo;

import com.SpringBoot.CrudDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpaRepo extends JpaRepository<Employee,Integer> {
}
