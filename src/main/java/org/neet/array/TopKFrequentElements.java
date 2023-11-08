package org.neet.array;

import java.util.*;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 */
public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {

        // Iterate through the array and create a map of number with count
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int n : nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }

        // Create a array with size == intial length of array and store the key in the corresponding index (ie, count)
        Integer[] frequencyList = new Integer[nums.length + 1];
        for (Map.Entry<Integer,Integer>  entry : countMap.entrySet()) {
            frequencyList[entry.getValue()] = entry.getKey();
        }

        int resultIndex = 0;
        int[] result = new int[k];
        for (int i=frequencyList.length; i>=0; i--) {
            if (frequencyList[i-1] != null) {
                result[resultIndex++] = frequencyList[i-1];
                if (resultIndex >= k)
                    break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,1,2,2,3};
        int k = 2;

        System.out.println(Arrays.toString(topKFrequent(nums1, 2)));

        int[] nums2 = {1};
        k = 1;

        System.out.println(Arrays.toString(topKFrequent(nums2, 1)));
    }
}
