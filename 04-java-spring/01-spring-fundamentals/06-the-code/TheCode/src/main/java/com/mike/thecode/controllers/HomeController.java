package com.mike.thecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

	private Boolean isCorrectCode(String guess) {
		return guess.equals("bushido");
	}
	
	@RequestMapping("/")
	public String index(){
		return "index.jsp";
	}
	@RequestMapping(value="/attempt", method=RequestMethod.POST)
	public String attempt(@RequestParam(value="guess") String guess,
			Model model, RedirectAttributes Attributes) {
		if(isCorrectCode(guess)) {
			return "redirect:/code";
		}
		Attributes.addFlashAttribute("error", "Invalid code, try again");
		return "redirect:/";	
	}
	@RequestMapping("/code")
	public String code() {
		return "code.jsp";
	}
}
