package com.spring.demo.rest;

import com.spring.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/api")
public class studentRestController {

    private List<Student> list ;

    @PostConstruct
    public void setData() {
        list = new ArrayList<>();
        list.add(new Student("Krushna" , "Wanjari"));
        list.add(new Student("Sneha" , "Wanjari"));
        list.add(new Student("Manthan" , "Wanjari"));
    }

    @GetMapping("/student")
    public List<Student> studentlist(){
        return list;
    }

    @GetMapping("student/{studentId}")
    public Student getStudent(@PathVariable("studentId") int studentId){

        if(studentId >= list.size() || studentId < 0){
            throw new StudentNotFoundException("Student id not found" + studentId );
        }
        return list.get(studentId);
    }


}
