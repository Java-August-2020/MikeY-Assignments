package com.mike.dojosninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mike.dojosninjas.models.Ninja;
import com.mike.dojosninjas.services.DojoService;
import com.mike.dojosninjas.services.NinjaService;

@Controller
public class NinjaController {

	@Autowired
	private NinjaService nService;
	
	@Autowired 
	private DojoService dService;
	
	
	//display all dojos
	@RequestMapping("/ninjas")
	public String displayNinjas(Model viewModel) {
		viewModel.addAttribute("ninjas", nService.allNinjas());
		return "ninjas/index.jsp";
	}
	
	//create new ninja page and make sure we have the viewModel to see the dojos!
		@RequestMapping("/ninjas/new")
		public String newDisplay(@ModelAttribute("ninja") Ninja newNinja, Model viewModel) {
			viewModel.addAttribute("dojos", dService.allDojos());
			return "/ninjas/new.jsp";
		}
		
	//create an actual Ninja
	//this will redirect to /dojos and display all of them after we add a new dojo
	@PostMapping("/ninjas")
	public String createNew(@Valid @ModelAttribute("ninja") Ninja newNinja, BindingResult result, Model viewModel) {
		if (result.hasErrors()) {
			viewModel.addAttribute("dojos", dService.allDojos());
			return "/ninjas/new.jsp";
		} else {
			this.nService.createNinja(newNinja);
			// redirect back to /ninjas because we have the 1st requestmapping set to ninjas/index.jsp so it will return this page. 
			return "redirect:/ninjas";
		}
	}
}
