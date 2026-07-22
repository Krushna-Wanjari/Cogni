package com.example.demo;

import com.example.demo.dao.AppDao;
import com.example.demo.dao.DaoImple;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoCommandLineRunner(AppDao appDao) {
		return runner->{
			//createInstructor(appDao);
			removeInstuctor(appDao);
		};
	}

	private void removeInstuctor(AppDao appDao) {
		appDao.delete(2);
	}

	private void createInstructor(AppDao dao) {
		Instructor instructor = new Instructor("Gopal","gopu@gmail.com","Yadav");
		InstructorDetail instructorDetail = new InstructorDetail("myYouTubeChanne" , "dance");

		instructor.setInstructor_detail_id(instructorDetail);
		System.out.println("Instructor created : "+ instructor);

		dao.save(instructor);

	}
}
