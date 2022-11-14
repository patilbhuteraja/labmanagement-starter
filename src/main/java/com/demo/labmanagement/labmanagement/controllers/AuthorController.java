package com.demo.labmanagement.labmanagement.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.labmanagement.labmanagement.models.Author;
import com.demo.labmanagement.labmanagement.repositories.AuthorRepository;

@RestController
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping("/author")
    @ResponseStatus(HttpStatus.CREATED)
    public Author createAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    @GetMapping("/author")
    public Iterable<Author> GetAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/author/{id}")
    public Optional<Author> GetAuthors(@PathVariable("id") Long id) {
        return authorRepository.findById(id);
    }

    @DeleteMapping("/author/{id}")
    public void deleteAuthor(@PathVariable("id") Long id) {
        authorRepository.deleteById(id);
    }

    @PutMapping("/author/{id}")
    public Author updateAuthor(@RequestBody Author author, @PathVariable("id") Long id) {
        if (!author.getId().equals(id)) {
            throw new IllegalArgumentException("Author Id mismatch!");
        }
        return authorRepository.save(author);
    }
}
