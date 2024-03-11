package com.example.restexample.services;

import com.example.restexample.entities.Author;
import com.example.restexample.entities.Book;
import com.example.restexample.exceptions.BookAuthorRequiredException;
import com.example.restexample.exceptions.BookNotFoundException;
import com.example.restexample.repositories.AuthorRepository;
import com.example.restexample.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookService implements IBookService{
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Override
    public Page<Book> getAllBooks(int page, int size) {
        Pageable bookPageable = PageRequest.of(page, size);
        return bookRepository.findAll(bookPageable);
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
        if(book.getAuthor() == null){
            throw new BookAuthorRequiredException();
        }
        bookRepository.save(book);
    }

    @Override
    public void updateBook(Long id, Book updatedBook) {
        updatedBook.setId(id);
        if(updatedBook.getAuthor() == null){
            throw new BookAuthorRequiredException();
        }
        bookRepository.save(updatedBook);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
