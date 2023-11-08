package org.neet.slidingwindow;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of integers a, and an integer k, find the maximum for each and every contiguous subarray of size k
 *
 * Input: a[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, k = 3
 * Output: 3 3 4 5 5 5 6
 */
public class MaxOfSubArray {

    private static int[] maxOfSubArrayBruteForce(int[] input, int k) {
        int length = input.length;
        int[] results = new int[length - k + 1];
        int idx = 0;

        for (int i=0; i < length-k+1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j=i; j < i+k; j++) {
                if (input[j] > max) {
                    max = input[j];
                }
            }
            results[idx++] = max;
        }
        return results;
    }

    private static int[] maxOfSubArray(int[] input, int k) {
        int length = input.length;
        int[] results = new int[length - k + 1];
        int idx = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < length; windowEnd++) {
            q.add(input[windowEnd]);

            if(windowEnd-windowStart+1 == k) { // We've hit the window size. Find the maximum in the current window and Slide the window ahead
                int maxElement = q.peek();
                results[idx++] = maxElement;

                if(maxElement == input[windowStart]) { // Discard a[windowStart] since we are sliding the window now. So it is going out of the window.
                    q.remove();
                }

                windowStart++; // Slide the window ahead
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;

        System.out.println(Arrays.toString(maxOfSubArray(input, k)));
    }

}
