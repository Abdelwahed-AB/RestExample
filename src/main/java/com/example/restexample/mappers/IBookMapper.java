package com.example.restexample.mappers;

import com.example.restexample.dto.BookDto;
import com.example.restexample.entities.Book;

public interface IBookMapper {
    Book bookDtoToBook(BookDto bookDto);
    BookDto bookToBookDto(Book book);
}
