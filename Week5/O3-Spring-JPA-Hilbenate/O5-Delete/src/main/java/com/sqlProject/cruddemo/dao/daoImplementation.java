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

    @Override
    public List<Student> findAll(){
        TypedQuery<Student> query = em.createQuery("FROM Student", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = em.createQuery("FROM Student WHERE lastName = :thedata", Student.class);
        query.setParameter("thedata", lastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student){
        em.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id){
        Student student = em.find(Student.class, id);
        em.remove(student);
    }

}
