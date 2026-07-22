package com.example.demo.dao;

import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface AppDao {

    public void save(Instructor instructor);
    public Instructor findById(int id);
    public List<Instructor> findAll();
    public void delete(int id);
    public InstructorDetail findInstructorDetail(int id);
}
