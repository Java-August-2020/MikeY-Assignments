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
	
	//create book overloaded from the front end
	public Book createBook(String title, String description, String language, int pages) {
		//instantiate, but make sure we have the overloaded method in the model (Book.java) first
		Book newBook = new Book(title, description, language, pages);
				return this.bRepo.save(newBook);
	}
	
	//update - Assignment for update delete
	public Book updateBook(Long id, Book updatedBook) {
		return this.bRepo.save(updatedBook);
	}
	
	//delete - Assignment for update delete
	public void deleteBook(Long id) {
		this.bRepo.deleteById(id);
	}
	
}
