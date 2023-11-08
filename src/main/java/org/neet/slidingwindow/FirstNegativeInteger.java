package org.neet.slidingwindow;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an array of integers a, and a positive integer k, find the first negative integer for each and every window
 * (contiguous subarray) of size k.
 * If a window does not contain a negative integer, then print 0 for that window.
 *
 * Input: a[] = {-5, 1, 2, -6, 9}, k = 2
 * Output : -5 0 -6 -6
 *
 */
public class FirstNegativeInteger {

    private static int[] findFirstNegativeIntegerInSubArrayBruteForce(int[] input, int k) {
        int inputLength = input.length;

        int[] results = new int[inputLength - k + 1];
        int idx = 0;

        for (int i = 0; i < inputLength-k + 1; i++) {
            int firstNegativeNum = 0;
            for (int j = i; j < i+k; j++) {
                if (input[j] < 0) {
                    firstNegativeNum = input[j];
                    break;
                }
            }
            results[idx++] = firstNegativeNum;
        }

        return results;
    }

    private static int[] findFirstNegativeIntegerInSubArray(int[] input, int k) {
        int inputLength = input.length;

        int[] results = new int[inputLength - k + 1];
        int start = 0;
        int idx = 0;

        Queue<Integer> q = new LinkedList<>();

        for (int end=0; end < inputLength; end++) {
            if (input[end] < 0) {
                q.add(input[end]);
            }

            // Calculate result and slide the window
            if ((end - start+1) == k) {
                if (q.isEmpty()) {
                    results[idx++] = 0;
                } else {
                    int num = q.peek();
                    results[idx++] = num;

                    // Remove a[windowStart] from the queue since we need to slide the window now.
                    // But only if it was added to the queue previously
                    if (num == input[start]) {
                        q.remove();
                    }
                }

                // Slide the window ahead
                start++;
            }
      }

        return results;
    }

    public static void main(String[] args) {
        int[] input1 = {-5, 1, 2, -6, 9};
        int k = 2;

        int[] results = findFirstNegativeIntegerInSubArray(input1, k);
        System.out.println(Arrays.toString(results));

        int[] input2 = {10, -1, -5, 7, -15, 20, 18, 24};
        k = 3;

        results = findFirstNegativeIntegerInSubArray(input2, k);
        System.out.println(Arrays.toString(results));
    }
}
