package com.vishaluplanch.kafka.controller;

import com.vishaluplanch.kafka.model.Tutorial;
import com.vishaluplanch.kafka.producer.SpringBootKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SpringBootKafkaRestController {

    @Autowired
    SpringBootKafkaProducer springBootKafkaProducer;

    @GetMapping(value = "/send/{message}")
    public void send(@PathVariable String message) {
        springBootKafkaProducer.sendMessage(message);
    }

    @PostMapping(value = "/send")
    public void send(@RequestBody Tutorial tutorial) {
        springBootKafkaProducer.sendMessage(tutorial);
    }

}
