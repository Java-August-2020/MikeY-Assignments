package com.mike.dojosninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mike.dojosninjas.models.Dojo;
import com.mike.dojosninjas.services.DojoService;

@Controller
public class DojoController {

	@Autowired
	private DojoService dService;

	
	//display all dojos
		@RequestMapping("/dojos")
		public String displayInfo(Model viewModel) {
			viewModel.addAttribute("dojos", dService.allDojos());
			return "dojos/index.jsp";
		}
		
	//create new dojo page
	@RequestMapping("/dojos/new")
	public String newDisplay(@ModelAttribute("dojo") Dojo newDojo) {
		return "/dojos/new.jsp";
	}
	
		
	//create dojo
	//this will redirect to /dojos and display all of them after we add a new dojo
		@PostMapping("/dojos")
		public String createNew(@Valid @ModelAttribute("dojo") Dojo newDojo, BindingResult result) {
			if (result.hasErrors()) {
				return "/dojos/new.jsp";
			} else {
				this.dService.createDojo(newDojo);
				// redirect back to /dojos because we have the 1st requestmapping set to dojos/index.jsp so it will return this page. 
				return "redirect:/dojos";
			}
		}
		
		//show the table
		@RequestMapping("/dojos/{id}")
		public String Show(@PathVariable("id") Long id, Model model) {
			model.addAttribute("dojo", this.dService.findDojo(id));
			return "/dojos/show.jsp";
		}
}
