package com.punam.springbootdemousingspringinitializr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.punam.springbootdemousingspringinitializr.sub1.SpringComponent;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext appContext = SpringApplication.run(Application.class, args);
		SpringComponent comp = appContext.getBean(SpringComponent.class);
		System.out.println(comp.getMessage());
		System.out.println("Spring Boot Application Started");
	}

}
