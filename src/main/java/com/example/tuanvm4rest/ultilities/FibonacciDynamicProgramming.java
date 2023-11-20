package com.example.tuanvm4rest.ultilities;

public class FibonacciDynamicProgramming {

    // Using dynamic programming to compute the nth Fibonacci number
    public static int fibonacci(int n) {
        int[] dp = new int[n + 1];

        // Base cases
        dp[0] = 0;
        dp[1] = 1;

        // Fill the array using dynamic programming
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static int fibonacciExhausted(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacciExhausted(n - 1) + fibonacciExhausted(n - 2);
        }
    }


    public static void main(String[] args) {
        int n = 28; // Calculate the 40th Fibonacci number
        long startTime, endTime;

        // Measure run time for dynamic programming solution
        startTime = System.currentTimeMillis();
        int resultDynamicProgramming = fibonacci(n);
        endTime = System.currentTimeMillis();
        System.out.println("Dynamic Programming Result: " + resultDynamicProgramming);
        System.out.println("Dynamic Programming Run Time: " + (endTime - startTime) + " milliseconds");

        // Measure run time for recursive solution
        startTime = System.currentTimeMillis();
        int resultRecursive = fibonacciExhausted(n);
        endTime = System.currentTimeMillis();
        System.out.println("Recursive Result: " + resultRecursive);
        System.out.println("Recursive Run Time: " + (endTime - startTime) + " milliseconds");
    }
}

