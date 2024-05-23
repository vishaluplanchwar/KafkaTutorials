package com.vishaluplanch.kafka.stream.processor;

import com.vishaluplanch.kafka.avro.schema.AccountDetail;
import com.vishaluplanch.kafka.avro.schema.MergedAccountDetail;
import com.vishaluplanch.kafka.joiner.AccountValueJoiner;
import com.vishaluplanch.kafka.util.BankUtils;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import jakarta.annotation.PostConstruct;
import org.apache.avro.specific.SpecificRecord;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;

@Service
public class CustomerAccountStreamProcessor {

    @Value("${spring.kafka.abc.bank.topic}")
    private String abcBankAccountTopic;

    @Value("${spring.kafka.xyz.bank.topic}")
    private String xyzBankAccountTopic;

    @Autowired
    private StreamsBuilder streamBuilder;

    @Autowired
    private KafkaProperties kafkaProperties;


    @PostConstruct
    public void joinCustomerAccounts() {
        KStream<Long, AccountDetail> xyzKStream = streamBuilder.stream(xyzBankAccountTopic, Consumed.with(Serdes.Long(), this.getSpecificAvroSerde(new SpecificAvroSerde<>())));
        KStream<Long, AccountDetail> abcKStream = streamBuilder.stream(abcBankAccountTopic, Consumed.with(Serdes.Long(), this.getSpecificAvroSerde(new SpecificAvroSerde<>())));

        KStream<Long, MergedAccountDetail> joinedStream = xyzKStream.outerJoin(abcKStream, new AccountValueJoiner(), JoinWindows.of(Duration.ofSeconds(10)), StreamJoined.with(Serdes.Long(), this.getSpecificAvroSerde(new SpecificAvroSerde<>()), this.getSpecificAvroSerde(new SpecificAvroSerde<>())));
        joinedStream.peek((key, mergedAccountDetail) -> System.out.println("Key =>" + key + " Value in Join =>" + mergedAccountDetail.toString()));

        Topology topology=streamBuilder.build();
        KafkaStreams streams=new KafkaStreams(topology,new StreamsConfig(kafkaProperties.buildStreamsProperties()));
        streams.start();
    }



    <T extends SpecificRecord> SpecificAvroSerde<T> getSpecificAvroSerde(SpecificAvroSerde<T> serde) {
        HashMap<String, String> map = new HashMap<>();
        map.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, kafkaProperties.getProperties().get("schema.registry.url"));
        map.put(AbstractKafkaAvroSerDeConfig.BASIC_AUTH_CREDENTIALS_SOURCE, "USER_INFO");
        map.put(AbstractKafkaAvroSerDeConfig.USER_INFO_CONFIG, kafkaProperties.getProperties().get("basic.auth.user.info"));
        serde.configure(map, false);
        return serde;
    }
}
