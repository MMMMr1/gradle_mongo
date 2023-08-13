package com.example.mongo;

import com.example.mongo.core.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
@RequiredArgsConstructor
public class DomainCrawlerController {

    private final DomainCrawlerService domainCrawlerService;

    @RequestMapping(method = RequestMethod.POST)
    public String create(@RequestBody PersonDto person) {
        domainCrawlerService.create(person);
        return "Domain crawler has scrapped your data";
    }
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public PersonDto get(@PathVariable("id") String id)  {
        return domainCrawlerService.getById(id);
    }
}