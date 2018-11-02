package org.itmodreamteam.medicine.service;

import org.itmodreamteam.medicine.model.Measurement;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * As time goes, we get more and more measurements of patient
 */
public class Measurer {

    public static Measurement measure() {
        LocalDateTime now = LocalDateTime.now();
        int todayMinutes = now.getHour() * 60 + now.getMinute();
        byte[] measurements = new byte[todayMinutes];
        ThreadLocalRandom.current().nextBytes(measurements);
        System.out.format("%d measurements for now: %s\n", todayMinutes, Arrays.toString(measurements));
        return new Measurement();
    }
}
