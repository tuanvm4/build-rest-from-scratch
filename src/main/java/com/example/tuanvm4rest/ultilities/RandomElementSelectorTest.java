package com.example.tuanvm4rest.ultilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomElementSelectorTest {
    public static void main(String[] args) {
        // Create a list with elements
        List<String> elements = List.of("Element 1", "Element 2", "E 4", "E5", "E6");
        long startTime = System.currentTimeMillis();

        // Number of iterations for testing
        int iterations = 100000;

        // Count occurrences of each element
        Map<String, Integer> elementCounts = new HashMap<>();
        for (String element : elements) {
            elementCounts.put(element, 0);
        }

        // Perform random selections and count occurrences
        for (int i = 0; i < iterations; i++) {
            String selectedElement = RandomElementSelector.getRandomElement(elements);
            elementCounts.put(selectedElement, elementCounts.get(selectedElement) + 1);
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Elapsed Time: " + elapsedTime + " milliseconds");

        // Print the results
        for (Map.Entry<String, Integer> entry : elementCounts.entrySet()) {
            String element = entry.getKey();
            int count = entry.getValue();
            double percentage = (count / (double) iterations) * 100;
            System.out.println(element + ": " + count + " occurrences (" + percentage + "%)");
        }
    }
}
