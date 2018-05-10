package com.master.spring.accessrestrictions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages ="com.master.spring.accessrestrictions.config.*")
public class SpringAccessrestrictionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAccessrestrictionsApplication.class, args);
	}
}
