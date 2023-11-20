package com.example.tuanvm4rest.ultilities;

public class SlidingWindowExample {

    public static int maxSumSubarray(int[] arr, int k) {
        int n = arr.length;

        // Handle edge case
        if (n < k) {
            System.out.println("Window size is larger than array size");
            return -1;
        }

        // Initialize the initial sum
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        int maxSum = windowSum;

        // Process the rest of the array using the sliding window
        for (int i = k; i < n; i++) {
            windowSum = windowSum - arr[i - k] + arr[i];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 2, 3, 1, 0, 20, 5};
        int k = 4;

        int result = maxSumSubarray(arr, k);

        if (result != -1) {
            System.out.println("Maximum sum of subarray of size " + k + ": " + result);
        }
    }
}
