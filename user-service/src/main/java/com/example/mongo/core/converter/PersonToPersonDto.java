package com.example.mongo.core.converter;

import com.example.mongo.core.dto.PersonDto;
import com.example.mongo.documents.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonToPersonDto implements Converter<Person, PersonDto> {
    @Override
    public PersonDto convert(Person person) {
        return new PersonDto(person.getId(), person.getName());
    }
}
