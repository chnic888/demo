package com.chnic.demo.util;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author xxx
 */
public class RandomGeneratorUtil {
    private static final Random RANDOM = new Random();

    public static String generateMobileNumber() {
        return IntStream.range(0, 9).map(i -> Math.abs(RANDOM.nextInt(10)))
                .collect(() -> new StringBuilder("13"), StringBuilder::append, StringBuilder::append)
                .toString();
    }

    public static String generateName() {
        return IntStream.range(0, 8).map(i -> Math.abs(new Random().nextInt(25)) + 97)
                .mapToObj(i -> (char) i)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}
