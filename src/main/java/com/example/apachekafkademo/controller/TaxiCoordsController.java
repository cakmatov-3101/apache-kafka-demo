package com.example.apachekafkademo.controller;

import com.example.apachekafkademo.entity.Coordinates;
import com.example.apachekafkademo.service.TaxiKafkaSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaxiCoordsController {

    @Autowired
    private TaxiKafkaSenderService senderService;

    @PostMapping("/coordinates/send")
    public ResponseEntity acceptCoordinates(@RequestBody Coordinates coordinates) {
        senderService.sendCoordinates(coordinates);
        return ResponseEntity.accepted().build();
    }
}
