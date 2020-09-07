package com.mike.licenseassignment.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mike.licenseassignment.models.License;
import com.mike.licenseassignment.models.Person;
import com.mike.licenseassignment.services.LicenseService;
import com.mike.licenseassignment.services.PersonService;

@Controller
public class PersonController {

	@Autowired
	private PersonService pService;
	@Autowired
	private LicenseService lService;
	
	//display all people
	@RequestMapping("/")
	public String displayInfo(Model viewModel) {
		viewModel.addAttribute("persons", pService.getAllPeople());
		return "info.jsp";
	}
	
	//create new person page
	@RequestMapping("/persons/new")
	public String newDisplay(@ModelAttribute("person") Person newPerson) {
		return "/persons/new.jsp";
	}
//show one persons info
	@RequestMapping("/persons/{id}")
	public String ShowPerson(@PathVariable("id") Long id, Model model) {
		model.addAttribute("person", pService.getPerson(id));
		return "show.jsp";
	}
	
	//create an actual new person
	@PostMapping("/info")
	public String createNew(@Valid @ModelAttribute("person") Person newPerson, BindingResult result) {
		System.out.println("!!!!!!!!!getting here");
		if (result.hasErrors()) {
			return "/persons/new.jsp";
		} else {
			this.pService.createPerson(newPerson);
			return "redirect:/";
		}
	}
	//create new license page
	@RequestMapping("/licenses/new")
	public String newLicenseDisplay(@ModelAttribute("license") License newLicense, Model viewModel) {
		List<Person> allPeeps = pService.getAllPeople();
		viewModel.addAttribute("persons", allPeeps);
		return "/licenses/new.jsp";
	}
	
	@PostMapping("/show")
	public String createNew(@Valid @ModelAttribute("license") License newLicense, BindingResult result, Model viewModel) {
		if (result.hasErrors()) {
			List<Person> allPeeps = pService.getAllPeople();
			viewModel.addAttribute("persons", allPeeps);
			return "/persons/new.jsp";
		} else {
			this.lService.createLicense(newLicense);
			return "redirect:/";
			
		}
	}
}
