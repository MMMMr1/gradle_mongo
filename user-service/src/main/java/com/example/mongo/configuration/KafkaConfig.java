//package com.example.mongo.configuration;
//
//import com.example.mongo.core.dto.PersonDto;
//import com.example.mongo.service.api.PersonService;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.kafka.clients.admin.AdminClientConfig;
//import org.apache.kafka.clients.admin.NewTopic;
//import org.apache.kafka.common.serialization.Serde;
//import org.apache.kafka.common.serialization.Serdes;
//import org.apache.kafka.streams.StreamsBuilder;
//import org.apache.kafka.streams.kstream.Consumed;
//import org.apache.kafka.streams.kstream.KStream;
//import org.apache.kafka.streams.kstream.Produced;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.annotation.EnableKafkaStreams;
//import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
//import org.springframework.kafka.config.KafkaStreamsConfiguration;
//import org.springframework.kafka.core.KafkaAdmin;
//import org.springframework.kafka.support.serializer.JsonDeserializer;
//import org.springframework.kafka.support.serializer.JsonSerializer;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static org.apache.kafka.streams.StreamsConfig.*;
//
//@Configuration
//@EnableKafka
//@EnableKafkaStreams
//public class KafkaConfig {
//
//    @Value("${spring.kafka.bootstrap-servers}")
//    private String bootstrapAddress;
//    private PersonService personService;
//    @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
//    KafkaStreamsConfiguration kafkaStreamsConfiguration(){
//            Map<String, Object> props = new HashMap<>();
//            props.put(APPLICATION_ID_CONFIG, "streams-app");
//            props.put(BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
//            props.put(DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
//            props.put(DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
//
//            return new KafkaStreamsConfiguration(props);
//        }
//        @Bean
//    public Serde<PersonDto> userSerde(){
//        return Serdes.serdeFrom(new JsonSerializer<>(), new JsonDeserializer<>(PersonDto.class));
//        }
//        @Bean
//    public KStream<String, PersonDto> kStream (StreamsBuilder streamsBuilder){
//            KStream<String, String> messageStream = streamsBuilder
//                    .stream("person", Consumed.with(Serdes.String(), Serdes.String()));
//
//            KStream<String,PersonDto> personDtoStream = messageStream
//                    .mapValues(this::getPersonDtoFromString)
//                            .map(s -> personService.create(s.));
//
////                    .filter()
////                    .groupBy((key, word) -> word, Grouped.with(STRING_SERDE, STRING_SERDE))
////                    .count();
//
//            personDtoStream.to("output-topic", Produced.with(Serdes.String(),userSerde()));
//            return personDtoStream;
//        }
//        @Bean
//    public ObjectMapper objectMapper(){
//        return new ObjectMapper();
//        }
//        PersonDto getPersonDtoFromString(String personString){
//        PersonDto personDto = null;
//        try {
//            personDto = objectMapper().readValue(personString,PersonDto.class);
//        }  catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }return personDto;
//        }
//    }
