package com.mike.showassignment.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mike.showassignment.models.Book;
import com.mike.showassignment.services.BookService;

@RestController
@RequestMapping("/api")
public class BookApiController {
	private final BookService bService;
	public BookApiController(BookService service) {
		this.bService = service;
	}
		 
	//Routes
	
	@RequestMapping("/")
	public List<Book> index(){
		return this.bService.getAllBooks();
	}
	
	//get one
	@RequestMapping("{id}") 
	public Book getBook(@PathVariable("id") Long id) {
		return this.bService.getOneBook(id);
	}
	
	
	//create
	@RequestMapping(value="/", method=RequestMethod.POST)
	public Book create(Book newBook) {
		return this.bService.createBook(newBook);
	}
	
	//update
	@RequestMapping(value="/book/update/{id}", method=RequestMethod.PUT)
	public Book edit(@PathVariable("id") Long id, Book updatedBook) {
		return this.bService.updateBook(id, updatedBook);
	}
	
	//delete
	@RequestMapping("book/delete/{id")
	public String removeBook(@PathVariable("id") Long id) {
		this.bService.deleteBook(id);
		return id + "has been removed from the db";
	}
}
