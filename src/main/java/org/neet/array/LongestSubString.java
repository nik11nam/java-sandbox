package org.neet.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest Substring Without Repeating Characters
 */
public class LongestSubString {

    // O(n) - sliding window
    private static int longestSubstring(String str) {
        if (str.length() < 1)
            return 0;

        if (str.length() == 1)
            return 1;

        int left = 0, right = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (right < str.length()) {
            if (!set.contains(str.charAt(right))) {
                set.add(str.charAt(right++));
                max = Math.max(max, set.size());
            } else {
                set.remove(str.charAt(left++));
            }
        }
        return max;
    }

    // O(n2) - Brute Force
    private static int longestSubstringBruteForce(String str) {
        String word = "", maxWord = "";
        for (int i=0; i < str.length()-1; i++) {
            word = str.substring(i, i+1);
            for (int j=i+1; j < str.length(); j++) {
                if (word.contains(str.substring(j, j+1))) {
                    break;
                } else {
                    word += str.substring(j, j+1);
                }
            }

            if (word.length() > maxWord.length()) {
                maxWord = word;
            }
        }

        return maxWord.length();
    }

    public static void main(String[] args) {
        String str = "abcabcbb";

        System.out.println(longestSubstringBruteForce(str));
        System.out.println(longestSubstring(str));
    }

}
