package org.neet.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class LongestSequence {

    private static int findLongestSequence(int[] numbers) {
        Set<Integer> set = new HashSet<>(numbers.length);
        for (Integer num : numbers)
            set.add(num);

        int longest = 1;
        for (Integer num : numbers) {
            // check if the num is the start of a sequence by checking if left exists
            if (!set.contains(num-1)) { // start of a sequence
                int count = 1;
                while(set.contains(num + 1)) { // check if hs contains next no.
                    num++;
                    count++;
                }
                longest = Math.max(longest, count);
            }

            // Optimization
            if(longest > numbers.length/2) break;
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] numbers = {100, 3, 200, 4, 1, 2};

        System.out.println(findLongestSequence(numbers));
    }

}
