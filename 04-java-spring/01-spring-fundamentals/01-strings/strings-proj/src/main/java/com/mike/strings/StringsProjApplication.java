package com.mike.strings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StringsProjApplication {
	//Entry Point Method

	public static void main(String[] args) {
		SpringApplication.run(StringsProjApplication.class, args);
	}
	
	@RequestMapping("/")
	public String hello() {
		return "Hello client! How are you doing?";
	}
	
	@RequestMapping("/random")
	public String welcome() {
		return "Welcome to Spring Boot!";
	}
}
