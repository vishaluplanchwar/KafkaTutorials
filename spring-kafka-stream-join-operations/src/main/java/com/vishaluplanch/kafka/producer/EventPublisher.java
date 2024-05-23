package com.vishaluplanch.kafka.producer;

import com.vishaluplanch.kafka.avro.schema.AccountDetail;
import com.vishaluplanch.kafka.util.BankUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.nio.file.Files;
import java.util.Random;

@RestController
public class EventPublisher {

    @Value("${spring.kafka.abc.bank.topic}")
    private String abcBankAccountTopic;

    @Value("${spring.kafka.xyz.bank.topic}")
    private String xyzBankAccountTopic;

    @Autowired
    private KafkaTemplate<Long, AccountDetail> abcBankKafkaTemplate;
    @Autowired
    private KafkaTemplate<Long, AccountDetail> xyzBankKafkaTemplate;

    private Random random = new Random();

    @GetMapping(value = "/generateAccounts")
    public void publish() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            long key = random.longs(9999, 99999999).findAny().getAsLong();
            if (i % 2 == 0) {
                xyzBankKafkaTemplate.send(xyzBankAccountTopic, key, BankUtils.generateXyzBankAccount(key, i));
                Thread.sleep(9000);
                abcBankKafkaTemplate.send(abcBankAccountTopic, key, BankUtils.generateAbcBankAccount(key, i));
            } else {
                key = random.longs(9999, 99999999).findAny().getAsLong();
                xyzBankKafkaTemplate.send(xyzBankAccountTopic, key, BankUtils.generateXyzBankAccount(key, i));
                key = random.longs(9999, 99999999).findAny().getAsLong();
                abcBankKafkaTemplate.send(abcBankAccountTopic, key, BankUtils.generateAbcBankAccount(key, i));
            }
        }
    }
}
