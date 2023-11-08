package org.assessment.ub1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Shortest substring containing characters
 * https://medium.com/algorithm-and-datastructure/smallest-substring-of-all-characters-27a935ba4607
 */
public class ShortestSubstring {

    private static String EMPTY = "";

    public static void main(String[] args) {
        System.out.println(shortestSubstring("dabbcabcd"));
    }

    public static int shortestSubstring(String givenString) {
        Set<Character> distinctChars = getDistinctChars(givenString);
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : distinctChars) {
            charMap.put(c, 0);
        }

        String result = EMPTY;
        int head = 0;
        int counter = 0;
        char headChar;
        for (int i = head; i < givenString.length(); i++) {
            char c = givenString.charAt(i);
            if (!charMap.containsKey(c)) {
                continue;
            }

            int charCount = charMap.get(c);
            if (charCount == 0) {
                counter = counter + 1;
            }
            charMap.put(c, charMap.get(c) + 1);

            int charLength = distinctChars.size();
            while (counter == charLength) {
                int tempLength = (i - head) + 1;
                if (tempLength == charLength) {
                    return givenString.substring(head, i + 1).length();
                }

                if (result.equals(EMPTY) || tempLength < result.length()) {
                    result = givenString.substring(head, i + 1);
                }
                headChar = givenString.charAt(head);

                if(charMap.containsKey(headChar)) {
                    int headCount=charMap.get(headChar) - 1;
                    if(headCount == 0) {
                        counter = counter - 1;
                    }
                    charMap.put(headChar,headCount);
                }
                head = head + 1;
            }
        }

        return result.length();
    }

    public static Set<Character> getDistinctChars(String givenString) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < givenString.length(); ++i) {
            set.add(givenString.charAt(i));
        }
        return set;
    }

}
