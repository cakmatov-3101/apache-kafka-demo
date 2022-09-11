package com.example.apachekafkademo.serialization;

import com.example.apachekafkademo.entity.Coordinates;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class CoordinatesSerializer implements Serializer<Coordinates> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map configs, boolean isKey) {
        Serializer.super.configure(configs, isKey);
    }


    @Override
    public byte[] serialize(String s, Coordinates coordinates) {
        try {
            if (coordinates == null){
                System.out.println("Null received at serializing");
                return null;
            }
            System.out.println("Serializing...");
            return objectMapper.writeValueAsBytes(coordinates);
        } catch (Exception e) {
            throw new SerializationException("Error when serializing Coordinates to byte[]");
        }
    }

    @Override
    public void close() {
    }
}
