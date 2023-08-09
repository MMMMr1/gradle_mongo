package com.example.mongo;

import com.example.mongo.core.dto.PersonDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@EnableEurekaClient
@SpringBootApplication
public class MongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoApplication.class, args);
	}
//	@Bean
//	CommandLineRunner commandLineRunner(KafkaTemplate<String, PersonDto> kafkaTemplate){
//		return args -> {
//			kafkaTemplate.send("user-service", new PersonDto("100", "Petrov"));
//		};
//	}

}
