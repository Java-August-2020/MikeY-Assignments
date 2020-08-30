package com.mike.showassignment.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mike.showassignment.models.Book;
import com.mike.showassignment.services.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bService;
	
	//display all books on main page
	@RequestMapping("/")
	public String index(Model viewModel) {
		List<Book> books = this.bService.getAllBooks();
		viewModel.addAttribute("allbooks", books);
		return "index.jsp";
	}
	
	@PostMapping("/")
	// to display errors we need valid and BindingResult
	public String createNew(@Valid @ModelAttribute("book") Book newBook, BindingResult result) {
		if (result.hasErrors()) {
			return "new.jsp";
		} else { 
			this.bService.createBook(newBook);
			return "redirect:/";
		}
	}
	
	
	//Antiquated way
//	the old way - @RequestMapping(value="/" method=RequestMethod.POST)
	@PostMapping("/oldway")
	public String createOldWay(@RequestParam("title") String title, @RequestParam("description") String description, 
			@RequestParam("language") String language, @RequestParam("pages") int pages, RedirectAttributes redirectAttr) {
			ArrayList<String> errors = new ArrayList<String>();
			if (title.equals("")) {
				errors.add("hey there you forgot to add a title");
			}
			if (errors.size() > 0) {
				for(String e: errors) {
					redirectAttr.addFlashAttribute("errors", e);
				}
				return "redirect:/new";
			}
		this.bService.createBook(title, description, language, pages);
		return "redirect:/";
	}

	//shows the create new book page
	@RequestMapping("/new")
	// the model attribute is because we have an empty constructor in our model Book.java
	public String create(@ModelAttribute("book") Book book) {
		return "new.jsp";
	}
	
	//"SHOW" Assignment
//	@RequestMapping("/books/{id}")
//	public String getOneBook(Model viewModel, @PathVariable ("id") Long id) {
//		Book newBook = bService.getOneBook(id);
//		viewModel.addAttribute("book", newBook);
//		return "show.jsp";
//	}
}	
