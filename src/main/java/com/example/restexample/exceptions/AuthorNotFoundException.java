package com.example.restexample.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Author not found")
public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(Long id) {
        super("Author with id: "+id+" not found.");
    }
}
