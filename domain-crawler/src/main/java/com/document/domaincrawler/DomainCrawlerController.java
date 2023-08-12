package com.document.domaincrawler;

import com.document.domaincrawler.schema.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
@RequiredArgsConstructor
public class DomainCrawlerController {
    private final DomainCrawlerService domainCrawlerService;

    @RequestMapping(method = RequestMethod.POST)
    public String create(@RequestBody PersonDto person) {
        domainCrawlerService.crawl(person);
        return "Domain crawler has scrapped your data";
    }
}