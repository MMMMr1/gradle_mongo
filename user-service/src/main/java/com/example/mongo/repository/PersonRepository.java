package com.example.mongo.repository;

import com.example.mongo.documents.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository  extends MongoRepository<Person, String> {
}
