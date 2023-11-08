package org.neet.array;

/**
 *
 * 1. Start from end of the string
 * 2. Find the length of the string ignoring the trailing spaces
 * 3. Stop the loop at the first white space
 *
 */
public class LengthOfLastWord {

    // O(n)
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1, length = 0;

        // To remove the trailing spaces
        while (s.charAt(i) == ' ') {
            i -= 1;
        }

        while (i >= 0 && s.charAt(i) != ' ') {
            length += 1;
            i -= 1;
        }
        return length;
    }

    // Using built in functions
    public int lengthOfLastWord2(String s) {
        if (s == null)
            return 0;

        String trimmed = s.trim();
        String[] words = trimmed.split(" ");
        String word = words[words.length - 1];

        return word.trim().length();
    }

    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";

        LengthOfLastWord lw = new LengthOfLastWord();
        System.out.println(lw.lengthOfLastWord(s));
    }

}
