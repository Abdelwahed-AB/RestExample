package com.example.restexample.services;

import com.example.restexample.entities.Book;

import java.util.List;

public interface IBookService {

    List<Book> getAllBooks(Long id);
    Book getBookById(Long id);
    void createBook(Book book);
    void updateBook(Long id, Book updatedBook);
    void deleteBookById(Long id);
}
