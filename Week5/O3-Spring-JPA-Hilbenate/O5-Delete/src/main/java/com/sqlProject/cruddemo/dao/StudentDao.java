package com.sqlProject.cruddemo.dao;

import com.sqlProject.cruddemo.entity.Student;

import java.util.List;

public interface StudentDao {

    public void save(Student student);
    public Student find(Integer id);
    public List<Student> findAll();
    public List<Student> findByLastName(String lastName);
    public void update(Student student);
    public void delete(Integer id);

}
