package com.example.restexample.controllers;

import com.example.restexample.entities.Author;
import com.example.restexample.entities.Book;
import com.example.restexample.services.IAuthorService;
import com.example.restexample.services.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api-url}/books")
public class BookController {
    private final IAuthorService authorService;
    private final IBookService bookService;

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{bookid}")
    public Book getBook(@PathVariable("bookid") Long id){
        return bookService.getBookById(id);
    }

    @PostMapping
    public void createBook(@RequestBody Book book){
        bookService.createBook(book);
    }

    @PutMapping("/{bookid}")
    public void updateBook(@PathVariable("bookid") Long id, @RequestBody Book book){
        bookService.updateBook(id, book);
    }

    @DeleteMapping("/{bookid}")
    public void deleteBook(@PathVariable("bookid") Long id){
        bookService.deleteBookById(id);
    }
}
