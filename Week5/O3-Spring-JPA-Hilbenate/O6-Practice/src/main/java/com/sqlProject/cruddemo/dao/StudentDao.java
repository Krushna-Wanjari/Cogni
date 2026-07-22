package com.sqlProject.cruddemo.dao;

import com.sqlProject.cruddemo.entity.Student;

import java.util.List;

public interface StudentDao {

    public void save(Student student);
    public Student search(Integer id);
    public List<Student> searchAll();
    public List<Student> findByLastName(String lastName);
    public void update(Student student);
    public void delete(Integer id);

}
