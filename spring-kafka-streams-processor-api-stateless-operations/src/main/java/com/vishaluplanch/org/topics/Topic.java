package com.vishaluplanch.org.topics;

import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.common.serialization.Serde;

import javax.annotation.PostConstruct;
import java.util.Collections;

public class Topic<K, V> {

    private String topicName;
    private Serde<K> keySerde;
    private Serde<V> valueSerde;
    private String schemaRegistryUrl;

    public Topic(String topicName, Serde<K> key, Serde<V> value, String schemaRegistryUrl) {
        this.topicName = topicName;
        this.keySerde = key;
        this.valueSerde = value;
        this.schemaRegistryUrl = schemaRegistryUrl;
    }

    @PostConstruct
    public void setup() {
        configure(this.keySerde);
        configure(this.valueSerde);
    }

    public String getTopicName() {
        return topicName;
    }

    public Serde<K> getKeySerde() {
        return keySerde;
    }

    public Serde<V> getValueSerde() {
        return valueSerde;
    }

    public String getSchemaRegistryUrl() {
        return schemaRegistryUrl;
    }

    public void configure(Serde serde) {
        if (serde instanceof SpecificAvroSerde)
            serde.configure(Collections.singletonMap(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, schemaRegistryUrl), false);
    }

}
