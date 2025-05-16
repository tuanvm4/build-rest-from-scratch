package com.example.tuanvm4rest.ultilities.leetcode.medium;

import java.util.HashMap;

/**
 * Problem Description:
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            if (charMap.containsKey(currentChar)) {
                // Move the left pointer to the right of the same character last found
                left = Math.max(left, charMap.get(currentChar) + 1);
            }

            // Update the current character's position
            charMap.put(currentChar, right);
            // Calculate the max length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb")); // Output: 3
        System.out.println(solution.lengthOfLongestSubstring("abcder12345666t")); // Output: 1
        System.out.println(solution.lengthOfLongestSubstring("pwwkew")); // Output: 3
    }
}
