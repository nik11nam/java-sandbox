package org.assessment.ub6;

import java.util.*;

/**
 * https://leetcode.com/discuss/interview-question/512765/lucid-oa-digit-sum
 */
public class DigitSum {

    public static List<Long> waysToChooseSum(long lowLimit, long highLimit) {

        // Create a list to store the result i.e total number of ways to choose sum so that max possible participants win the lottery, number of participants who will win the lottery
        List<Long> finalResult = new ArrayList<>();

        // Create a HashMap to store the number of times each sum appears
        Map<Long,Long> map = new HashMap<>();

        // Loop through the lowLimit and highLimit to get the List of Sum of digits of each number
        for (Long i = lowLimit; i <= highLimit; i++) {
            Long j = i;
            Long sum = 0L;
            while (j != 0) {
                sum = sum + j % 10;
                j /= 10L;
            }
            if(map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1L);
            }else {
                map.put(sum, 1L);
            }
        }
        System.out.println("Map: " + map);

        // The max number of winners will be the maximum value in the map
        Long winners = Collections.max(map.values());
        System.out.println("Number of winners: " + winners);

        // To get the number of winners, count the number of keys that have the maximum values in the map
        Long ways = 0L;
        for (Long sum : map.values()) {
            if(Objects.equals(sum, winners)){
                ways++;
            }
        }
        System.out.println("Number of ways to win: " + ways);

        finalResult.add(ways);
        finalResult.add(winners);

        return finalResult;
    }

    public static void main(String[] args) {
        long lowLimit = 1;
        long highLimit = 5;
        System.out.println(waysToChooseSum(lowLimit, highLimit));

        lowLimit = 3;
        highLimit = 12;
        System.out.println(waysToChooseSum(lowLimit, highLimit));
    }

}
