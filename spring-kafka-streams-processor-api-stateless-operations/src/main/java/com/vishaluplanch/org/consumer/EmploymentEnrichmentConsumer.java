package com.vishaluplanch.org.consumer;

import com.vishaluplanch.org.schemas.EmploymentEnrichedDetail;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmploymentEnrichmentConsumer {

    @KafkaListener(topics = "${topic.sink.employment.name}", containerFactory = "kafkaListenerContainerFactory")
    public void read(ConsumerRecord<Long, EmploymentEnrichedDetail> record) {
        Long key = record.key();
        System.out.println("Employment enriched avro message received for key : " + key + " value : " + record.value().toString());
    }
}
