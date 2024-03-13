package com.example.restexample.mappers;

import com.example.restexample.dto.BookDto;
import com.example.restexample.entities.Author;
import com.example.restexample.entities.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper implements IBookMapper{
    @Override
    public Book bookDtoToBook(BookDto bookDto) {
        Book book = new Book();
        Author author = new Author();

        author.setId(bookDto.authorId());

        book.setTitle(bookDto.title());
        book.setAuthor(author);
        book.setId(bookDto.id());
        book.setDescription(bookDto.description());
        book.setPublishDate(bookDto.publishDate());
        return book;
    }

    @Override
    public BookDto bookToBookDto(Book book) {
        BookDto bookDto = new BookDto(
                book.getId(),
                book.getTitle(),
                book.getDescription(),
                book.getPublishDate(),
                book.getAuthor().getId()
        );
        return bookDto;
    }
}
