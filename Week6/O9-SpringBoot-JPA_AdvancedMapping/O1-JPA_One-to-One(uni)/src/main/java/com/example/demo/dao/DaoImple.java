package com.example.demo.dao;

import com.example.demo.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DaoImple implements AppDao{

    private EntityManager em;

    public DaoImple(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
       em.persist(instructor);
    }

    @Override
    public Instructor findById(int id){
        return em.find(Instructor.class,id);
    }

    @Override
    public List<Instructor> findAll() {
        return em.createQuery("from Instructor",Instructor.class).getResultList();
    }

    @Override
    @Transactional
    public void delete(int id) {
        Instructor instructor = em.find(Instructor.class,id);
       em.remove(instructor);
    }
}
