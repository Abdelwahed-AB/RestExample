package com.example.restexample.services;

import com.example.restexample.entities.Author;

import java.util.List;

public interface IAuthorService {

    List<Author> getAllAuthors();
    Author getAuthorById(Long id);
    void createAuthor(Author author);
    void updateAuthor(Long id, Author updatedAuthor);
    void deleteAuthorById(Long id);
}
