package com.SpringBoot.CrudDemo.dao;

import com.SpringBoot.CrudDemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpolyeeDaoImp implements daoEmployee {

    private EntityManager em;

    @Autowired
    public EmpolyeeDaoImp(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Employee> getAllEmployees() {
        TypedQuery<Employee> query = em.createQuery("from Employee", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee getSingleEmployee(Integer id) {
        Employee employee = em.find(Employee.class, id);
        return employee;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        Employee emp = em.merge(employee);
        return emp;
    }

    @Override
    public void deleteEmployee(Integer id) {
        em.remove(getSingleEmployee(id));
    }
}
