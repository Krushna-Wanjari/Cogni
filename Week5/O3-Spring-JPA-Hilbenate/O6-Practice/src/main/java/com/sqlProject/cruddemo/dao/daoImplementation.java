package com.sqlProject.cruddemo.dao;

import com.sqlProject.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class daoImplementation implements StudentDao {
    private EntityManager em;

    @Autowired
    public daoImplementation(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void save(Student student) {
        em.persist(student);
    }

    @Override
    public Student search(Integer id) {
        Student st = em.find(Student.class, id);
        return st;
    }

    @Override
    public List<Student> searchAll() {
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s ", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery query =  em.createQuery("SELECT s FROM Student s WHERE s.lastName = :lastName", Student.class);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
      em.merge(student);
    }

    @Override
    public void delete(Integer id) {

    }
}
