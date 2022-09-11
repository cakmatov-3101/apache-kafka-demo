package com.example.apachekafkademo.utils;

import com.example.apachekafkademo.entity.Coordinates;

public class CoordinateUtils {

    public static double calculateDistanse(Coordinates c1, Coordinates c2) {
        double R = 6371e3;
        double f1 = c1.getLat() * Math.PI / 180; // φ, λ in radians
        double f2 = c2.getLat() * Math.PI / 180;

        double df = (c2.getLat() - c1.getLat()) * Math.PI / 180;
        double dl = (c2.getLon() - c1.getLon()) * Math.PI / 180;

        double a = Math.sin(df/2) * Math.sin(df/2) + Math.cos(f1) * Math.cos(f2) * Math.sin(dl/2) * Math.sin(dl/2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double d = R * c; // in metres;

        return d;
    }
}
