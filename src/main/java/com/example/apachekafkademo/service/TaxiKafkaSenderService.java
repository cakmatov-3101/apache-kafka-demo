package com.example.apachekafkademo.service;

import com.example.apachekafkademo.entity.Coordinates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class TaxiKafkaSenderService {

    @Value(value = "${kafka.topic.name}")
    private String topicName;

    private KafkaTemplate kafkaTemplate;

    @Autowired
    public TaxiKafkaSenderService(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendCoordinates(Coordinates coordinates) {
        kafkaTemplate.send(topicName, coordinates);
    }
}
