package com.mike.dojosurvey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index(){
		return "index.jsp";
	}
	
	@RequestMapping(value="/result", method=RequestMethod.POST)
	public String results(@RequestParam(value="name") String name,
						 @RequestParam(value="location") String location,
						 @RequestParam(value="language") String language, 
						 @RequestParam(value="message") String message,
						 
						 Model viewModel){
		viewModel.addAttribute("name", name);
		viewModel.addAttribute("location", location);
		viewModel.addAttribute("language", language);
		viewModel.addAttribute("message", message);
		return "result.jsp";
	}
}
