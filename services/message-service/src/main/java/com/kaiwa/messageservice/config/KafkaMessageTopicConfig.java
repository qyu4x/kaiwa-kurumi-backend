package com.kaiwa.messageservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaMessageTopicConfig {

    @Bean
    public NewTopic messageTopic() {
        return TopicBuilder
                .name("message-topic")
                .build();
    }
}
