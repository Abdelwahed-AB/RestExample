package com.example.restexample.mappers;

import com.example.restexample.dto.AuthorDto;
import com.example.restexample.entities.Author;

public interface IAuthorMapper {
    Author authorDtoToAuthor(AuthorDto authorDto);
    AuthorDto authorToAuthorDto(Author author);
}
