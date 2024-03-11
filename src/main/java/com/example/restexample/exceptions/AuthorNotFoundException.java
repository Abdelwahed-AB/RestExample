package com.example.restexample.exceptions;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(Long id) {
        super("Author with id: "+id+" not found.");
    }
}
