package com.SpringBoot.AspectOP;

import com.SpringBoot.AspectOP.dao.AccountDao;
import com.SpringBoot.AspectOP.dao.AccountDaoImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AspectOpApplication {

	public static void main(String[] args) {
		SpringApplication.run(AspectOpApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountDao accountDao) {
     return runner -> {
        demoTheBeforeAdvice(accountDao);
     };
	}

	private void demoTheBeforeAdvice(AccountDao accountDao) {
		accountDao.addAccount();
	}
}
