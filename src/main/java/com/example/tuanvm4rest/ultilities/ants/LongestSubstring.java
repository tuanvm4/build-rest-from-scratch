package com.example.tuanvm4rest.ultilities.ants;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public static String findLongest(String s) {
        int left = 0;
        int maxStart = 0;
        int maxLen = 0;

        Set<Character> set = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            while (set.contains(current)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(current);

            if (right - left + 1 > maxLen) {
                maxLen = right - left + 1;
                maxStart = left;
            }
        }

        return s.substring(maxStart, maxStart + maxLen);
    }

    public static void main(String[] args) {
        System.out.println(findLongest("java2novice"));
        System.out.println(findLongest("java_language_is_sweet"));
        System.out.println(findLongest("pwwkew"));
    }
}