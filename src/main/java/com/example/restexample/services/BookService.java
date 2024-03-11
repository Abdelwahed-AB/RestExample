package com.example.restexample.services;

import com.example.restexample.entities.Book;
import com.example.restexample.exceptions.BookNotFoundException;
import com.example.restexample.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookService implements IBookService{
    private final BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks(Long id) {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isEmpty()){
            throw new BookNotFoundException(id);
        }

        return book.get();
    }

    @Override
    public void createBook(Book book) {

    }

    @Override
    public void updateBook(Long id, Book updatedBook) {

    }

    @Override
    public void deleteBookById(Long id) {

    }
}