package org.neet.array;

/**
 * Use two pointers tracking both arrays
 *
 * 1. check if s[i] == t[j] , if yes then increase both i and j,
 * 2. if not, then increase only j++;
 * 3. In the end, if ( i == size of s ), return true, else return false.
 */
public class IsSubSequence {

    public boolean isSubSequence(String s, String t) {
        int i = 0, j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        if (i == s.length())
            return true;

        return false;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "axdbvhc";

        IsSubSequence ss = new IsSubSequence();
        System.out.println(ss.isSubSequence(s, t));
    }

}
