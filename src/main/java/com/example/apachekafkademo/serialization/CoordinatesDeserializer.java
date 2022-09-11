package com.example.apachekafkademo.serialization;

import com.example.apachekafkademo.entity.Coordinates;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.springframework.core.serializer.Deserializer;

import java.io.IOException;
import java.io.InputStream;

public class CoordinatesDeserializer implements Deserializer<Coordinates> {

    private ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public Coordinates deserialize(InputStream inputStream) throws IOException {
        return null;
    }

    @Override
    public Coordinates deserializeFromByteArray(byte[] serialized) throws IOException {
        try {
            if (serialized == null){
                System.out.println("Null received at deserializing");
                return null;
            }
            System.out.println("Deserializing...");
            return objectMapper.readValue(new String(serialized, "UTF-8"), Coordinates.class);
        } catch (Exception e) {
            throw new SerializationException("Error when deserializing byte[] to Coordinates");
        }
    }
}
