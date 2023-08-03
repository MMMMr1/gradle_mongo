package com.example.mongo.service.api;

import com.example.mongo.core.dto.PersonDto;

import java.util.Optional;

public interface PersonService {
    Optional<PersonDto> findById(String id);
    PersonDto create (PersonDto person);
}
