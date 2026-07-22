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
          createStudent(student);
		};
	}

	public void createStudent(daoImplementation st){
		Student student = new Student("Krushna " , "Wanjari" , "krushnawanjari8@gmail.com");
		st.save(student);
	}

}
