package com.mike.showassignment.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mike.showassignment.models.Book;
import com.mike.showassignment.repositories.BookRepository;

@Service
public class BookService {
	private BookRepository bRepo;
	
	public BookService(BookRepository repo) {
		this.bRepo = repo;
	}
	
	//getAll
	public List<Book> getAllBooks() {
		return this.bRepo.findAll();
	}
	
	//getOne
	public Book getOneBook(Long id) {
		return bRepo.findById(id).orElse(null);
	}

	//createOne
	public Book createBook(Book newBook) {
		return this.bRepo.save(newBook);
	}
	
	//update
	public Book updateBook(Long id, Book updatedBook) {
		return this.bRepo.save(updatedBook);
	}
	
	//delete)
	public void deleteBook(Long id) {
		this.bRepo.deleteById(id);
	}
	
}
