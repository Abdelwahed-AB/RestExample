package com.example.restexample.controllers;

import com.example.restexample.entities.Author;
import com.example.restexample.services.IAuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PropertySource("classpath:api.properties")
@RequestMapping("${api-url}/author")
@RequiredArgsConstructor
public class AuthorController {

    private final IAuthorService authorService;

    @GetMapping
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/{authorid}")
    public Author getAuthorById(@PathVariable("authorid") Long id){
        return authorService.getAuthorById(id);
    }

    @PostMapping
    public void createAuthor(@RequestBody Author author){
        authorService.createAuthor(author);
    }

    @PutMapping("/{authorid}")
    public void updateAuthor(@PathVariable("authorid") Long id, @RequestBody Author author){
        authorService.updateAuthor(id, author);
    }

    @DeleteMapping("/{authorid}")
    public void deleteAuthor(@PathVariable("authorid") Long id){
        authorService.deleteAuthorById(id);
    }
}
