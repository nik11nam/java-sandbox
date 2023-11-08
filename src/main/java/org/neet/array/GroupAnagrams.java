package org.neet.array;

import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * 1. Iterate through each string and split each word to char[]
 * 2. Sort the char[] and create a new string
 * 3. Use the sorted string as key of hashmap to hold the anagrams in map
 *
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] input) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : input) {
            char[] wordChars = word.toCharArray();
            Arrays.sort(wordChars);
            String sortedWord = new String(wordChars);

            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }

            List<String> words = map.get(sortedWord);
            words.add(word);

            map.put(sortedWord, words);
        }

        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) {
        String[] input = {"eat","tea","tan","ate","nat","bat"};

        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(input));
    }
}
