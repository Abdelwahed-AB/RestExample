package com.example.restexample.services;

import com.example.restexample.entities.Author;
import org.springframework.data.domain.Page;


public interface IAuthorService {

    Page<Author> getAllAuthors(int page, int size);
    Author getAuthorById(Long id);
    void createAuthor(Author author);
    void updateAuthor(Long id, Author updatedAuthor);
    void deleteAuthorById(Long id);
}
