package com.vishaluplanch.org.producer;

import com.vishaluplanch.org.schemas.LoanDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class LoanDetailKafkaProducer {

    @Value("${topic.source.name}")
    String topicName;

    @Autowired
    private KafkaTemplate<Long, LoanDetail> kafkaTemplate;

    public void send(LoanDetail loanDetail) {
        ListenableFuture<SendResult<Long, LoanDetail>> future = kafkaTemplate.send(topicName, loanDetail.getLoanId(), loanDetail);
        future.addCallback(new ListenableFutureCallback<SendResult<Long, LoanDetail>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Message failed to produce");
            }

            @Override
            public void onSuccess(SendResult<Long, LoanDetail> result) {
                System.out.println("Avro message successfully produced");
            }
        });
    }

}
