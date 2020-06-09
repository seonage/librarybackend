package com.tcs.librarybackend.repos;

import com.tcs.librarybackend.models.Author;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepo extends MongoRepository<Author, String> {

}