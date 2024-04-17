package org.assessment.ub5;

import java.util.HashMap;
import java.util.Map;

/**
 * Find winner based on character
 */
public class CoderFriends {

    public static int getScore(String word, Map<Character, Integer> scoreMap) {
        if (word == null || word.length() == 0) {
            return 0;
        }

        char[] chars = word.toCharArray();
        int score=0;
        for (Character c: chars) {
            score += scoreMap.getOrDefault(c, 0);
        }

        return score;
    }

    public static String winner(String erica, String bob) {
        Map<Character, Integer> scoreMap = new HashMap<>();
        scoreMap.put('E', 1);
        scoreMap.put('M', 3);
        scoreMap.put('H', 5);

        int ericaScore = getScore(erica, scoreMap);
        int bobScore = getScore(bob, scoreMap);

        if (ericaScore > bobScore)
            return "Erica";
        else if (ericaScore < bobScore)
            return "Bob";
        else
            return "Tie";
    }

    public static void main(String[] args) {
        String erica = "E";
        String bob = "E";
        System.out.println("Winner: " + winner(erica, bob));

        erica = "EHH";
        bob = "EME";
        System.out.println("Winner: " + winner(erica, bob));
    }

}
