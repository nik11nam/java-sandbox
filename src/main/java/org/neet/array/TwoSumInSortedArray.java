package org.neet.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumInSortedArray {

    // Will only work for sorted input array
    private static int[] pairSumUsingTwoPointers(int[] nums, int target) {
        int[] result = new int[2];

        int left = 0, right = nums.length-1;
        while(left < right) {
            if (nums[left] + nums[right] == target) {
                result[0] = left;
                result[1] = right;
                return result;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }

        // No results, default to -1
        result[0] = -1;
        result[1] = -1;
        return result;
    }

    private static int[] pairSumUsingHashing(int[] nums, int target) {
        int[] result = new int[2];

        // Store the number with array index as value
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int expected = target - nums[i];
            if (indexMap.containsKey(expected)) {
                result[0] = indexMap.get(expected);
                result[1] = i;
                return result;
            } else {
                indexMap.put(nums[i], i);
            }
        }

        // No results, default to -1
        result[0] = -1;
        result[1] = -1;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 10};
        int target = 7;

        System.out.println(Arrays.toString(pairSumUsingTwoPointers(nums, target)));

        System.out.println(Arrays.toString(pairSumUsingHashing(nums, target)));
    }

}
