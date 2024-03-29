package com.example.restexample.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Book not found")
public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(Long id) {
        super("Book with id: "+id+" not found.");
    }
}
