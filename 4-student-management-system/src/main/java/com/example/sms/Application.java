package com.example.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.sms.entity.Student;
import com.example.sms.repository.StudentRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Autowired
	StudentRepository repo;

	@Override
	public void run(String... args) throws Exception {
		
//		repo.save(new Student("Punam","Jasud","punamjasud@gmail.com"));
//		repo.save(new Student("Krishna","Jadhav","krishjadhav39@gmail.com"));
//		repo.save(new Student("Vidya","Jasud","vidya@gmail.com"));
		
	}

}
