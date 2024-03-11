package com.example.restexample;

import com.example.restexample.entities.Author;
import com.example.restexample.services.IAuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class DatabaseFiller {
    private final IAuthorService authorService;

    @Bean
    public CommandLineRunner fill(){
        return args -> {
            Author author = new Author();
            author.setFirstName("Moha");
            author.setLastName("Moussa");

            authorService.createAuthor(author);
        };
    }
}
