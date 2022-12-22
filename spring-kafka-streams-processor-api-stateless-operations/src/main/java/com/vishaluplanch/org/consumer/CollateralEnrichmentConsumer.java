package com.vishaluplanch.org.consumer;

import com.vishaluplanch.org.schemas.CollateralEnrichedDetail;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CollateralEnrichmentConsumer {

    @KafkaListener(topics = "${topic.sink.collateral.name}", containerFactory = "kafkaListenerContainerFactory")
    public void read(ConsumerRecord<Long, CollateralEnrichedDetail> record) {
        Long key = record.key();
        System.out.println("Collateral enriched avro message received for key : " + key + " value : " + record.value().toString());
    }
}
