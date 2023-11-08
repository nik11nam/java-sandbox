package org.neet.array;

/**
 *
 * 1. Pick the first word in the list and iterate each character
 * 2. In inner loop, compare against each character from other words
 * 3. Stop if any word length == first word length (to handle smaller word)
 *    or any char mismatch
 *
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] words) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<words[0].length(); i++) {
            for (String word : words) {
                if (i == word.length() || words[0].charAt(i) != word.charAt(i))
                    return sb.toString();
            }
            sb.append(words[0].charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = {"flower","flow","flight"};

        LongestCommonPrefix lcp = new LongestCommonPrefix();
        System.out.println(lcp.longestCommonPrefix(words));
    }

}
