package com.example.restexample.services;

import com.example.restexample.entities.Book;
import org.springframework.data.domain.Page;

public interface IBookService {

    Page<Book> getAllBooks(int page, int size);
    Book getBookById(Long id);
    void createBook(Book book);
    void updateBook(Long id, Book updatedBook);
    void deleteBookById(Long id);
}
