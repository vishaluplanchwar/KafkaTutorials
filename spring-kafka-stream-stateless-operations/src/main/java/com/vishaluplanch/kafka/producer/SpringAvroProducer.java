package com.vishaluplanch.kafka.producer;

import com.vishaluplanch.kafka.schemas.MatchSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class SpringAvroProducer {

    @Value("${input.topic.name}")
    String topicName;

    @Autowired
    private KafkaTemplate<Long, MatchSummary> kafkaTemplate;

    public void send(MatchSummary summary) {
        ListenableFuture<SendResult<Long, MatchSummary>> future = kafkaTemplate.send(topicName, summary.getMatchNum(), summary);
        future.addCallback(new ListenableFutureCallback<SendResult<Long, MatchSummary>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Message failed to produce");
            }

            @Override
            public void onSuccess(SendResult<Long, MatchSummary> result) {
                System.out.println("Avro message successfully produced");
            }
        });

    }

}
