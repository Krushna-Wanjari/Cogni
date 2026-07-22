package com.sqlProject.cruddemo;

import com.sqlProject.cruddemo.dao.daoImplementation;
import com.sqlProject.cruddemo.entity.Student;
import org.hibernate.collection.spi.PersistentBag;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(daoImplementation student) {
		return runner -> {
			//createStudent(student);
			//searchStudents(student);
			//searchStudentbyLastName(student);
			//searchAllStuddents(student);
			updateStudent(student);
		};
	}

	private void updateStudent(daoImplementation student) {
		Student s = student.search(2);
		s.setFirstName("Yoolo");
		s.setLastName("bandi");
		student.update(s);
		System.out.println(s);
	}

	private void searchStudentbyLastName(daoImplementation student) {
		List<Student> lst = student.findByLastName("B");
		for (Student s : lst) {
			System.out.println(s);
		}
	}

	private void searchAllStuddents(daoImplementation student) {
		List<Student> list = student.searchAll();

		for (Student s : list) {
			System.out.println(s);
		}

	}

	private void searchStudents(daoImplementation student) {
		System.out.println("Enter Student ID");
		Scanner sc = new Scanner(System.in);
		Integer id = sc.nextInt();

		Student s = student.search(id);
		System.out.println(s);

	}

	private void createStudent(daoImplementation student) {
		Student st1 =  new Student("A" , "B" , "xyz");
		student.save(st1);
		Student st2 =  new Student("C" , "D" , "yxz");
		student.save(st2);
		Student st3 =  new Student("E" , "F" , "ZXY");
		student.save(st3);
		System.out.println(st1);
		System.out.println(st2);
		System.out.println(st3);
	}


}
