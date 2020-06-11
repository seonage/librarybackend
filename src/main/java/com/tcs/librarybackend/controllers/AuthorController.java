package com.tcs.librarybackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tcs.librarybackend.repos.AuthorRepo;
import com.tcs.librarybackend.models.Author;
import com.tcs.librarybackend.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/authors")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthorController {
    @Autowired
    private AuthorRepo authorRepo;

    @GetMapping
    public List<Author> getAuthors() {
        return authorRepo.findAll();
    }

    @GetMapping(value="/{id}")
    public Author getOneAuthor(@PathVariable String id){
        return authorRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException());
    }

    @PostMapping
    public void addAuthor(@RequestBody Author author) {
        authorRepo.save(author);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void deleteAuthor(@PathVariable String id) {
        Author author = authorRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        authorRepo.delete(author);
    }

}