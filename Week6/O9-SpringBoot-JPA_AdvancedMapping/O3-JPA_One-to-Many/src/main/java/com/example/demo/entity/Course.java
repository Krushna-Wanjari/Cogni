package com.example.demo.entity;
import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE ,
            CascadeType.REFRESH ,  CascadeType.DETACH })
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    public Course() {}

    public Course(String title, Instructor instructor) {
        this.title = title;
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", instructor=" + instructor +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructorId(Instructor instructor) {
        this.instructor = instructor;
    }
}
