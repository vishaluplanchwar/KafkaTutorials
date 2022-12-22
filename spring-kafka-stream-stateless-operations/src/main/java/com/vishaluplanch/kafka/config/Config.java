package com.vishaluplanch.kafka.config;

import com.vishaluplanch.kafka.schemas.MatchSummary;
import com.vishaluplanch.kafka.topics.Topic;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.common.serialization.Serdes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Value("${schema.registry.url}")
    private String schemaRegistryUrl;

    @Value("${input.topic.name}")
    private String topicName;

    @Bean
    public Topic<Long, MatchSummary> matchSummaryTopic() {
        return new Topic<>(topicName, Serdes.Long(), new SpecificAvroSerde<>(), schemaRegistryUrl);
    }


}
