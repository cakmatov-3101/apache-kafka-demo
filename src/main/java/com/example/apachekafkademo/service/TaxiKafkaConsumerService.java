package com.example.apachekafkademo.service;

import com.example.apachekafkademo.entity.Coordinates;
import com.example.apachekafkademo.utils.CoordinateUtils;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class TaxiKafkaConsumerService {

    private static Map<UUID, List<Coordinates>> savedCoordinates;

    @KafkaListener(topics = "coordinates-topic", groupId = "group-1")
    public void consumeCoordinates(Coordinates coordinates) {
        System.out.println(coordinates);
        addCoordinates(coordinates);
    }

    private void addCoordinates(Coordinates c) {
        List<Coordinates> carCoordinates = savedCoordinates.get(c.getCarId());
        if (carCoordinates == null) {
            carCoordinates = new LinkedList<Coordinates>();
            carCoordinates.add(c);
            savedCoordinates.put(c.getCarId(), carCoordinates);
            System.out.println(String.format("Car %s has just started moving", c.getCarId()));
        } else {
            carCoordinates.add(c);
            double totalDistance = 0.0;
            for (int i = 1; i < carCoordinates.size(); i++) {
                totalDistance += CoordinateUtils.calculateDistanse(carCoordinates.get(i - 1), carCoordinates.get(i));
            }
            System.out.println(String.format("Car: %s", c.getCarId()));
            System.out.println(String.format("Total distance: %d", totalDistance));
        }
    }


}
