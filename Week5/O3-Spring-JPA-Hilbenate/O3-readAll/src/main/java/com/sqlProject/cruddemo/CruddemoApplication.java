package com.sqlProject.cruddemo;

import com.sqlProject.cruddemo.dao.daoImplementation;
import com.sqlProject.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(daoImplementation student){
		return runner -> {
		  find(student);
		};
	}

	private void findall(daoImplementation student) {
		List<Student> students = student.findAll();
		for(Student s :  students){
			System.out.println(s);
		}
	}
	private void find(daoImplementation student) {
		List<Student> students = student.findByLastName("W");
		for(Student s :  students){
			System.out.println(s);
		}
	}


}
