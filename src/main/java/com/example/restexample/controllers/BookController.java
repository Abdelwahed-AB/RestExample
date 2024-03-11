package com.example.restexample.controllers;

import com.example.restexample.dto.BookDto;
import com.example.restexample.entities.Book;
import com.example.restexample.mappers.IBookMapper;
import com.example.restexample.services.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api-url}/books")
public class BookController {
    private final IBookService bookService;
    private final IBookMapper bookMapper;

    @GetMapping
    public Page<BookDto> getAllBooks(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int pageSize
    ){
        return bookService.getAllBooks(page, pageSize).map(bookMapper::bookToBookDto);
    }

    @GetMapping("/{bookid}")
    public BookDto getBook(@PathVariable("bookid") Long id){
        return bookMapper.bookToBookDto(bookService.getBookById(id));
    }

    @PostMapping
    public void createBook(@RequestBody BookDto book){
        Book tmp = bookMapper.bookDtoToBook(book);
        bookService.createBook(tmp);
    }

    @PutMapping("/{bookid}")
    public void updateBook(@PathVariable("bookid") Long id, @RequestBody BookDto book){
        Book tmp = bookMapper.bookDtoToBook(book);
        bookService.updateBook(id, tmp);
    }

    @DeleteMapping("/{bookid}")
    public void deleteBook(@PathVariable("bookid") Long id){
        bookService.deleteBookById(id);
    }
}
