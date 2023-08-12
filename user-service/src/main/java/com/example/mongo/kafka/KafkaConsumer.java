package com.example.mongo.kafka;

import com.example.mongo.core.dto.PersonDto;
import com.example.mongo.service.api.PersonService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {
    private final PersonService service;

    @KafkaListener(topics = "person")
    public void processMessage(PersonDto content) {
        this.service.create(content);
    }
//    public Consumer<KStream<String, PersonDto>> domainService() {
//        return kstream -> kstream.foreach(((key, person) -> {
//            service.create(person);
//        }));
//    }
}
