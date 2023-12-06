package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Book;
import com.demo.excep.BookNotFoundException;
import com.demo.repo.BookRepository;


@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
    private BookRepository repo;

	  @GetMapping("/{id}")
	    public Book getBookById(@PathVariable int id) {
	        return repo.findById(id).orElse(null);
	    }

	    @PostMapping
	    public ResponseEntity<?> createBook(@RequestBody Book book) {
	        Book createdBook = repo.save(book);
	        return ResponseEntity.status(201).body("Book created successfully with ID: " + createdBook.getId());
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<?> updateBook(@PathVariable int id, @RequestBody Book updateBook) {
	        Optional<Book> optionalExistingBook = repo.findById(id);

	        if (optionalExistingBook.isPresent()) {
	            updateBook.setId(id);
	            Book updatedBook = repo.save(updateBook);
	            return ResponseEntity.ok("Book updated successfully. ID: " + updatedBook.getId());
	        } else {
	            return ResponseEntity.status(404).body("Book not found with ID: " + id);
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<?> deleteBook(@PathVariable int id) {
	        Optional<Book> optionalBook = repo.findById(id);

	        if (optionalBook.isPresent()) {
	            repo.deleteById(id);
	            return ResponseEntity.ok("Book deleted successfully. ID: " + id);
	        } else {
	            return ResponseEntity.status(404).body("Book not found with ID: " + id);
	        }
	    }
}
