package com.tcs.librarybackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tcs.librarybackend.repos.AuthorRepo;
import com.tcs.librarybackend.models.Author;

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

    @PostMapping
    public void addAuthor(@RequestBody Author author) {
        authorRepo.save(author);
    }

}