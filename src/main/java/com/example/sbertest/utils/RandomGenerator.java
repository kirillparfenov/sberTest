package com.example.sbertest.utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * RandomGenerator - класс, который занимается генерацией рандомных значений
 */
public class RandomGenerator {

    public static boolean generateRandomBoolean() {
        return ThreadLocalRandom.current().nextBoolean();
    }

    public static long generateRandomLong() {
        return ThreadLocalRandom.current().nextLong(1,11);
    }
}
