package com.vishaluplanch.org.config;

import com.vishaluplanch.org.schemas.CollateralEnrichedDetail;
import com.vishaluplanch.org.schemas.EmploymentEnrichedDetail;
import com.vishaluplanch.org.schemas.LoanDetail;
import com.vishaluplanch.org.topics.Topic;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.common.serialization.Serdes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

@Configuration
public class KafkaConfig {

    @Value("${schema.registry.url}")
    private String schemaRegistryUrl;

    @Value("${topic.source.name}")
    private String sourceTopic;

    @Value("${topic.sink.collateral.name}")
    private String collateralSinkTopic;

    @Value("${topic.sink.employment.name}")
    private String employmentSinkTopic;

    @Bean
    public Topic<Long, LoanDetail> loanDetailTopic() {
        return new Topic<>(sourceTopic, Serdes.Long(), new SpecificAvroSerde<>(), schemaRegistryUrl);
    }

    @Bean
    public Topic<Long, CollateralEnrichedDetail> collateralEnrichedDetailTopic() {
        return new Topic<>(collateralSinkTopic, Serdes.Long(), new SpecificAvroSerde<>(), schemaRegistryUrl);
    }

    @Bean
    public Topic<Long, EmploymentEnrichedDetail> employmentEnrichedDetailTopic() {
        return new Topic<>(employmentSinkTopic, Serdes.Long(), new SpecificAvroSerde<>(), schemaRegistryUrl);
    }

    @Bean
    public ConsumerFactory<String, CollateralEnrichedDetail> consumerFactory(KafkaProperties kafkaProperties) {
        return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties());
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, CollateralEnrichedDetail>> kafkaListenerContainerFactory(KafkaProperties kafkaProperties) {
        ConcurrentKafkaListenerContainerFactory<String, CollateralEnrichedDetail> factory = new ConcurrentKafkaListenerContainerFactory<String, CollateralEnrichedDetail>();
        factory.setConsumerFactory(consumerFactory(kafkaProperties));
        return factory;
    }

}
