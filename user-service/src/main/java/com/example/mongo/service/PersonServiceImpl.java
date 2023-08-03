package com.example.mongo.service;

import com.example.mongo.core.dto.PersonDto;
import com.example.mongo.documents.Person;
import com.example.mongo.repository.PersonRepository;
import com.example.mongo.service.api.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;
    private final ConversionService conversionService;

    @Override
    public Optional<PersonDto> findById(String id) {
        return repository.findById(id)
                .map(s -> conversionService.convert(s, PersonDto.class));
    }

    @Override
    public PersonDto create(PersonDto personDto ) {
        Person person  = conversionService.convert(personDto, Person.class);
        Person save = repository.save(person);
        return conversionService.convert(save,PersonDto.class);
    }
}
