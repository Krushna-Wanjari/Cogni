package com.sqlProject.cruddemo;

import com.sqlProject.cruddemo.dao.daoImplementation;
import com.sqlProject.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(daoImplementation student){
		return runner -> {
		  readStudent(student);
		};
	}

	private void readStudent(daoImplementation st) {
		System.out.println("Saving student");
		Student student = new Student("K " , "W" , "krushnawanjari9@gmail.com");
		st.save(student);

		Integer id = student.getId();
		Student classname =  st.find(id);
		System.out.println(classname);


	}

	public void createStudent(daoImplementation st){
		Student student = new Student("K " , "W" , "krushnawanjari9@gmail.com");
		st.save(student);
	}

}
