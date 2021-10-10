package com.springboot.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	//GET HTTP Method
	//https://localhost:8080/hello-world
	
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World!";
	}
}
