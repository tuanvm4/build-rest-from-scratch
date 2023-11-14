package com.example.tuanvm4rest.ultilities;

import java.util.Arrays;
import java.util.List;

public class StreamExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sum = numbers.stream()               // Convert the list to a stream
                .filter(n -> n % 2 != 0)             // Filter out even numbers
                .mapToInt(n -> n * 2)                 // Double each remaining number
                .sum();                               // Sum the resulting values

        System.out.println("Sum of doubled odd numbers: " + sum);
    }
}
