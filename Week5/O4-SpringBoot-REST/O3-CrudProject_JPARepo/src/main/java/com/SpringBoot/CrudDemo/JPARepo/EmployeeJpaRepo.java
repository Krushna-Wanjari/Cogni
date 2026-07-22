package com.SpringBoot.CrudDemo.JPARepo;

import com.SpringBoot.CrudDemo.entity.Employee;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface EmployeeJpaRepo extends JpaRepositoryImplementation<Employee,Integer> {
}
