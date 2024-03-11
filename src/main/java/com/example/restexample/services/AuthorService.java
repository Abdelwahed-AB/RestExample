package com.example.restexample.services;

import com.example.restexample.entities.Author;
import com.example.restexample.exceptions.AuthorNotFoundException;
import com.example.restexample.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthorService implements IAuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        if(author.isEmpty()){
            throw new AuthorNotFoundException(id);
        }

        return author.get();
    }

    @Override
    public void createAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void updateAuthor(Long id, Author updatedAuthor) {
        getAuthorById(id); // check if exists
        updatedAuthor.setId(id);
        authorRepository.save(updatedAuthor);
    }

    @Override
    public void deleteAuthorById(Long id) {
        authorRepository.deleteById(id);
    }
}
