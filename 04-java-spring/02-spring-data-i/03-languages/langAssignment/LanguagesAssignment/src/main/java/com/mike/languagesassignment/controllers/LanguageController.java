package com.mike.languagesassignment.controllers;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mike.languagesassignment.models.Language;
import com.mike.languagesassignment.services.LanguageService;

@Controller
public class LanguageController {
	@Autowired
	private LanguageService langService;
	
	
	@RequestMapping("/")
	public String index(@ModelAttribute("language") Language language, Model viewModel) {
		List<Language> languages = this.langService.getAllLangs();
		viewModel.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	@RequestMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("language", langService.findLanguage(id));
		return "show.jsp";
	}
	
//	@PostMapping("/")
//	public String createNew(@RequestParam("language") String language, @RequestParam("creator") String creator, 
//			@RequestParam("version") Float version, RedirectAttributes redirectAttr) {
//			ArrayList<String> errors = new ArrayList<String>();
//			if (language.equals("")) {
//				errors.add("hey there you forgot to add a language");
//			}
//			if (errors.size() > 0) {
//				for(String e: errors) {
//					redirectAttr.addFlashAttribute("errors", e);
//				}
//				return "redirect:/new";
//			}
//		this.langService.createLanguage(language, creator, version);
//		return "redirect:/";
//	}
	
	@PostMapping("")
	public String createNew(@Valid @ModelAttribute("language") Language newLanguage, BindingResult result) {
		if (result.hasErrors()) {
			return "new.jsp";
		} else { 
			this.langService.createLanguage(newLanguage);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/new")
	public String newDisplay(@ModelAttribute("language") Language language) {
		return "new.jsp";
	}
	
	
	@RequestMapping("/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("language", langService.findLanguage(id));
		return "edit.jsp";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("language") Language updatedLang, BindingResult result, @PathVariable("id") Long id) {
		System.out.println("getting here");
		if(result.hasErrors()) {
			System.out.println("!!!!!!!!!!!!error");
			return "edit.jsp";
		}
		langService.updateLanguage(updatedLang);
		System.out.println(updatedLang);
		return "redirect:/";
	}
		
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
		 public String deleteLang(@PathVariable("id") Long id) {
		langService.deleteLanguage(id);
		return "redirect:/";
	}
	
}
