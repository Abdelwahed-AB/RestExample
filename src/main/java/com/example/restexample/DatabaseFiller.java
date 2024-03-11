package com.example.restexample;

import com.example.restexample.entities.Author;
import com.example.restexample.entities.Book;
import com.example.restexample.services.IAuthorService;
import com.example.restexample.services.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
@Configuration
public class DatabaseFiller {
    private final IAuthorService authorService;
    private final IBookService bookService;

    @Bean
    public CommandLineRunner fill(){
        return args -> {
            List<Author> authors = new ArrayList<>();
            for(String name : new String[]{"Moha", "Abd", "Nrd", "Danger", "Mourad"}){
                Author author = new Author();
                author.setFirstName(name);
                author.setLastName(name);

                authorService.createAuthor(author);
                authors.add(author);
            }

            for (int i = 0; i < 10; i++){
                Book book = new Book();
                book.setAuthor(
                        authors.get(
                                ThreadLocalRandom.current().nextInt(authors.size())
                        )
                );

                book.setTitle("Title " + i);
                book.setDescription("Description "+i);

                bookService.createBook(book);
            }
        };
    }
}
