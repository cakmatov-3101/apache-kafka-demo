package com.example.apachekafkademo.entity;

import java.util.UUID;

public class Coordinates {

    private UUID carId;
    private long timestamp;
    private double lat;
    private double lon;

    public Coordinates() {
    }

    public Coordinates(UUID carId, long timestamp, double lat, double lon) {
        this.carId = carId;
        this.timestamp = timestamp;
        this.lat = lat;
        this.lon = lon;
    }

    public UUID getCarId() {
        return carId;
    }

    public void setCarId(UUID carId) {
        this.carId = carId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "carId=" + carId +
                ", timestamp=" + timestamp +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
