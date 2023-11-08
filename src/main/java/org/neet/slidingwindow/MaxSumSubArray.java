package org.neet.slidingwindow;

/**
 * Maximum sum of a subarray of size k
 */
public class MaxSumSubArray {

    private static int maxSum(int[] arr, int k) {
        if (arr == null || arr.length < k) {
            return -1;
        }

        int maxSum = 0;
        // Compute sum of first window of size k
        for (int i=0; i<k; i++) {
            maxSum += arr[i];
        }

        // Compute sums of remaining windows by removing first element of previous
        // window and adding last element of current window.
        int windowSum = maxSum;
        int index = k;
        while(index < arr.length) {
            windowSum += arr[index] - arr[index-k];
            if (windowSum > maxSum) {
                maxSum = windowSum;
            }
            index++;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        int k = 4;
        System.out.println(maxSum(arr, k));
    }
}
