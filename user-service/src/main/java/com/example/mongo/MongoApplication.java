package com.example.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
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
