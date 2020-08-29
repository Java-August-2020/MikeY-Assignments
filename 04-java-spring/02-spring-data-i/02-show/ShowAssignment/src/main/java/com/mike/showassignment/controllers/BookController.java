package com.mike.showassignment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mike.showassignment.models.Book;
import com.mike.showassignment.services.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bService;
	
	//"SHOW" Assignment
	@RequestMapping("/books/{id}")
	public String getOneBook(Model viewModel, @PathVariable ("id") Long id) {
		Book newBook = bService.getOneBook(id);
		viewModel.addAttribute("book", newBook);
		return "show.jsp";
	}
}	
