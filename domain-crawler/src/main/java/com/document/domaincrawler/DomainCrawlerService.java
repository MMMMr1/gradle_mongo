package com.document.domaincrawler;

import com.document.domaincrawler.schema.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class DomainCrawlerService {
    private final KafkaTemplate<String, PersonDto> kafkaTemplate;
    private final String KAFKA_TOPIC = "person";


    public void crawl(PersonDto person) {
        kafkaTemplate.send(KAFKA_TOPIC, String.valueOf(new Date().getTime()), person);
    }
//        Mono<PersonDtoList> domainListMono = WebClient.create()
//                .post()
//                .uri("/api/v1/persons")
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue(person)
//                .retrieve()
//                .bodyToMono(PersonDtoList.class);
//
//
//        domainListMono.subscribe(domainList -> {
//            domainList.persons
//                    .forEach(personDto -> {
//                        kafkaTemplate.send(KAFKA_TOPIC, String.valueOf(new Date().getTime()), personDto);
//                    });
//        });
//
//    }

}
