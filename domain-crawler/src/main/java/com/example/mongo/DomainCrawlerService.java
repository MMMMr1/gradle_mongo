package com.example.mongo;

import com.example.mongo.core.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class DomainCrawlerService {
    private final KafkaTemplate<String, PersonDto> kafkaTemplateCreate;
    private final KafkaTemplate<String, String> kafkaTemplateGetPerson;
    private final String KAFKA_TOPIC_CREATE = "person";
    private final String KAFKA_TOPIC_GET_PERSON = "person_get_id";
    private final String KAFKA_TOPIC_GET_PERSON_RESPONSE = "person_get_id_response";
    private final ConcurrentHashMap<String, CompletableFuture<PersonDto>> getPerson = new ConcurrentHashMap<>();

    public void create(PersonDto person) {
        kafkaTemplateCreate.send(KAFKA_TOPIC_CREATE, String.valueOf(
                new Date().getTime()), person);
    }
    @SneakyThrows
    public PersonDto getById(String id) {
        String messageId = String.valueOf(new Date().getTime());
        kafkaTemplateGetPerson.send(KAFKA_TOPIC_GET_PERSON, id);
        CompletableFuture<PersonDto> completableFuture = new CompletableFuture<>();
        getPerson.put(id, completableFuture);
        PersonDto personDto = completableFuture.get(100, TimeUnit.SECONDS);
        return personDto;
    }
    @KafkaListener(topics = KAFKA_TOPIC_GET_PERSON_RESPONSE)
    public void listenForResponse(PersonDto personDto) {
        CompletableFuture<PersonDto> completableFuture = getPerson.get(personDto.getId());
        if (completableFuture != null) {
            completableFuture.complete(personDto);
        }
    }
}


//        final PersonDto[] personDto = new PersonDto[1];
//        Thread.sleep(100);
//        Consumer<String, PersonDto> consumer = consumerFactory.createConsumer();
//        consumer.subscribe(Arrays.asList(KAFKA_TOPIC_GET_PERSON_RESPONSE));
//        consumer.poll(Duration.ofSeconds(10))
//                .records(KAFKA_TOPIC_GET_PERSON_RESPONSE).forEach(
//                        s -> {
//                            if(s.value().getId().equals(id)) {
//                                personDto[0] = s.value();
//                            }
//                        }
//             );

//        pendingRequests.remove(messageId);




//        Consumer<String, PersonDto> consumer = consumerFactory.createConsumer();
//        consumer.subscribe(Arrays.asList(KAFKA_TOPIC_GET_PERSON_RESPONSE));
//        ConsumerRecords<String, PersonDto> poll = consumer.poll(Duration.ofSeconds(10));
//        poll.records(KAFKA_TOPIC_GET_PERSON_RESPONSE)
//                .forEach(stringPersonDtoConsumerRecord -> {
//                    if(stringPersonDtoConsumerRecord.key().equals(id)) {
//                        name = stringPersonDtoConsumerRecord.value().getName();
//                    }
//                });
//        for (ConsumerRecord<String, PersonDto> s : consumer.poll(Duration.ofSeconds(10))
//                .records(KAFKA_TOPIC_GET_PERSON_RESPONSE)) {
////            if (s.key().equals(id)) {
////                 value = s.value();
//
//                 name = s.value().getName();
////                break;
//            }
//                .thenGetItem(consumerRecord _> {
//                    return PersonDto;
//                }))
//                .
//                .whenComplete((result, ex) -> {
//                    if (ex == null) {
//                        log.info("Message sent to topic: {}", id);
//                    }else {
//                        log.error("Faild to send message ");
//                    }
//                });

//    PersonDto getPersonDtoFromString(String personString){
//        PersonDto personDto = null;
//        try {
//            personDto = objectMapper.readValue(personString,PersonDto.class);
//        }  catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }return personDto;
//    }
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