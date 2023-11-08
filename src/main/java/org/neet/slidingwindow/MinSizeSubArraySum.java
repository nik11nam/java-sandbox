package org.neet.slidingwindow;

/**
 * Given an array of positive integers a and positive number K, find the length of the smallest contiguous subarray
 * whose sum is greater than or equal to K. Return 0 if no such subarray exists.
 *
 * Input: a = [2, 1, 4, 3, 2, 5], K = 7
 * Output: 2
 * Explanation: The smallest subarray with a sum greater than or equal to '7' is [4, 3]
 */
public class MinSizeSubArraySum {

    // O(n^2)
    private static int findLengthOfMinSizeSubArraySumBruteForce(int[] input, int k) {
        int length = input.length;
        int lengthMinSubArray = Integer.MAX_VALUE;

        for (int i=0; i<length; i++) {
            int subArraySum = 0;

            for (int j=i; j<length; j++) {
                subArraySum += input[j];

                if (subArraySum >= k) {
                    lengthMinSubArray = Math.min(lengthMinSubArray, j-i+1);
                    break;
                }
            }
        }
        return lengthMinSubArray == Integer.MAX_VALUE ? 0 : lengthMinSubArray;
    }

    // O(n)
    private static int findLengthOfMinSizeSubArraySum(int[] input, int k) {
        int length = input.length;
        int lengthMinSubArray = Integer.MAX_VALUE;
        int windowSum = 0;

        int windowStart=0;
        for (int windowEnd=0; windowEnd < length; windowEnd++) {
            windowSum += input[windowEnd]; // Add the next element to the window

            if (windowSum >= k) { // Shrink the window as small as possible until the 'windowSum' is smaller than 'K'
                lengthMinSubArray = Math.min(lengthMinSubArray, windowEnd-windowStart+1);
                windowSum -= input[windowStart]; // Discard the element at 'windowStart' since it is going out of the window
                windowStart++; // Shrink the window
            }
        }

        return lengthMinSubArray == Integer.MAX_VALUE ? 0 : lengthMinSubArray;
    }

    /**
     * Find the length of the smallest contiguous subarray whose sum is equal to K
     *
     * @param input
     * @param k
     * @return
     */
    // O(n)
    private static int findLengthOfMinSizeSubArraySumEqualToK(int[] input, int k) {
        int length = input.length;
        int lengthMinSubArray = Integer.MAX_VALUE;
        int windowSum = 0;

        int windowStart=0;
        for (int windowEnd=0; windowEnd < length; windowEnd++) {
            windowSum += input[windowEnd]; // Add the next element to the window

            if (windowSum == k) {
                lengthMinSubArray = Math.min(lengthMinSubArray, windowEnd-windowStart+1);
            }

            if (windowSum == k || windowSum > k) {
                windowSum -= input[windowStart]; // Discard the element at 'windowStart' since it is going out of the window
                windowStart++; // Shrink the window
            }
        }

        return lengthMinSubArray == Integer.MAX_VALUE ? 0 : lengthMinSubArray;
    }

    public static void main(String[] args) {
        int[] input = {3, 4, 1, 1, 2, 1};
        int k = 9;

        System.out.println(findLengthOfMinSizeSubArraySum(input, k));
        System.out.println(findLengthOfMinSizeSubArraySumEqualToK(input, k));
    }
}
