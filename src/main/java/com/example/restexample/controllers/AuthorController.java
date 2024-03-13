package com.example.restexample.controllers;

import com.example.restexample.dto.AuthorDto;
import com.example.restexample.entities.Author;
import com.example.restexample.mappers.IAuthorMapper;
import com.example.restexample.services.IAuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PropertySource("classpath:api.properties")
@RequestMapping("${api-url}/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final IAuthorService authorService;
    private final IAuthorMapper authorMapper;


    @GetMapping
    public Page<AuthorDto> getAllAuthors(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int pageSize
    ) {
        return authorService.getAllAuthors(page, pageSize)
                .map(authorMapper::authorToAuthorDto);
    }

    @GetMapping("/{authorid}")
    public AuthorDto getAuthorById(@PathVariable("authorid") Long id) {
        return authorMapper.authorToAuthorDto(authorService.getAuthorById(id));
    }

    @PostMapping
    public void createAuthor(@RequestBody @Valid AuthorDto author) {
        Author tmp = authorMapper.authorDtoToAuthor(author);
        tmp.setId(0L);
        authorService.createAuthor(tmp);
    }

    @PutMapping("/{authorid}")
    public void updateAuthor(@PathVariable("authorid") Long id, @RequestBody @Valid AuthorDto author) {
        Author tmp = authorMapper.authorDtoToAuthor(author);
        authorService.updateAuthor(id, tmp);
    }

    @DeleteMapping("/{authorid}")
    public void deleteAuthor(@PathVariable("authorid") Long id) {
        authorService.deleteAuthorById(id);
    }
}
