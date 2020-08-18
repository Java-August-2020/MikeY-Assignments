package com.mike.routing2.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class CodingController {
	@RequestMapping("")
	public String index() {
		return "Hello Coding Dojo";
	}
	@RequestMapping("/greeting")
	public String greeting() {
		return "Howdy, hope your day is going well";
	}
	@RequestMapping("/day")
	public String day() {
		return "Today is a good day";
	}
	@RequestMapping("/python")
	public String python() {
		return "Python/Django was awesome!";
	}
	@RequestMapping("/java")
	public String java() {
		return "Java/Spring is better!";
	}
}
	
	