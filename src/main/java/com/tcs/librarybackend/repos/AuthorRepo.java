package com.tcs.librarybackend.repos;

import com.tcs.librarybackend.models.Author;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.mongodb.repository.MongoRepository;

@RepositoryRestResource(collectionResourceRel = "authors", path = "authors")
public interface AuthorRepo extends MongoRepository<Author, String> {

}