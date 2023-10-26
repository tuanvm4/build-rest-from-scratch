package com.example.tuanvm4rest.ultilities;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomElementSelector {
    public static void main(String[] args) {
        // Creating a list with two elements
        List<String> elements = Arrays.asList("Element 1", "Element 2");
        for(int i = 0; i <1000; i ++) {

            String selectedElement = getRandomElement(elements);
            System.out.println("Randomly Selected Element: " + selectedElement);
        }

    }

    public static <T> T getRandomElement(List<T> elements) {
        if (elements == null || elements.isEmpty()) {
            throw new IllegalArgumentException("The input list is null or empty.");
        }

        // Generating a random index to select an element
        Random random = new Random();
        int randomIndex = random.nextInt(elements.size());

        // Selecting a random element from the list
        return elements.get(randomIndex);
    }
}