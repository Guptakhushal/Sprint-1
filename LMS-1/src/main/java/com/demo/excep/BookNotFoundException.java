package com.demo.excep;

import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookNotFoundException(int bookId) {
        super("Book not found with ID: " + bookId);
    }
}
