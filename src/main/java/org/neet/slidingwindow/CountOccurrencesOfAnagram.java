package org.neet.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CountOccurrencesOfAnagram {

    // Two words are anagrams of each other if the count of every character in both the words are same.
    private static boolean isAnagram(Map<Character, Integer> wordCharCount,
                                     Map<Character, Integer> subTextCharCount) {
        for (char c : wordCharCount.keySet()) {
            if (wordCharCount.get(c) != subTextCharCount.get(c)) {
                return false;
            }
        }
        return true;
    }

    private static int countOccurrenceOfAnagram(String text, String word) {
        // Calculate the count of each character for the given word
        Map<Character, Integer> wordCharCount = new HashMap<>();
        for (Character c : word.toCharArray()) {
            wordCharCount.put(c, wordCharCount.getOrDefault(c, 0) + 1);
        }

        // Stores the character count for the current substring (current window)
        Map<Character, Integer> subTextCharCount = new HashMap<>();
        int wordLength = word.length();
        int start = 0, count = 0;

        for(int end=0; end < text.length(); end++) {
            char c = text.charAt(end);
            // Include the next char in the window
            subTextCharCount.put(c, subTextCharCount.getOrDefault(c, 0) + 1);

            // We've hit the window size. Calculate result and slide the window
            if ((end - start+1) == wordLength) {
                if (isAnagram(wordCharCount, subTextCharCount)) {
                    count++;
                }

                // Reduce count for the char at windowStart since we are sliding the window now
                subTextCharCount.put(text.charAt(start), subTextCharCount.get(text.charAt(start))-1);
                start++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String text = "forxxorfxdofr";
        String word = "for";

        System.out.println(countOccurrenceOfAnagram(text, word));
    }
}
