package com.example.restexample.mappers;

import com.example.restexample.dto.AuthorDto;
import com.example.restexample.entities.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper implements IAuthorMapper {
    @Override
    public Author authorDtoToAuthor(AuthorDto authorDto) {
        Author author = new Author();
        author.setId(authorDto.id());
        author.setFirstName(authorDto.firstName());
        author.setLastName(authorDto.lastName());
        return author;
    }

    @Override
    public AuthorDto authorToAuthorDto(Author author) {
        AuthorDto authorDto = new AuthorDto(
                author.getId(),
                author.getFirstName(),
                author.getLastName()
        );
        return authorDto;
    }
}
