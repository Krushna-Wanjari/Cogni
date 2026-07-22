package com.sqlProject.cruddemo.dao;

import com.sqlProject.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class daoImplementation implements StudentDao {
    private EntityManager em;

    @Autowired
    public daoImplementation(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
     em.persist(student);
    }

    @Override
    public Student find(Integer id) {
        return em.find(Student.class, id);
    }

}
