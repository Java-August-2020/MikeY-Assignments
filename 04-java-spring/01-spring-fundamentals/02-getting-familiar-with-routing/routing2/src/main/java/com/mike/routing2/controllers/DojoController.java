package com.mike.routing2.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/{dojo}")

public class DojoController {
@RequestMapping("")
	public String userDojo(@PathVariable("dojo") String dojo) {
		return " the dojo is awesome";
	}

@RequestMapping("/{location}")
	public String userLocation(@PathVariable("location") String location) {
		if (location.equals("burbank")) {
			return "Burbank Dojo is located in Southern California";
		} else if (location.equals("san-jose")) {
			return "SJ dojo is the headquarters";
		}
		return location;
	}
}