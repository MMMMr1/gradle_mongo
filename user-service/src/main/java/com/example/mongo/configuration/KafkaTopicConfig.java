//package com.example.mongo.configuration;
//
//import org.apache.kafka.clients.admin.AdminClientConfig;
//import org.apache.kafka.clients.admin.KafkaAdminClient;
//import org.apache.kafka.clients.admin.NewTopic;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.config.TopicBuilder;
//import org.springframework.kafka.core.KafkaAdmin;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class KafkaTopicConfig {
////    @Value(value = "${spring.kafka.bootstrap-servers}")
////    private String bootstrapAddress;
////    @Value("${kafka.topic.name}")
////    private String userServiceTopicName;
////    @Bean
////    public KafkaAdmin kafkaAdmin() {
////        Map<String, Object> configs = new HashMap<>();
////        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
////        return new KafkaAdmin(configs);
////    }
////public static final String USER_TOPIC = "user_topic";
////    @Bean
////    public NewTopic userServiceTopic() {
////        return new NewTopic(USER_TOPIC, 1, (short) 1);
////    }
//    @Bean
//    public NewTopic userServiceTopic(){
//        return TopicBuilder.name("user-service")
//                .build();
//    }
//////    @Value(value = "${spring.kafka.bootstrap-servers}")
//////    private String bootstrapAddress;
//////
//////    @Bean
//////    public KafkaAdmin kafkaAdmin() {
//////        Map<String, Object> configs = new HashMap<>();
//////        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
//////        return new KafkaAdmin (configs);
//////    }
//
//}
