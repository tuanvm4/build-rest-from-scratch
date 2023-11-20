package com.example.tuanvm4rest.ultilities;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sum = numbers.stream()               // Convert the list to a stream
                .filter(n -> n % 2 != 0)             // Filter out even numbers
                .mapToInt(n -> n * 2)                 // Double each remaining number
                .sum();                               // Sum the resulting values

        optionalTest();
    }

    public static void optionalTest() {
        // Example 1: Using orElseGet with a fallback value
        Optional<String> optionalValue = Optional.ofNullable(getStringFromExternalSource());
        Optional<String> optionalValue1 = Optional.of("This is test string tuarn");
        String result1 = optionalValue.orElseGet(() -> "Default Value");

        System.out.println("Result 0: " + "result0");
        System.out.println("Result 1: " + result1);

        // Example 2: Using orElseGet with a supplier function
        String result2 = optionalValue.orElseGet(() -> generateDefaultValue());
        System.out.println("Result 2: " + result2);
    }

    private static String getStringFromExternalSource() {
        // Simulating getting a value from an external source
        return null; // This could be null in a real scenario
    }

    private static String generateDefaultValue() {
        // Simulating generating a default value
        return "Generated Default Value";
    }

}
