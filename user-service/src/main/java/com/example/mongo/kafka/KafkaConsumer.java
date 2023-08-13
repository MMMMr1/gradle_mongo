package com.example.mongo.kafka;

import com.example.mongo.core.dto.PersonDto;
import com.example.mongo.service.api.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {
    private final PersonService service;
    private final KafkaTemplate<String, PersonDto> kafkaTemplate;

    @KafkaListener(topics = "person")
    public void processMessage(PersonDto content) {
        this.service.create(content);
    }

    @KafkaListener(topics = "person_get_id")
    public void processMessageGetPerson(String content) {
        PersonDto person = service.findById(content).get();
        kafkaTemplate.send("person_get_id_response", person);
    }
}

//    public Consumer<KStream<String, PersonDto>> domainService() {
//        return kstream -> kstream.foreach(((key, person) -> {
//            service.create(person);
//        }));
//    }

