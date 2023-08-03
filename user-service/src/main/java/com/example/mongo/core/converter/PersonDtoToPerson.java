package com.example.mongo.core.converter;


import com.example.mongo.core.dto.PersonDto;
import com.example.mongo.documents.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonDtoToPerson implements Converter<PersonDto, Person> {
    @Override
    public Person convert(PersonDto person) {
        return new Person(person.getId(), person.getName());
    }
}
