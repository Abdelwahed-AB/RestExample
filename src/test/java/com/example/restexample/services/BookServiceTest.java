package com.example.restexample.services;

import com.example.restexample.entities.Book;
import com.example.restexample.exceptions.BookNotFoundException;
import com.example.restexample.repositories.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void should_throw_when_book_doesnt_exist(){
        Mockito.when(bookRepository.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThrows(BookNotFoundException.class, ()-> bookService.getBookById(1L));
    }

    @Test
    public void should_return_book(){
        Book book = new Book();
        book.setId(2L);
        book.setDescription("test");
        book.setTitle("test");
        book.setPublishDate(LocalDate.now());
        Mockito.when(bookRepository.findById(2L)).thenReturn(Optional.of(book));

        Book expected = new Book();
        expected.setId(2L);
        expected.setDescription("test");
        expected.setTitle("test");
        expected.setPublishDate(LocalDate.now());

        Assertions.assertEquals(expected, bookService.getBookById(2L));
    }

    @Test
    public void should_return_list_of_books(){
        List<Book> books = new ArrayList<>();
        int page = 0;
        int size = 10;
        Pageable pageable = PageRequest.of(page, size);
        for(int i = 0; i < 10; i++){
            Book book = new Book();
            book.setId(2L);
            book.setDescription("test"+i);
            book.setTitle("test"+i);
            book.setPublishDate(LocalDate.now());
            books.add(book);
        }

        Page<Book> bookPage = new PageImpl<>(books, pageable, size);

        Mockito.when(bookRepository.findAll(pageable)).thenReturn(bookPage);

        Assertions.assertEquals(bookPage, bookService.getAllBooks(page, size));
    }

}
