package com.vishaluplanch.kafka.utils;

import com.vishaluplanch.kafka.avro.schema.StockOrders;
import com.vishaluplanch.kafka.avro.schema.StockPriceSumAndCount;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.avro.specific.SpecificRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class SerdeConfigUtil {

    @Autowired
    private KafkaProperties kafkaProperties;

    public <T extends SpecificRecord> SpecificAvroSerde<T> register(SpecificAvroSerde<T> serde) {
        HashMap<String, String> map = new HashMap<>();
        map.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, kafkaProperties.getProperties().get("schema.registry.url"));
        map.put(AbstractKafkaAvroSerDeConfig.BASIC_AUTH_CREDENTIALS_SOURCE, "USER_INFO");
        map.put(AbstractKafkaAvroSerDeConfig.USER_INFO_CONFIG, kafkaProperties.getProperties().get("basic.auth.user.info"));
        serde.configure(map, false);
        return serde;
    }

    public SpecificAvroSerde<StockOrders> registerStockOrders() {
        SpecificAvroSerde<StockOrders> serde = new SpecificAvroSerde<>();
        HashMap<String, String> map = new HashMap<>();
        map.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, kafkaProperties.getProperties().get("schema.registry.url"));
        map.put(AbstractKafkaAvroSerDeConfig.BASIC_AUTH_CREDENTIALS_SOURCE, "USER_INFO");
        map.put(AbstractKafkaAvroSerDeConfig.USER_INFO_CONFIG, kafkaProperties.getProperties().get("basic.auth.user.info"));
        serde.configure(map, false);
        return serde;
    }

    public SpecificAvroSerde<StockPriceSumAndCount> registerStockPriceSumAndCount() {
        SpecificAvroSerde<StockPriceSumAndCount> serde = new SpecificAvroSerde<>();
        HashMap<String, String> map = new HashMap<>();
        map.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, kafkaProperties.getProperties().get("schema.registry.url"));
        map.put(AbstractKafkaAvroSerDeConfig.BASIC_AUTH_CREDENTIALS_SOURCE, "USER_INFO");
        map.put(AbstractKafkaAvroSerDeConfig.USER_INFO_CONFIG, kafkaProperties.getProperties().get("basic.auth.user.info"));
        serde.configure(map, false);
        return serde;
    }
}
