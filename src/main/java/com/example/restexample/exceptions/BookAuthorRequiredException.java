package com.example.restexample.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Book requires an author")
public class BookAuthorRequiredException extends RuntimeException{
}
