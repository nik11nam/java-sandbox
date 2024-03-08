package org.neet.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Input: s = "egg", t = "add"
 * Output: true
 *
 * Input: s = "bar", t = "foo"
 * Output: false
 * Explanation: In 2nd iteration a -> o and 3rd iteration r -> o, so o -> a,r which is invalid
 *
 */
public class IsomorphicString {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();

        int i=0, j=0;
        while(i < s.length() && j < s.length()) {
            if ((mapS.containsKey(s.charAt(i)) && (mapS.get(s.charAt(i)) != t.charAt(j))) ||
                    (mapT.containsKey(t.charAt(j)) && (mapT.get(t.charAt(j)) != s.charAt(i)))) {
                return false;
            }

            mapS.put(s.charAt(i), t.charAt(j));
            mapT.put(t.charAt(j), s.charAt(i));

            i++;
            j++;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "bar";
        String t = "foo";

        IsomorphicString is = new IsomorphicString();
        System.out.println(is.isIsomorphic(s, t));
    }

}
